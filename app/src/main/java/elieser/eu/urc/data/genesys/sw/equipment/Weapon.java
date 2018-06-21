package elieser.eu.urc.data.genesys.sw.equipment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjorn on 08/04/16.
 */
public class Weapon extends Gear
{
    private String weaponSkill;
    private Integer damage;
    private Integer critical;
    private String range;
    private Integer hardPoints;
    private List<String> special;

    private Boolean addsToBrawn;

    public Weapon()
    {
        special = new ArrayList<>();
    }

    public boolean brawnIsAdded()
    {
        return addsToBrawn;
    }

    public String getWeaponSkill()
    {
        return weaponSkill;
    }

    public void setWeaponSkill(String weaponSkill)
    {
        this.weaponSkill = weaponSkill;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Integer getDamage()
    {
        return damage;
    }

    public void setDamage(String damage)
    {
        addsToBrawn = damage.contains("+");

        this.damage = Integer.valueOf(damage.replace("+", ""));
    }

    public Integer getCritical()
    {
        return critical;
    }

    public void setCritical(String critical)
    {
        if (critical.contains("-"))
        {
            this.critical = 0;
        }
        else
        {
            this.critical = Integer.valueOf(critical);
        }
    }

    public String getRange()
    {
        return range;
    }

    public void setRange(String range)
    {
        this.range = range;
    }

    public Integer getEncumbrance()
    {
        return encumbrance;
    }

    public void setEncumbrance(Integer encumbrance)
    {
        this.encumbrance = encumbrance;
    }

    public Integer getHardPoints()
    {
        return hardPoints;
    }

    public void setHardPoints(Integer hardPoints)
    {
        this.hardPoints = hardPoints;
    }

    public Integer getRarity()
    {
        return rarity;
    }

    public void setRarity(Integer rarity)
    {
        this.rarity = rarity;
    }

    public List<String> getSpecial()
    {
        return special;
    }

    public void setSpecial(String special)
    {
        String[] split = special.split(",");

        for (String value :
                split)
        {
            value = value.trim();
            if (!value.isEmpty())
            {
                this.special.add(value);
            }
        }
    }

    @Override
    public String toString()
    {
        return "Weapon{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", weaponSkill='" + weaponSkill + '\'' +
                ", damage=" + damage +
                ", critical=" + critical +
                ", range='" + range + '\'' +
                ", encumbrance=" + encumbrance +
                ", hardPoints=" + hardPoints +
                ", price=" + price +
                ", rarity=" + rarity +
                ", special=" + special +
                ", source=" + sources +
                ", isRestricted=" + isRestricted +
                ", addsToBrawn=" + addsToBrawn +
                '}';
    }
}



/*

Weapon
Skill
Dam
Crit
Range
Encum
HP
Price
Rarity
Special
Index
Energy
12 Defender
Ranged [Light]	5	5	Short	1	0	25	4	Inferior, Limited Ammo 2,	FH:40

 */
