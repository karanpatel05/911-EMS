import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class MessagePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MessagePanel
{
    private MessageData Msg;
    private ArrayList<CommsUnit> Monitors = PrimaryConsole.getMonitors();

    /**
     * Constructor
     */
    public MessagePanel(MessageData Msg)
    {
        this.Msg = Msg;
    }

    /**
     * This is a method to set message to monitors with refernce of channelId
     * @param This method  has no parameter to take in.
     * @return this method does not return anything
     */
    public void setMessage()
    {
        //checking channel id for displaying a message on monitor
        if(Msg.getChannel_Id() == 0)
        {
            for(int i = 0;i<9;i++)
            {
                updateMonitor(i);
                playTone("alert.au");
            }
        }
        else if(Msg.getChannel_Id() == 1)
        {
            updateMonitor(0);
            playTone("attention.au");
            updateMonitor(1);
            playTone("attention.au");
        }
        else if(Msg.getChannel_Id() == 2)
        { 
            updateMonitor(2);
            playTone("attention.au");
            updateMonitor(3);
            playTone("attention.au");
            updateMonitor(4);
            playTone("attention.au");
        }
        else if(Msg.getChannel_Id() == 3)
        { 
            updateMonitor(5);
            playTone("attention.au");
        }
        else if(Msg.getChannel_Id() == 4)
        { 
            updateMonitor(6);
            playTone("attention.au");
            updateMonitor(7);
            playTone("attention.au");
            updateMonitor(8);
            playTone("attention.au");
        }
        else if(Msg.getChannel_Id() == 5)
        { 
            updateMonitor(6);
            playTone("attention.au");
            updateMonitor(7);
            playTone("attention.au");
            updateMonitor(8);
            playTone("attention.au");
        }
    }

    /**
     * This is a method to update a monitor 
     * @param This method  takes int i has a parameter.
     * @return this method does not return anything.
     */
    public void updateMonitor(int i)
    {
        //upadting commsUNIT JTEXTFIELD AREA
        Monitors.get(i).update(Msg.getChannel_Id(),Msg.getMessage()); 
    }

    /**
     * This is a method to play a tone .
     * @param This method has parameter String filename
     * @return this method does not return anything.
     */
    public void playTone(String FileName)
    {
        try
        {
            javax.swing.JApplet.newAudioClip(new java.net.URL ("file",
                    "localhost", FileName)).play();
            Thread.sleep(150);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
