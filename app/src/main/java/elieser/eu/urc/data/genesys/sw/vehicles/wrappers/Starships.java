package elieser.eu.urc.data.genesys.sw.vehicles.wrappers;


import java.util.List;

import elieser.eu.urc.data.genesys.sw.vehicles.Starship;

/**
 * Created by bjorn on 08/04/16.
 */
public class Starships
{
    List<Starship> starships;

    public Starships(List<Starship> starships)
    {
        this.starships = starships;
    }

    public List<Starship> getStarships()
    {
        return starships;
    }

    public void setStarships(List<Starship> starships)
    {
        this.starships = starships;
    }
}
