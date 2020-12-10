import javax.swing.*;
import java.util.*;
/**
 * This is a class from where program starts to execute and obviuosly has 
 * a main method.
 * @author (your name)
 * @version (a version number or a date)
 */
public class EMSCommsViewer
{
    public static void main(String[] args)
    {  
        JFrame frame = new PrimaryConsole();
        //arraylist for displaying commsunit frames.
        ArrayList<CommsUnit>  objects = PrimaryConsole.getMonitors();
        for(int i = 0; i<9; i++ )
        {
            JFrame frame1 = objects.get(i);
            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame1.setVisible(true);  
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("911 Comms Primary Console");
        frame.setVisible(true); 
    }
}
