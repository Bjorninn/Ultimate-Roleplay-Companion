package elieser.eu.urc.scenes.adnd;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import elieser.eu.urc.R;
import elieser.eu.urc.data.adnd.Spell;
import elieser.eu.urc.widgets.UrcToolbar;


public class PriestSpellScene extends Fragment
{
    private static final String ARG_SPELL = "spell";

    private Spell spell;
    private String[] levelNames = new String[]{"1st-Level Spell",
            "2nd-Level Spell",
            "3rd-Level Spell",
            "4th-Level Spell",
            "5th-Level Spell",
            "6th-Level Spell",
            "7th-Level Spell",
            "8th-Level Spell",
            "9th-Level Spell"};

    public PriestSpellScene()
    {
        // Required empty public constructor
    }

    public static PriestSpellScene newInstance(Spell spell)
    {
        PriestSpellScene fragment = new PriestSpellScene();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SPELL, spell);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            spell = (Spell) getArguments().getSerializable(ARG_SPELL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.scene_adnd_priest_spell, container, false);
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

        TextView level = view.findViewById(R.id.level);
        TextView name = view.findViewById(R.id.name);
        TextView school = view.findViewById(R.id.school);
        TextView sphere = view.findViewById(R.id.sphere);
        TextView range = view.findViewById(R.id.range);
        TextView areaOfEffect = view.findViewById(R.id.area_of_effect);
        TextView duration = view.findViewById(R.id.duration);
        TextView components = view.findViewById(R.id.components);
        TextView castingTime = view.findViewById(R.id.casting_time);
        TextView savingThrow = view.findViewById(R.id.saving_throw);
        TextView reversible = view.findViewById(R.id.reversible);
        TextView text = view.findViewById(R.id.text_body);

        String levelName = levelNames[spell.getLevel() - 1];

        level.setText(levelName);
        name.setText(spell.getName());
        school.setText(String.format("(%s)", spell.getSchool()));
        sphere.setText(spell.getSphere());
        range.setText(spell.getRange());
        areaOfEffect.setText(spell.getAoe());
        duration.setText(spell.getDuration());
        castingTime.setText(spell.getCastingTime());
        sphere.setText(spell.getSphere());
        savingThrow.setText(spell.getSave());

        String comp = StringUtils.join(spell.getComponents(), ", ");
        components.setText(comp);

        if (spell.getReversible())
        {
            reversible.setVisibility(View.VISIBLE);
        }
        else
        {
            reversible.setVisibility(View.GONE);
        }

        text.setText(spell.getDescription());
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
