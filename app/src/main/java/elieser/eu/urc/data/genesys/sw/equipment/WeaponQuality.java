package elieser.eu.urc.data.genesys.sw.equipment;


import elieser.eu.urc.data.genesys.sw.Item;

/**
 * Created by bjorn on 08/04/16.
 */
public class WeaponQuality extends Item
{
    private Boolean isPassive;
    private Boolean isRanked;
    private String effect;

    public void setIsRanked(String isRanked)
    {
        this.isRanked = isRanked.toLowerCase().equals("yes");
    }

    public void setIsPassive(String activity)
    {
        isPassive = activity.toLowerCase().equals("passive");
    }

    public void setEffect(String effect)
    {
        this.effect = effect;
    }

    public Boolean getPassive()
    {
        return isPassive;
    }

    public Boolean isRanked()
    {
        return isRanked;
    }

    public String getEffect()
    {
        return effect;
    }
}
