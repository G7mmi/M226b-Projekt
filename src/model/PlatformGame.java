package model;
import java.awt.Dimension;
import java.awt.Toolkit;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class PlatformGame {

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		
		frame.setSize(900,900);
		/**
		 * Fenster wird mittig angezeicht im Bildschirm
		 */
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) (screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int) (screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
		/**
		 * Fenstergrösse nicht änderbar
		 */
		frame.setResizable(false);
		frame.setTitle("Platform Game");
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

}
