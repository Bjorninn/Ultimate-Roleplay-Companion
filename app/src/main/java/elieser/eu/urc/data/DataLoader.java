package elieser.eu.urc.data;

import android.content.Context;

import org.apache.commons.text.WordUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import elieser.eu.urc.data.adnd.Spell;

public class DataLoader
{

    public static List<Spell> getAdndPriestSpells(Context context)
    {
        List<Spell> spells = JsonLoader.priestSpellsFromJson(context).getSpells();

        for (Spell spell : spells)
        {
            spell.setName(WordUtils.capitalize(spell.getName()));
        }

        Collections.sort(spells, new Comparator<Spell>()
        {
            @Override
            public int compare(Spell spellA, Spell spellB)
            {
                if (spellA.getLevel() > spellB.getLevel())
                {
                    return 1;
                }
                else if (spellA.getLevel() < spellB.getLevel())
                {
                    return -1;
                }
                else
                {
                    return spellA.getName().compareTo(spellB.getName());
                }

            }
        });

        return spells;
    }

}
