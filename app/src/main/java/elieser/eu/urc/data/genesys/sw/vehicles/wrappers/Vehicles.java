package elieser.eu.urc.data.genesys.sw.vehicles.wrappers;


import java.util.List;

import elieser.eu.urc.data.genesys.sw.vehicles.Vehicle;

/**
 * Created by bjorn on 08/04/16.
 */
public class Vehicles
{
    List<Vehicle> vehicles;

    public Vehicles(List<Vehicle> vehicles)
    {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles()
    {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles)
    {
        this.vehicles = vehicles;
    }
}
