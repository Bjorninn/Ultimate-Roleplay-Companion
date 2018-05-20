package elieser.eu.urc.scenes;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import elieser.eu.urc.R;
import elieser.eu.urc.data.DataLoader;
import elieser.eu.urc.data.JsonLoader;
import elieser.eu.urc.data.adnd.Spell;
import elieser.eu.urc.data.adnd.Spells;

public class PriestSpells extends Fragment
{
    private OnFragmentInteractionListener mListener;

    public PriestSpells()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PriestSpells.
     */
    public static PriestSpells newInstance()
    {
        PriestSpells fragment = new PriestSpells();
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
        Context context = view.getContext();

        List<Spell> spells = DataLoader.getAdndPriestSpells(context);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new PriestSpellRecyclerViewAdapter(spells, (OnFragmentInteractionListener) getContext()));

        return view;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
        {
            mListener = (OnFragmentInteractionListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }
}
