import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// Importing the package that contains all the Swing Components and Classes.
    
public class FirstFrame{
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        //Create and set up the frame. 
        //The string passed as an argument will be displayed 
        //as the title.
    
	JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("GridBag Pls Work");
    
	GameInterface demo = new GameInterface();
	frame.setContentPane(demo.createContentPane());

        //Display the window.
        frame.pack();
	frame.setLocation(200,300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }  
}
