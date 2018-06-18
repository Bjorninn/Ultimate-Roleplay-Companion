package elieser.eu.urc.data.genesys.sw.vehicles;


import elieser.eu.urc.data.genesys.sw.DataTools;

/**
 * Created by bjorn on 16/04/16.
 */
public class VehicleDefense
{
    private int fore;
    private int port;
    private int starboard;
    private int aft;

    public VehicleDefense(String defenses)
    {
        String[] split = defenses.split("/");
        int[] values  = new int[4];

        for (int i = 0; i < split.length; i++)
        {
            values[i] = DataTools.dashableNumberToInt(split[i]);
        }

        fore = values[0];
        port = values[1];
        starboard = values[2];
        aft = values[3];
    }

    public int getFore()
    {
        return fore;
    }

    public void setFore(int fore)
    {
        this.fore = fore;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public int getStarboard()
    {
        return starboard;
    }

    public void setStarboard(int starboard)
    {
        this.starboard = starboard;
    }

    public int getAft()
    {
        return aft;
    }

    public void setAft(int aft)
    {
        this.aft = aft;
    }
}
