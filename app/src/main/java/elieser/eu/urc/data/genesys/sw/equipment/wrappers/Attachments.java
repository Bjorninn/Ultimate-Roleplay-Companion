package elieser.eu.urc.data.genesys.sw.equipment.wrappers;

import java.util.List;

import elieser.eu.urc.data.genesys.sw.equipment.Attachment;

/**
 * Created by bjorn on 08/04/16.
 */
public class Attachments
{
    List<Attachment> attachments;

    public Attachments(List<Attachment> attachments)
    {
        this.attachments = attachments;
    }

    public List<Attachment> getAttachments()
    {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments)
    {
        this.attachments = attachments;
    }
}
