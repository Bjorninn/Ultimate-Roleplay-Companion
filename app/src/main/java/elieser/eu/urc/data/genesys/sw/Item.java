package elieser.eu.urc.data.genesys.sw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjorn on 08/04/16.
 */
public class Item
{
    protected String name;
    protected List<String> sources = new ArrayList<>();

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<String> getSources()
    {
        return sources;
    }

    public void setSources(String sources)
    {
        DataTools.addStringListToList(this.sources, sources);
    }

    @Override
    public String toString()
    {
        return "Item{" +
                "name='" + name + '\'' +
                ", sources=" + sources +
                '}';
    }
}

