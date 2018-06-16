package elieser.eu.urc.scenes.adnd;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import elieser.eu.urc.R;
import elieser.eu.urc.data.DataLoader;
import elieser.eu.urc.data.adnd.Spell;
import elieser.eu.urc.scenes.adnd.adapters.PriestSpellRecyclerViewAdapter;
import elieser.eu.urc.widgets.UrcToolbar;

public class PriestSpellsListScene extends Fragment
{
    public final static String Name = "ADnD Priest Spell List";

    private OnSpellChosenListener mListener;

    public PriestSpellsListScene()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PriestSpellsListScene.
     */
    public static PriestSpellsListScene newInstance()
    {
        PriestSpellsListScene fragment = new PriestSpellsListScene();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.scene_spell_list, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        UrcToolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStackImmediate();
            }
        });

        Context context = view.getContext();

        List<Spell> spells = DataLoader.getAdndPriestSpells(context);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new PriestSpellRecyclerViewAdapter(spells, (OnSpellChosenListener) getContext()));
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnSpellChosenListener)
        {
            mListener = (OnSpellChosenListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString() + " must implement OnSpellChosenListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }
}
