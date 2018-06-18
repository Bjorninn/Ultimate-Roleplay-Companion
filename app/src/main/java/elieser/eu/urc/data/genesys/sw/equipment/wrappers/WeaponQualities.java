package elieser.eu.urc.data.genesys.sw.equipment.wrappers;


import java.util.List;

import elieser.eu.urc.data.genesys.sw.equipment.WeaponQuality;

/**
 * Created by bjorn on 08/04/16.
 */
public class WeaponQualities
{
    List<WeaponQuality> weaponQualities;

    public WeaponQualities(List<WeaponQuality> weaponQualities)
    {
        this.weaponQualities = weaponQualities;
    }

    public List<WeaponQuality> getWeaponQualities()
    {

        return weaponQualities;
    }

    public void setWeaponQualities(List<WeaponQuality> weaponQualities)
    {
        this.weaponQualities = weaponQualities;
    }
}
