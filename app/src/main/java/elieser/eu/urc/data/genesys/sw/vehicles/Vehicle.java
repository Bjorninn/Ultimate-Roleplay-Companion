package elieser.eu.urc.data.genesys.sw.vehicles;


import elieser.eu.urc.data.genesys.sw.equipment.Gear;

/**
 * Created by bjorn on 08/04/16.
 */
public class Vehicle extends Gear
{
    protected Integer silhouette;
    protected Integer speed;
    protected Integer handling;
    protected String model;
    protected String manufacturer;
    protected Integer crew;
    protected Integer passengers;
    protected Integer hardPoints;
    protected Integer weapons;
    protected VehicleDefense defense;
    protected int armor;
    protected int hullTrauma;
    protected int systemTrain;
    protected String maxAltitude;
    protected String sensorRange;

    public int getArmor()
    {
        return armor;
    }

    public void setArmor(int armor)
    {
        this.armor = armor;
    }

    public int getHullTrauma()
    {
        return hullTrauma;
    }

    public void setHullTrauma(int hullTrauma)
    {
        this.hullTrauma = hullTrauma;
    }

    public int getSystemTrain()
    {
        return systemTrain;
    }

    public void setSystemTrain(int systemTrain)
    {
        this.systemTrain = systemTrain;
    }

    public String getMaxAltitude()
    {
        return maxAltitude;
    }

    public void setMaxAltitude(String maxAltitude)
    {
        this.maxAltitude = maxAltitude;
    }

    public String getSensorRange()
    {
        return sensorRange;
    }

    public void setSensorRange(String sensorRange)
    {
        this.sensorRange = sensorRange;
    }

    public VehicleDefense getDefense()
    {
        return defense;
    }

    public void setDefense(VehicleDefense defense)
    {
        this.defense = defense;
    }

    public Integer getHardPoints()
    {
        return hardPoints;
    }

    public void setHardPoints(Integer hardPoints)
    {
        this.hardPoints = hardPoints;
    }

    public Boolean isPlanetary()
    {
        return true;
    }

    public Integer getSilhouette()
    {
        return silhouette;
    }

    public void setSilhouette(Integer silhouette)
    {
        this.silhouette = silhouette;
    }

    public Integer getSpeed()
    {
        return speed;
    }

    public void setSpeed(Integer speed)
    {
        this.speed = speed;
    }

    public Integer getHandling()
    {
        return handling;
    }

    public void setHandling(Integer handling)
    {
        this.handling = handling;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    public Integer getCrew()
    {
        return crew;
    }

    public void setCrew(Integer crew)
    {
        this.crew = crew;
    }

    public Integer getPassengers()
    {
        return passengers;
    }

    public void setPassengers(Integer passengers)
    {
        this.passengers = passengers;
    }

    public Integer getWeapons()
    {
        return weapons;
    }

    public void setWeapons(Integer weapons)
    {
        this.weapons = weapons;
    }

    @Override
    public String toString()
    {
        return "Vehicle{" +
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
                ", crew=" + crew +
                ", passengers=" + passengers +
                ", hardPoints=" + hardPoints +
                ", weapons=" + weapons +
                ", isPlanetary=" + isPlanetary() +
                ", sources=" + sources +
                '}';
    }
}
