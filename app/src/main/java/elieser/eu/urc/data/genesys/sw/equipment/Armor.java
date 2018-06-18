package elieser.eu.urc.data.genesys.sw.equipment;

/**
 * Created by bjorn on 08/04/16.
 */
public class Armor extends Gear
{
    private Integer defense;
    private Integer soak;
    private Integer hardPoints;

    public Armor()
    {

    }

    public Integer getDefense()
    {
        return defense;
    }

    public void setDefense(Integer defense)
    {
        this.defense = defense;
    }

    public Integer getSoak()
    {
        return soak;
    }

    public void setSoak(Integer soak)
    {
        this.soak = soak;
    }

    public Integer getHardPoints()
    {
        return hardPoints;
    }

    public void setHardPoints(Integer hardPoints)
    {
        this.hardPoints = hardPoints;
    }
}
