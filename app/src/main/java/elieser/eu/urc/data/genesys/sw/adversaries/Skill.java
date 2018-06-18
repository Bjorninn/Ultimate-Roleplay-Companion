package elieser.eu.urc.data.genesys.sw.adversaries;

/**
 * Created by bjorn on 08/04/16.
 */
public class Skill
{
    private String name;
    private Integer level = null;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getLevel()
    {
        return level;
    }

    public void setLevel(Integer level)
    {
        this.level = level;
    }

    @Override
    public String toString()
    {
        if (level == null)
        {
            return name;
        }

        return name + " " + level;
    }
}
