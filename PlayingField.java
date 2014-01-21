import javax.swing.*;
import java.awt.*;

public class PlayingField {

    public JPanel createContentPane() {

	JPanel totalGUI = new JPanel();

	JPanel mainPanel = new JPanel(new GridLayout(3,4,10,30));

    }

    public static void showGUI() {

	JFrame frame = new JFrame ("Map 1");

	PlayingField demo = new PlayingField();
	frame.setContentPane(demo.createContentPane());

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);

    }

    public static void main(String[] args) {
	SwingUtilities.invokeLater(newRunnable() {
		public void run() {
		    showGui();
		}
	    });
    }

}
