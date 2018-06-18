package elieser.eu.urc.data.genesys.sw;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

import elieser.eu.urc.data.genesys.sw.adversaries.Skill;

/**
 * Created by bjorn on 08/04/16.
 */
public final class DataTools
{

    public static void addStringListToList(List<String> strings, String source)
    {
        String[] split = source.split(",");

        for (String value :
                split)
        {
            value = value.trim();
            if (!value.isEmpty())
            {
                strings.add(value);
            }
        }
    }

    public static Integer processPrice(String price)
    {
        price = price.replace(".", "").replace(",", "").replace("(R)", "").trim();
        return Integer.valueOf(price);
    }

    public static void processSkills(List<Skill> skills, String skillString)
    {
        if (!skillString.trim().toLowerCase().equals("none"))
        {
            String[] split = skillString.split(",");

            for (String entry :
                    split)
            {
                entry = entry.trim();

                if (entry.isEmpty())
                {
                    continue;
                }

                Skill skill = new Skill();

                String s = String.valueOf(entry.charAt(entry.length() - 1));

                if (NumberUtils.isNumber(s))
                {
                    entry = StringUtils.chop(entry).trim();
                    skill.setLevel(Integer.valueOf(s));
                }

                skill.setName(entry);

                skills.add(skill);
            }
        }
    }

    public static void processList(List<String> list, String listString)
    {
        if (!listString.trim().toLowerCase().equals("none"))
        {
            String[] split = listString.split(",");

            for (String entry :
                    split)
            {
                entry = entry.trim();

                if (entry.isEmpty())
                {
                    continue;
                }

                list.add(entry);
            }
        }
    }

    public static int dashableNumberToInt(String dashable)
    {
        int strain = 0;

        if (NumberUtils.isNumber(dashable))
        {
            strain = Integer.valueOf(dashable);
        }

        return strain;
    }

    public static Boolean isRestrictedItem(String price)
    {
        return price.toLowerCase().contains("r");
    }
}
