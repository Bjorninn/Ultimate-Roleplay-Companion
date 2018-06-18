package elieser.eu.urc.data.genesys.sw.equipment.wrappers;


import java.util.List;

import elieser.eu.urc.data.genesys.sw.equipment.Armor;

/**
 * Created by bjorn on 08/04/16.
 */
public class Armors
{
    private List<Armor> armors;

    public Armors(List<Armor> armors)
    {
        this.armors = armors;
    }

    public List<Armor> getArmors()
    {
        return armors;
    }

    public void setArmors(List<Armor> armors)
    {
        this.armors = armors;
    }
}
