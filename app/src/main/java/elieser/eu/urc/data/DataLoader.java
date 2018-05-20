package elieser.eu.urc.data;

import android.content.Context;

import org.apache.commons.text.WordUtils;

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

        return spells;
    }

}
