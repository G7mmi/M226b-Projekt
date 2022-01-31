package model;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import controller.GamePanel;

public class KeyChecker extends KeyAdapter{
	
	GamePanel panel;
	
	public KeyChecker(GamePanel panel) {
		this.panel = panel;
	}
	/**
	 * bei Betätigen eines, key gibt es es keyPressed event
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		panel.keyPressed (e);
	}
	/**
	 * beim Loslassen eines key, gibt es ein keyReleaed event
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		panel.keyReleased(e);
	}
}
