package elieser.eu.urc.data.genesys;

import android.content.Context;
import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

import elieser.eu.urc.data.JsonLoader;
import elieser.eu.urc.data.genesys.sw.adversaries.Adversary;
import elieser.eu.urc.data.genesys.sw.adversaries.wrappers.Adversaries;
import elieser.eu.urc.data.genesys.sw.equipment.Weapon;
import elieser.eu.urc.data.genesys.sw.equipment.wrappers.Weapons;

/**
 * Created by bjornjonsson on 11/03/2018.
 */

public class GenesysDataStore
{
    private static GenesysDataStore instance;

    private Weapons weapons;
    private Map<String, Weapon> weaponMap;

    private Adversaries adversaries;
    private Map<String, Adversary> adversaryMap;

    private Talents talents;
    private Map<String, Talent> talentMap;
    private SparseArray<Talent> talentIdMap;

    public GenesysDataStore()
    {
        instance = this;
        talentMap = new HashMap<>();
        talentIdMap = new SparseArray<>();
    }

    public static GenesysDataStore getInstance()
    {
        return instance;
    }

    public Weapon getWeapon(String name)
    {
        return weaponMap.get(name);
    }

    public boolean hasWeapon(String name)
    {
        return weaponMap.containsKey(name);
    }

    public void setWeapons(Weapons weapons)
    {
        this.weapons = weapons;
        weaponMap = new HashMap<>(weapons.getWeapons().size());

        for (Weapon weapon : weapons.getWeapons())
        {
            weaponMap.put(weapon.getName(), weapon);
        }
    }

    public Talent getTalent(String talentName)
    {
        return talentMap.get(talentName);
    }

    public Talent getTalent(int talentId)
    {
        return talentIdMap.get(talentId);
    }

    public void setTalents(Talents talents)
    {
        this.talents = talents;

        for (Talent talent : talents.getTalents())
        {
            talentMap.put(talent.getName(), talent);
            talentIdMap.put(talent.getId(), talent);
        }
    }

    public Talents getTalents()
    {
        return talents;
    }

    public void loadTalentData(Context context)
    {
        Talents talents = JsonLoader.genesysTalentsFromJson(context);
        setTalents(talents);
    }

    public Adversary getAdversary(String name)
    {
        return adversaryMap.get(name);
    }

    public Adversaries getAdversaries()
    {
        return adversaries;
    }

    public void setAdversaries(Adversaries adversaries)
    {
        this.adversaries = adversaries;
        adversaryMap = new HashMap<>(adversaries.getAdversaries().size());

        for (Adversary adversary : adversaries.getAdversaries())
        {
            adversaryMap.put(adversary.getName(), adversary);
        }
    }

    public void loadAdversariesData(Context context)
    {
        Adversaries adversaries = JsonLoader.genesysAdversariesFromJson(context);
        setAdversaries(adversaries);
    }

    public void loadWeaponData(Context context)
    {
        Weapons weapons = JsonLoader.genesysWeaponsFromJson(context);
        setWeapons(weapons);
    }
}
