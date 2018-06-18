package elieser.eu.urc.data.genesys.sw.equipment.wrappers;


import java.util.List;

import elieser.eu.urc.data.genesys.sw.equipment.Gear;

/**
 * Created by bjorn on 08/04/16.
 */
public class Gears
{
    List<Gear> gears;

    public Gears(List<Gear> gears)
    {
        this.gears = gears;
    }

    public List<Gear> getGears()
    {
        return gears;
    }

    public void setGears(List<Gear> gears)
    {
        this.gears = gears;
    }
}
