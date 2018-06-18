package elieser.eu.urc.data.genesys.sw.adversaries;


import java.util.ArrayList;
import java.util.List;

import elieser.eu.urc.data.genesys.sw.DataTools;
import elieser.eu.urc.data.genesys.sw.Item;

/**
 * Created by bjorn on 08/04/16.
 */
public class Adversary extends Item
{
    protected String type;
    protected String level;
    protected Abilities abilities;
    protected int soak;
    protected int wounds;
    protected int strain;
    protected int meleeDefence;
    protected int rangedDefence;
    protected List<Skill> skills;
    protected List<Skill> talents;
    protected List<String> specialAbilities;
    protected List<String> equipment;

    public Abilities getAbilities()
    {
        return abilities;
    }

    public void setAbilities(Abilities abilities)
    {
        this.abilities = abilities;
    }

    public int getSoak()
    {
        return soak;
    }

    public void setSoak(int soak)
    {
        this.soak = soak;
    }

    public int getWounds()
    {
        return wounds;
    }

    public void setWounds(int wounds)
    {
        this.wounds = wounds;
    }

    public int getStrain()
    {
        return strain;
    }

    public void setStrain(int strain)
    {
        this.strain = strain;
    }

    public int getMeleeDefence()
    {
        return meleeDefence;
    }

    public void setMeleeDefence(int meleeDefence)
    {
        this.meleeDefence = meleeDefence;
    }

    public int getRangedDefence()
    {
        return rangedDefence;
    }

    public void setRangedDefence(int rangedDefence)
    {
        this.rangedDefence = rangedDefence;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public List<Skill> getTalents()
    {
        return talents;
    }

    public void setTalents(String talentString)
    {
        talents = new ArrayList<>();

        DataTools.processSkills(talents, talentString);
    }

    public List<Skill> getSkills()
    {
        return skills;
    }

    public void setSkills(String skillString)
    {
        skills = new ArrayList<>();

        DataTools.processSkills(skills, skillString);
    }

    public List<String> getSpecialAbilities()
    {
        return specialAbilities;
    }

    public void setSpecialAbilities(String abilityString)
    {
        specialAbilities = new ArrayList<>();

        DataTools.processList(specialAbilities, abilityString);
    }

    public List<String> getEquipment()
    {
        return equipment;
    }

    public void setEquipment(String equipmentString)
    {
        equipment = new ArrayList<>();

        equipmentString = equipmentString.replace(", and ", ", ");

        DataTools.processList(equipment, equipmentString);
    }

    @Override
    public String toString()
    {
        return "Adversary{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", skills=" + skills +
                ", talents=" + talents +
                ", specialAbilities=" + specialAbilities +
                ", equipment=" + equipment +
                ", sources=" + sources +
                '}';
    }
}
