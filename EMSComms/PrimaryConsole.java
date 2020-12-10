import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Write a description of class PrimaryConsole here.
 *
 * @author (Karankumar Patel)
 * @version (06-13-2020)
 */
public class PrimaryConsole extends JFrame implements Observable
{
    private final int width = 500;
    private final int height = 300;

    private int channelNum  ;

    private JLabel currentChannel;
    private JTextArea displayArea;
    private JPanel displayPanel;
    private JButton sendButton;

    private String Message;
    private String channelName;

    private static ArrayList<CommsUnit> Monitors = new ArrayList<>();
    /**
     * Constructor
     */
    public PrimaryConsole()
    {
        setSize(width,height);
        createMenuBar();
        createPanel();
        add(displayPanel);
        registerObserver();
    }

    /**
     * This is a method to create menubar
     * @param This method  does not take in parameter
     * @return this method does not return anything.
     */
    public void createMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();     
        setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(createChannelMenu()); 
    }

    /**
     * This is a method to create filemenu and MenuItem
     * @param This method  does not take in parameter
     * @return this method return JMenu
     */
    public JMenu createFileMenu()
    {
        JMenu menu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");      
        ActionListener listener = new ExitItemListener();
        exitItem.addActionListener(listener);
        menu.add(exitItem);
        return menu;
    }

    /**
     * This is a inner Class that implements ActionListener and has a method to add
     * action on event when the Exit Item is clicked.
     */
    class ExitItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.exit(0);
        }
    } 

    /**
     * This is a method to create channel menu and MenuItem
     * @param This method  does not take in parameter
     * @return this method return JMenu
     */
    public JMenu createChannelMenu()
    {
        JMenu menu = new JMenu("SELECT CHANNEL");
        menu.add(CreateItem("ALL CALL",0));
        menu.add(CreateItem("EMS",1));
        menu.add(CreateItem("Fire",2));
        menu.add(CreateItem("Aid Car",3));
        menu.add(CreateItem("Police-TACTICAL",4));
        menu.add(CreateItem("Police-Routine",5));
        return menu;
    }  

    /**
     * This is a method to create menu and MenuItem
     * this is method also has a inner class 
     * @param This method takes string Name and Int num as a parameter
     * @return this method return JMenuItem
     */
    public JMenuItem CreateItem(String Name, int Num)
    {
        /**
         * This is a inner Class that implements Actionlistener and has a method to add
         * action on  event when the channelItem is clicked.
         */
        class ChannelItemListener implements ActionListener
        {
            /**
             * This is a method to add action to channelItem when it is clicked.
             * @param This method Event paramter to take in,
             * @return this method does not return anything.
             */
            public void actionPerformed(ActionEvent event)
            {
                channelNum = Num; 
                currentChannel .setText("                                     Current Channel: "+ Name);
            }
        }      
        JMenuItem item = new JMenuItem(Name);      
        ActionListener listener = new ChannelItemListener();
        item.addActionListener(listener);
        return item;
    }

    /**
     * This is a inner Class that implements Actionlistener and has a method to add
     * action on  event when the sendbutton is clicked.
     */
    class ButtonListener implements ActionListener
    {
        /**
         * This is a method to add action to sendButton when it is clicked.
         * @param This method Event paramter to take in,
         * @return this method does not return anything.
         */
        public void actionPerformed(ActionEvent event)
        {
            Message = displayArea.getText();
            displayArea.setText("");
            notifyObservers() ;
        }
    }   
    
    /**
     * This is a method to createpanel
     * @param This method  has no parameter to take in.
     * @return this method does not return anything.
     */
    public void createPanel()
    {
        displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        currentChannel = new JLabel("                                     Current Channel: *NOT SELECTED*");

        displayPanel.add(currentChannel,BorderLayout.NORTH);

        displayArea = new JTextArea(10,80);
        displayPanel.add(displayArea,BorderLayout.CENTER);

        sendButton = new JButton("Send Message");
        displayPanel.add(sendButton,BorderLayout.SOUTH);
        ActionListener listener = new ButtonListener();
        sendButton.addActionListener(listener);

    }

    /**
     * This is a method to register object of commsUnit
     * @param This method  has no parameter to take in.
     * @return this method does not return anything.
     */
    public void registerObserver()
    {
        Monitors.add( new CommsUnit(0,"Ambulance 1A7"));
        Monitors.add( new CommsUnit(1,"Ambulance 2C3"));
        Monitors.add( new CommsUnit(2,"Ladder 17"));
        Monitors.add( new CommsUnit(3,"Pumper4"));
        Monitors.add( new CommsUnit(4,"Rescue 51"));
        Monitors.add( new CommsUnit(5,"Aid Car 2"));
        Monitors.add( new CommsUnit(6,"Patrol AB7"));
        Monitors.add( new CommsUnit(7,"Patrol ZM2"));
        Monitors.add( new CommsUnit(8,"Patrol QR8"));
    }

    public  void removeObserver()
    {
        //do nothing method
    }

    /**
     * This is a method to send nofication through creating messagedata Object
     * and MessagePanel object
     * @param This method  has no parameter to take in.
     * @return this method does not return anything.
     */
    public  void notifyObservers() 
    {
        MessageData Msg = new MessageData(channelNum ,Message);
        MessagePanel p = new MessagePanel(Msg);
        p.setMessage();
    }

    /**
     * This is a static helper method
     * @param This method  has no parameter to take in.
     * @return this method returns arraylist.
     */
    public static ArrayList getMonitors()
    {
        return Monitors;
    }
}
