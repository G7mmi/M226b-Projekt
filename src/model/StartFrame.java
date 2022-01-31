package model;
import java.awt.Color;

import controller.GamePanel;

public class StartFrame extends javax.swing.JFrame{
	
	public StartFrame() {
		GamePanel panel1 = new GamePanel();
		panel1.setLocation(0,0);
		panel1.setSize(this.getSize());
		panel1.setBackground(Color.WHITE);
		panel1.setVisible(true);
		this.add(panel1);
		
		addKeyListener(new KeyChecker (panel1));
	}
	
	

	
}
