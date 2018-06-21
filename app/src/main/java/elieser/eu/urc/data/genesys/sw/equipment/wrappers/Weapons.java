package elieser.eu.urc.data.genesys.sw.equipment.wrappers;


import java.util.List;

import elieser.eu.urc.data.genesys.sw.equipment.Weapon;

/**
 * Created by bjorn on 08/04/16.
 */
public class Weapons
{
    private List<Weapon> weapons;

    public Weapons(List<Weapon> weapons)
    {
        this.weapons = weapons;
    }

    public List<Weapon> getWeapons()
    {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons)
    {
        this.weapons = weapons;
    }
}
