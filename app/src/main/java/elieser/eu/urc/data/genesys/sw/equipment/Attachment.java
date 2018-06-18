package elieser.eu.urc.data.genesys.sw.equipment;

/**
 * Created by bjorn on 08/04/16.
 */
public class Attachment extends Gear
{
    private Integer hardPoints;

    public Integer getHardPoints()
    {
        return hardPoints;
    }

    public void setHardPoints(Integer hardPoints)
    {
        this.hardPoints = hardPoints;
    }

    @Override
    public String toString()
    {
        return "Attachment{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", encumbrance=" + encumbrance +
                ", hardPoints=" + hardPoints +
                ", rarity=" + rarity +
                ", isRestricted=" + isRestricted +
                ", sources=" + sources +
                '}';
    }
}
