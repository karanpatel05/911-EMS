import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * This is a class design to encapsulate message data that come from primary console.
 *
 * @author (karanKumar patel)
 * @version (06-15-2020)
 */
public class MessageData 
{
    private String Message ;
    private int channel_Id;
    
    /**
     * Constructor
     */
    public MessageData(int channel_Id ,String Message)
    {
        this.channel_Id = channel_Id;
        this.Message = Message;
    }

    /**
     * This is a method to get a message
     * @param This method  has no parameters
     * @return this method return String message.
     */
    public  String getMessage()
    {
        return Message;
    }

     /**
     * This is a method to get a  channel_Id
     * @param This method  has no parameters
     * @return this method return int Channel_Id
     */
    public int getChannel_Id()
    {
        return channel_Id;
    }
}
