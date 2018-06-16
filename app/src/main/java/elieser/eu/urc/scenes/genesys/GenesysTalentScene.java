package elieser.eu.urc.scenes.genesys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import elieser.eu.urc.R;
import elieser.eu.urc.data.BundleKeys;
import elieser.eu.urc.data.genesys.GenesysDataStore;
import elieser.eu.urc.data.genesys.Talent;
import elieser.eu.urc.navigation.Navigator;

/**
 * Created by bjornjonsson on 10/03/2018.
 */

public class GenesysTalentScene extends Fragment
{
    private TextView name;
    private TextView tier;
    private TextView activation;
    private TextView ranked;
    private TextView prerequisite;
    private TextView description;
    private TextView keywords;
    private TextView source;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.scene_genesys_talent, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.talent_name);
        tier = view.findViewById(R.id.talent_tier);
        activation = view.findViewById(R.id.talent_activation);
        ranked = view.findViewById(R.id.talent_ranked);
        prerequisite = view.findViewById(R.id.talent_prerequisite);
        description = view.findViewById(R.id.talent_description);
        keywords = view.findViewById(R.id.talent_keywords);
        source = view.findViewById(R.id.talent_source);

        String talentName = getArguments().getString(BundleKeys.NAME);
        Talent talent = GenesysDataStore.getInstance().getTalent(talentName);

        LoadTalent(talent);

        Button backButton = view.findViewById(R.id.talent_back_button);
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Navigator.popFragmentBackStack((AppCompatActivity) getActivity());
            }
        });

        ImageView prevTalentButton = view.findViewById(R.id.prev_talent_btn);
        prevTalentButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
            }
        });
    }

    private void LoadTalent(Talent talent)
    {
        name.setText(TalentHelper.createNameSpannable(talent.getName()));
        tier.setText(TalentHelper.createTierSpannable(talent.getTier().toString()));
        activation.setText(TalentHelper.createActivationSpannable(talent.getActivation()));

        if (talent.getRanked())
        {
            ranked.setText(TalentHelper.createRankedSpannable("Yes"));
        }
        else
        {
            ranked.setText(TalentHelper.createRankedSpannable("No"));

        }

        if (talent.getRequirement() != 0)
        {
            Talent prereqTalent = GenesysDataStore.getInstance().getTalent(talent.getRequirement());
            prerequisite.setVisibility(View.VISIBLE);
            prerequisite.setText(TalentHelper.createPrerequisiteSpannable(prereqTalent.getName()));
        }
        else
        {
            prerequisite.setVisibility(View.GONE);
        }

        description.setText(talent.getDescription());

        if (talent.hasKeywords())
        {
            keywords.setVisibility(View.VISIBLE);
            keywords.setText(TalentHelper.createKeywordsSpannable(talent.getKeywords()));
        }
        else
        {
            keywords.setVisibility(View.GONE);
        }

        description.setText(TalentHelper.createDescriptionSpannable(talent.getDescription()));
        //description.setText(TalentHelper.testFont(getActivity().getAssets(), talent.getDescription()));
        //description.setText(talent.getDescription());
        source.setText(TalentHelper.createSourceSpannable(talent.getSource()));
    }
}
