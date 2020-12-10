
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This class has Design of CommsUnit Monitors.
 *
 * @author (KaranKumar Patel)
 * @version (06-15-2020)
 */
public class CommsUnit extends JFrame implements Observer
{
    private final int width = 500;
    private final int height = 300; 
    
    private String Title;
    private JTextArea displayArea  = new JTextArea(10,80);
    private String Message;

    /**
     * Constructor
     */
    public CommsUnit( int channel_Id, String Title )
    {
        add(createPanel());
        setTitle(Title);
        setSize(width,height);
    }

    /**
     * This is a method to create apanel
     * @param This method  has no parameter to take in.
     * @return this method return a Jpanel.
     */
    public JPanel createPanel()
    {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayArea,BorderLayout.CENTER);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        displayArea.setEditable(false);
        return displayPanel;
    }

    /**
     * This is a method to the Display area of Commsunit object
     * @param This method  has int channelid and String message as a parameter
     * @return this method does not return anything.
     */
    public void update (int channel_Id,String Message) 
    {
        this.Message = Message;
        //checking channel_id to display proper Message format
        if(channel_Id == 4)
        {
            displayArea.append(" "+ Message.toUpperCase());
        }
        else if(channel_Id == 0)
        {
            displayArea.append(" "+ "***"+Message+"***");
        }
        else
        {
            displayArea.append(" "+ Message);
        }
    }
}
