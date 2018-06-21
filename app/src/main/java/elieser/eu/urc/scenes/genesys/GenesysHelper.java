package elieser.eu.urc.scenes.genesys;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import elieser.eu.urc.AbilityType;
import elieser.eu.urc.R;
import elieser.eu.urc.data.genesys.sw.adversaries.Abilities;

public class GenesysHelper
{
    public static GenesysHelper instance;

    private Typeface eoteTypeface;
    private Map<String, AbilityType> skillAbilities;


    public GenesysHelper(AssetManager assetManager)
    {
        super();

        instance = this;

        eoteTypeface = Typeface.createFromAsset(assetManager, "EotE_Symbol-Regular_v1.otf");
//        eoteTypeface = Typeface.createFromAsset(assetManager, "EotESymbol-Regular-PLUS.otf");
        skillAbilities = new HashMap<>(35);
        skillAbilities.put("Astrogation", AbilityType.INTELLECT);
        skillAbilities.put("Athletics", AbilityType.BRAWN);
        skillAbilities.put("Brawl", AbilityType.BRAWN);
        skillAbilities.put("Charm", AbilityType.PRESENCE);
        skillAbilities.put("Coercion", AbilityType.WILLPOWER);
        skillAbilities.put("Computers", AbilityType.INTELLECT);
        skillAbilities.put("Cool", AbilityType.PRESENCE);
        skillAbilities.put("Coordination", AbilityType.AGILITY);
        skillAbilities.put("Core Worlds", AbilityType.INTELLECT);
        skillAbilities.put("Deception", AbilityType.CUNNING);
        skillAbilities.put("Discipline", AbilityType.WILLPOWER);
        skillAbilities.put("Education", AbilityType.INTELLECT);
        skillAbilities.put("Gunnery", AbilityType.AGILITY);
        skillAbilities.put("Knowledge", AbilityType.INTELLECT);
        skillAbilities.put("Leadership", AbilityType.PRESENCE);
        skillAbilities.put("Lightsaber", AbilityType.BRAWN);
        skillAbilities.put("Lore", AbilityType.INTELLECT);
        skillAbilities.put("Mechanics", AbilityType.INTELLECT);
        skillAbilities.put("Medicine", AbilityType.INTELLECT);
        skillAbilities.put("Melee", AbilityType.BRAWN);
        skillAbilities.put("Negotiation", AbilityType.PRESENCE);
        skillAbilities.put("Outer Rim", AbilityType.INTELLECT);
        skillAbilities.put("Perception", AbilityType.CUNNING);
        skillAbilities.put("Piloting", AbilityType.AGILITY);
        skillAbilities.put("Piloting [Planetary]", AbilityType.AGILITY);
        skillAbilities.put("Piloting [Space]", AbilityType.AGILITY);
        skillAbilities.put("Ranged [Heavy]", AbilityType.AGILITY);
        skillAbilities.put("Ranged [Light]", AbilityType.AGILITY);
        skillAbilities.put("Resilience", AbilityType.BRAWN);
        skillAbilities.put("Skullduggery", AbilityType.CUNNING);
        skillAbilities.put("Streetwise", AbilityType.CUNNING);
        skillAbilities.put("Survival", AbilityType.CUNNING);
        skillAbilities.put("Underworld", AbilityType.INTELLECT);
        skillAbilities.put("Vigilance", AbilityType.WILLPOWER);
        skillAbilities.put("Warfare", AbilityType.INTELLECT);
        skillAbilities.put("Xenology", AbilityType.INTELLECT);
    }

    public int getCharacteristicForSkill(Abilities abilities, String skill)
    {
        Log.d("BEJ", skill);

        AbilityType type = skillAbilities.get(skill);

        switch (type)
        {
            case BRAWN:
                return abilities.getBrawn();
            case AGILITY:
                return abilities.getAgility();
            case INTELLECT:
                return abilities.getIntellect();
            case CUNNING:
                return abilities.getCunning();
            case WILLPOWER:
                return abilities.getWillpower();
            case PRESENCE:
                return abilities.getPresence();
        }

        return -1;
    }

    public Spannable createBoostOrSetbackDicePool(Context context, int count, boolean isBoost)
    {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < count; i++)
        {
            builder.append("b");
        }

        Spannable spannable = new SpannableString(builder.toString());

        CustomTypefaceSpan span = new CustomTypefaceSpan(eoteTypeface);
        spannable.setSpan(span, 0, spannable.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan colorSpan;

        if (isBoost)
        {
            colorSpan = new ForegroundColorSpan(ContextCompat.getColor(context, R.color.boost_blue));
        }
        else
        {
            colorSpan = new ForegroundColorSpan(ContextCompat.getColor(context, R.color.black));
        }

        spannable.setSpan(colorSpan, 0, spannable.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        return spannable;
    }

    public Spannable createDicePool(Context context, int characteristic, int skill)
    {
        int larger = Math.max(characteristic, skill);
        int smaller = Math.min(characteristic, skill);
        int leftovers = larger - smaller;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < smaller; i++)
        {
            builder.append("c");
        }

        for (int i = 0; i < leftovers; i++)
        {
            builder.append("d");
        }

        Spannable spannable = new SpannableString(builder.toString());

        CustomTypefaceSpan span = new CustomTypefaceSpan(eoteTypeface);
        spannable.setSpan(span, 0, spannable.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        ForegroundColorSpan green = new ForegroundColorSpan(ContextCompat.getColor(context, R.color.ability_green));

        if (smaller > 0)
        {
            ForegroundColorSpan yellow = new ForegroundColorSpan(ContextCompat.getColor(context, R.color.proficiency_yellow));
            spannable.setSpan(yellow, 0, smaller, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            spannable.setSpan(green, smaller, spannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        else
        {
            spannable.setSpan(green, 0, spannable.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }

        return spannable;
    }
}
