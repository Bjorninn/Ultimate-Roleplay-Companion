package elieser.eu.urc.scenes.adnd;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import elieser.eu.urc.R;
import elieser.eu.urc.navigation.Navigator;
import elieser.eu.urc.widgets.UrcToolbar;

public class AdndMainScene extends Fragment
{
    public AdndMainScene()
    {
        // Required empty public constructor
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
        return inflater.inflate(R.layout.scene_adnd, container, false);
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
                getActivity().finish(); // TODO make sure there is another activity around
            }
        });

        ImageButton priestSpellButton = view.findViewById(R.id.priest_spells_button);
        priestSpellButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Navigator.navigationEvent(PriestSpellsListScene.class, (AppCompatActivity) getActivity());
            }
        });
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }
}
