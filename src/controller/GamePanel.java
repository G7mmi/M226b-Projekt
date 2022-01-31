package controller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


import model.*;

public class GamePanel extends javax.swing.JPanel implements ActionListener{

	/**
	 * enum für Spielzustand
	 * @author Daniel
	 *
	 */
	enum SpielZustand{
		Start, Spielen, Spielende;
	}
	
	/**
	 * setzt aktuellen state auf Start
	 */
	SpielZustand state = SpielZustand.Start;
	
	Player player;
	public ArrayList<Wall>walls = new ArrayList<>();
	
	Timer gameTimer;
	
	
	/**
	 * 
	 */
	public void draw() {
		switch (state) {
	//	case Start: drawStartScreen(); break;
		case Spielen: paint(null); break;
		case Spielende: keyPressedEndScreen(null); break;
		}
	}
	
	void drawStartScreen(Graphics2D gtd) {
		setBackground(Color.BLACK);
		gtd.setColor(Color.WHITE);
		gtd.drawString("Start, press S", 50, 50);
	}
	
	void drawEndScreen(Graphics2D gtd) {
		setBackground(Color.LIGHT_GRAY);
		gtd.setColor(Color.BLACK);
		gtd.drawString("You Won", 50, 50);
	}
	
	public void keyPressed() {
		switch (state) {
		case Start: keyPressedStartScreen(null); break;
		case Spielen: paint(null); break;
		case Spielende: keyPressedEndScreen(null); break;
		}
	}
	
	void keyPressedStartScreen(KeyEvent e)  {
		if(e.getKeyChar() == 'e') {
			state = SpielZustand.Spielen;
		}
	}
	
	
	void keyPressedEndScreen(KeyEvent e) {
		if (e.getKeyChar() == 'q') {
			state = SpielZustand.Start;
		}
	}

	
	public GamePanel() {
		
		player = new Player(400, 300, this);
		
		makeWalls();
		
		gameTimer = new Timer();
		gameTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				player.set();
				repaint();
			}
		/**
		 * alle 17 milisekunden aktualisieren = 60 fps
		 */
		}, 0, 17);
	}
	
	//Wände erstellen und zur ArrayList walls hinzufügen
	public void makeWalls() {
		//Boden erstellen
		for(int i = 50; i < 900; i+=50) {
			walls.add(new Wall(i, 850, 50, 50, Color.WHITE));
		}
		//linke Mauer erstellen
		for(int i = 50; i < 900; i+=50) {
			walls.add(new Wall(0, i, 50, 50, Color.WHITE));
		}
		//rechte Mauer erstellen
		for(int i = 50; i < 900; i+=50) {
			walls.add(new Wall(850, i, 50, 50, Color.WHITE));
		}
		//Bett für Story und Start
		walls.add(new Wall(600, 825, 50,25, Color.RED));
		walls.add(new Wall(650, 825, 50,25, Color.RED));
		walls.add(new Wall(700, 825, 50,25, Color.RED));
		
		
		/**
		 * kleines "test" jump and run
		 * xrechts = 800, xlinks = 50
		 */
			walls.add(new Wall(800, 750, 50,50, Color.black));
			walls.add(new Wall(600, 650, 50,50, Color.black));
			walls.add(new Wall(550, 600, 50,50, Color.black));
			walls.add(new Wall(500, 450, 50,50, Color.black));
			walls.add(new Wall(500, 500, 50,50, Color.black));
			walls.add(new Wall(700, 500, 50,50, Color.black));
			
			walls.add(new Wall(250, 700, 50,50 ,Color.black));
			walls.add(new Wall(50, 600, 50,50, Color.black));
		
		//wand mitte unten
		for(int i = 50; i < 300; i+=50) {
			walls.add(new Wall(250, i+250, 50, 50, Color.WHITE));
				}
			walls.add(new Wall(200, 500, 50,50, Color.GRAY));
			walls.add(new Wall(50, 400, 50,50, Color.GRAY));
			walls.add(new Wall(250, 150, 50, 50, Color.GRAY));
			walls.add(new Wall(250, 100, 50, 50, Color.GRAY));
			walls.add(new Wall(500, 250, 50,50, Color.LIGHT_GRAY)); //--> unsichtbar gemacht
			walls.add(new Wall(750, 250, 50,50, Color.GRAY));
			walls.add(new Wall(800, 150, 50,50, Color.GRAY));

		
		
		
	}
	
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		Graphics2D gtd = (Graphics2D) g;
		
		player.draw(gtd);
		
		for(Wall wall: walls) wall.draw(gtd);
	}
	
	

	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'a') player.keyLeft = true;
		if(e.getKeyChar() == 'w') player.keyUp = true;
		if(e.getKeyChar() == 's') player.keyDown = true;
		if(e.getKeyChar() == 'd') player.keyRight = true;
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'a') player.keyLeft = false;
		if(e.getKeyChar() == 'w') player.keyUp = false;
		if(e.getKeyChar() == 's') player.keyDown = false;
		if(e.getKeyChar() == 'd') player.keyRight = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		}
	
}
