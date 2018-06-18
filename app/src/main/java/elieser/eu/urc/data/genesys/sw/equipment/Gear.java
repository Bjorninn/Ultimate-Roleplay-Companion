package elieser.eu.urc.data.genesys.sw.equipment;


import elieser.eu.urc.data.genesys.sw.DataTools;
import elieser.eu.urc.data.genesys.sw.Item;

/**
 * Created by bjorn on 08/04/16.
 */
public class Gear extends Item
{
    protected String type;
    protected Integer price;
    protected Integer encumbrance;
    protected Integer rarity;

    protected Boolean isRestricted;

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Integer getEncumbrance()
    {
        return encumbrance;
    }

    public void setEncumbrance(Integer encumbrance)
    {
        this.encumbrance = encumbrance;
    }

    public Integer getRarity()
    {
        return rarity;
    }

    public void setRarity(Integer rarity)
    {
        this.rarity = rarity;
    }

    public Boolean isRestricted()
    {
        return isRestricted;
    }

    public void setRestricted(String price)
    {
        isRestricted = price.toLowerCase().contains("r");
    }

    public void setPrice(String price)
    {
        this.price = DataTools.processPrice(price);
    }

    public Integer getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return "Gear{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", encumbrance=" + encumbrance +
                ", rarity=" + rarity +
                ", isRestricted=" + isRestricted +
                ", sources=" + sources +
                '}';
    }
}
