package elieser.eu.urc.scenes.genesys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import elieser.eu.urc.R;
import elieser.eu.urc.data.genesys.GenesysDataStore;
import elieser.eu.urc.navigation.Navigator;
import elieser.eu.urc.widgets.UrcToolbar;

public class GenesysMainScene extends Fragment
{
    private GenesysDataStore dataStore;
    private GenesysHelper helper;

    public GenesysMainScene()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        dataStore = new GenesysDataStore();
        dataStore.loadTalentData(getContext());
        dataStore.loadAdversariesData(getContext());
        dataStore.loadWeaponData(getContext());

        helper = new GenesysHelper(getActivity().getAssets());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.scene_genesys, container, false);
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
                Navigator.popFragmentBackStack((AppCompatActivity) getActivity());
            }
        });

        ImageButton genesysTalentButton = view.findViewById(R.id.genesys_talents_button);
        SetOnClickListener(genesysTalentButton, GenesysTalentListScene.class);

        ImageButton genesysAntagonistButton = view.findViewById(R.id.genesys_antagonists_button);
        SetOnClickListener(genesysAntagonistButton, GenesysAdversaryListScene.class);

        TextView textView = view.findViewById(R.id.testLabel);
        Spannable dicePool = helper.createBoostOrSetbackDicePool(getContext(), 4, true);
        textView.setText(dicePool);
    }

    private void SetOnClickListener(View button, final Class<? extends android.support.v4.app.Fragment> clazz)
    {
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Navigator.navigationEvent(clazz, (AppCompatActivity) getActivity());
            }
        });
    }
}
