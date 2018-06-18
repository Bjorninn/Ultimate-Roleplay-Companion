package elieser.eu.urc.data.genesys.sw.vehicles;

/**
 * Created by bjorn on 08/04/16.
 */
public class Starship extends Vehicle
{
    private String hdNc; //Hyperdrive / Navcomputer

    public String getHdNc()
    {
        return hdNc;
    }

    public void setHdNc(String hdNc)
    {
        this.hdNc = hdNc;
    }

    @Override
    public Boolean isPlanetary()
    {
        return false;
    }

    @Override
    public String toString()
    {
        return "Starship{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", encumbrance=" + encumbrance +
                ", rarity=" + rarity +
                ", isRestricted=" + isRestricted +
                ", silhouette=" + silhouette +
                ", speed=" + speed +
                ", handling=" + handling +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", hdNc='" + hdNc + '\'' +
                ", crew=" + crew +
                ", passengers=" + passengers +
                ", hardPoints=" + hardPoints +
                ", weapons=" + weapons +
                ", isPlanetary=" + isPlanetary() +
                ", sources=" + sources +
                '}';
    }
}
