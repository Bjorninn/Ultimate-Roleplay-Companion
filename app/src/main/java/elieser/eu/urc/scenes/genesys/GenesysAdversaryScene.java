package elieser.eu.urc.scenes.genesys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import elieser.eu.urc.R;
import elieser.eu.urc.data.BundleKeys;
import elieser.eu.urc.data.genesys.GenesysDataStore;
import elieser.eu.urc.data.genesys.Talent;
import elieser.eu.urc.data.genesys.sw.adversaries.Adversary;
import elieser.eu.urc.data.genesys.sw.adversaries.Skill;
import elieser.eu.urc.data.genesys.sw.adversaries.wrappers.Adversaries;
import elieser.eu.urc.data.genesys.sw.equipment.Weapon;
import elieser.eu.urc.navigation.Navigator;
import elieser.eu.urc.widgets.UrcToolbar;

/**
 * Created by bjornjonsson on 10/03/2018.
 */

public class GenesysAdversaryScene extends Fragment
{
    private TextView name;

    private TextView brawn;
    private TextView agility;
    private TextView intellect;
    private TextView cunning;
    private TextView willpower;
    private TextView presence;

    private TextView soak;
    private TextView wounds;
    private TextView strain;
    private TextView meleeDefense;
    private TextView rangedDefense;

    private LinearLayout skillsContainer;
    private LinearLayout weaponsContainer;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.scene_genesys_adversary, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.header);

        brawn = view.findViewById(R.id.brawn);
        agility = view.findViewById(R.id.agility);
        intellect = view.findViewById(R.id.intellect);
        cunning = view.findViewById(R.id.cunning);
        willpower = view.findViewById(R.id.willpower);
        presence = view.findViewById(R.id.presence);

        soak = view.findViewById(R.id.soak);
        wounds = view.findViewById(R.id.wounds);
        strain = view.findViewById(R.id.strain);
        meleeDefense = view.findViewById(R.id.melee_defense);
        rangedDefense = view.findViewById(R.id.ranged_defense);

        skillsContainer = view.findViewById(R.id.skills);
        weaponsContainer = view.findViewById(R.id.weapons);

        String name = getArguments().getString(BundleKeys.NAME);
        Adversary adversary = GenesysDataStore.getInstance().getAdversary(name);

        LoadAdversary(adversary);

        UrcToolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Navigator.popFragmentBackStack((AppCompatActivity) getActivity());
            }
        });
    }

    private void CreateSkills(Skill skill)
    {

    }

    private void LoadAdversary(Adversary adversary)
    {
        name.setText(adversary.getName() + "[" + adversary.getType() + "]");

        brawn.setText(String.valueOf(adversary.getAbilities().getBrawn()));
        agility.setText(String.valueOf(adversary.getAbilities().getAgility()));
        intellect.setText(String.valueOf(adversary.getAbilities().getIntellect()));
        cunning.setText(String.valueOf(adversary.getAbilities().getCunning()));
        willpower.setText(String.valueOf(adversary.getAbilities().getWillpower()));
        presence.setText(String.valueOf(adversary.getAbilities().getPresence()));

        soak.setText(String.valueOf(adversary.getSoak()));
        wounds.setText(String.valueOf(adversary.getWounds()));
        strain.setText(String.valueOf(adversary.getStrain()));

        meleeDefense.setText(String.valueOf(adversary.getMeleeDefence()));
        rangedDefense.setText(String.valueOf(adversary.getRangedDefence()));

        List<Skill> skillList = adversary.getSkills();

        if (skillList != null && !skillList.isEmpty())
        {
            for (Skill skill : skillList)
            {
                View skillView = getLayoutInflater().inflate(R.layout.widget_skill_entry, null);
                skillsContainer.addView(skillView);
                TextView name = skillView.findViewById(R.id.name);
                name.setText(skill.getName());

                int ability = GenesysHelper.instance.getCharacteristicForSkill(adversary.getAbilities(), skill.getName());
                int level = skill.getLevel() == null ? 0 : skill.getLevel();

                Spannable spannable = GenesysHelper.instance.createDicePool(getContext(), ability, level);

                TextView value = skillView.findViewById(R.id.value);
                value.setText(spannable);
            }
        }

        List<Weapon> weapons = new ArrayList<>();
        List<String> equipment = adversary.getEquipment();
        int n = 0;

        for (String s : equipment)
        {
            if (GenesysDataStore.getInstance().hasWeapon(s))
            {
                Weapon weapon = GenesysDataStore.getInstance().getWeapon(s);
                weapons.add(weapon);

                View weaponView = getLayoutInflater().inflate(R.layout.widget_weapon_entry, null);
                weaponsContainer.addView(weaponView);

                TextView name = weaponView.findViewById(R.id.name);
                name.setText(weapon.getName());

                if (weapon.brawnIsAdded())
                {

                }

                TextView damage = weaponView.findViewById(R.id.damage);
                damage.setText(String.valueOf(weapon.getDamage()));

                TextView crit = weaponView.findViewById(R.id.crit);
                crit.setText(String.valueOf(weapon.getCritical()));

                String weaponRange = weapon.getRange();
                if (weaponRange != null)
                {
                    weaponRange = weaponRange.substring(0, 1);
                    TextView range = weaponView.findViewById(R.id.range);
                    range.setText(weaponRange);
                }

                int color;

                if (n%2 == 0)
                {
                    color = ContextCompat.getColor(getContext(), R.color.cream);
                }
                else
                {
                    color = ContextCompat.getColor(getContext(), R.color.light_cream);
                }

                LinearLayout root = weaponView.findViewById(R.id.root);
                root.setBackgroundColor(color);


                n++;
            }
        }

        Log.d("BEJ", "WEApppppp");

        for (Weapon w : weapons)
        {
            Log.d("BEJ", w.getName());
        }


//        name.setText(TalentHelper.createNameSpannable(talent.getName()));


//        tier.setText(TalentHelper.createTierSpannable(talent.getTier().toString()));
//        activation.setText(TalentHelper.createActivationSpannable(talent.getActivation()));
//
//        if (talent.getRanked())
//        {
//            ranked.setText(TalentHelper.createRankedSpannable("Yes"));
//        }
//        else
//        {
//            ranked.setText(TalentHelper.createRankedSpannable("No"));
//
//        }
//
//        if (talent.getRequirement() != 0)
//        {
//            Talent prereqTalent = GenesysDataStore.getInstance().getTalent(talent.getRequirement());
//            prerequisite.setVisibility(View.VISIBLE);
//            prerequisite.setText(TalentHelper.createPrerequisiteSpannable(prereqTalent.getName()));
//        }
//        else
//        {
//            prerequisite.setVisibility(View.GONE);
//        }
//
//        description.setText(talent.getDescription());
//
//        if (talent.hasKeywords())
//        {
//            keywords.setVisibility(View.VISIBLE);
//            keywords.setText(TalentHelper.createKeywordsSpannable(talent.getKeywords()));
//        }
//        else
//        {
//            keywords.setVisibility(View.GONE);
//        }
//
//        description.setText(TalentHelper.createDescriptionSpannable(talent.getDescription()));
//        //description.setText(TalentHelper.testFont(getActivity().getAssets(), talent.getDescription()));
//        //description.setText(talent.getDescription());
//        source.setText(TalentHelper.createSourceSpannable(talent.getSource()));
    }
}
