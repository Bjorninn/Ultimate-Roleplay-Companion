package elieser.eu.urc.data.genesys.sw.adversaries.wrappers;


import java.util.List;

import elieser.eu.urc.data.genesys.sw.adversaries.Adversary;

/**
 * Created by bjorn on 08/04/16.
 */
public class Adversaries
{
    List<Adversary> adversaries;

    public Adversaries(List<Adversary> adversaries)
    {
        this.adversaries = adversaries;
    }

    public List<Adversary> getAdversaries()
    {

        return adversaries;
    }

    public void setAdversaries(List<Adversary> adversaries)
    {
        this.adversaries = adversaries;
    }
}
