package elieser.eu.urc.data.genesys;

import android.content.Context;
import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

import elieser.eu.urc.data.JsonLoader;
import elieser.eu.urc.data.genesys.sw.adversaries.wrappers.Adversaries;

/**
 * Created by bjornjonsson on 11/03/2018.
 */

public class GenesysDataStore
{
    private static GenesysDataStore instance;

    private Adversaries adversaries;
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

        for (Talent talent :
                talents.getTalents())
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

    public Adversaries getAdversaries()
    {
        return adversaries;
    }

    public void setAdversaries(Adversaries adversaries)
    {
        this.adversaries = adversaries;
    }

    public void loadAdversarieData(Context context)
    {
        Adversaries adversaries = JsonLoader.genesysAdversariesFromJson(context);
        setAdversaries(adversaries);
    }
}
