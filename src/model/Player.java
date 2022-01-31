package model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import controller.GamePanel;

public class Player {
	
	GamePanel panel;
	
	int x;
	int y;
	int width;
	int height;
	
	double xspeed;
	double yspeed;
	
	Rectangle hitBox;
	
	public boolean keyLeft;
	public boolean keyRight;
	public boolean keyUp;
	public boolean keyDown;
	
	
	public Player(int x, int y, GamePanel panel) {
		
		this.panel = panel;
		this.x = x;
		this.y = y;
		
		//Player grösse
		width = 30;
		height = 80;
		
		//Player hitbox
		hitBox = new Rectangle(x, y, width, height);
	}
	
	public void set() {
		if(keyLeft && keyRight || !keyLeft && ! keyRight) xspeed *=0.8;
		else if(keyLeft && !keyRight) xspeed --;
		else if(keyRight && !keyLeft) xspeed ++;
		
		if(xspeed > 0 && xspeed < 0.75) xspeed = 0;
		if(xspeed < 0 && xspeed > -0.75) xspeed = 0;
		
		if(xspeed > 7) xspeed = 7;
		if(xspeed < -7) xspeed = -7;
		
		if(keyUp) {
			
			hitBox.y ++;
			for(Wall wall: panel.walls) {
				if(wall.hitBox.intersects(hitBox)) yspeed = -8;
			}
			hitBox.y --;

			
		}
		
		yspeed += 0.3;
		
		//Horizontale Kollision
		hitBox.x += xspeed;
		for(Wall wall: panel.walls) {
			if(hitBox.intersects(wall.hitBox)) {
				hitBox.x -=xspeed;
				while(!wall.hitBox.intersects(hitBox)) hitBox.x += Math.signum(xspeed);
				hitBox.x -= Math.signum(xspeed);
				xspeed = 0;
				x = hitBox.x;
			}
		}
		
		//Vertikale Kollision
		hitBox.y += yspeed;
		for(Wall wall: panel.walls) {
			if(hitBox.intersects(wall.hitBox)) {
				hitBox.y -=yspeed;
				while(!wall.hitBox.intersects(hitBox)) hitBox.y += Math.signum(yspeed);
				hitBox.y -= Math.signum(yspeed);
				yspeed = 0;
				y = hitBox.y;
			}
		}
		//Geschwindigkeit erhöhen
		x += xspeed;
		y += yspeed;
		
		hitBox.x = x;
		hitBox.y = y;
	}
	
	public void draw(Graphics2D gtd) {
		gtd.setColor(Color.yellow);
		gtd.fillRect(x, y, width, height);
		gtd.setColor(Color.RED);
		if(keyLeft == true) {
			gtd.fillOval(x-5, y+5, width, height-70); 
		}else if(keyRight == true) {
			gtd.fillOval(x+5, y+5, width, height-70);	
		}else{
			gtd.fillOval(x, y+5, width, height-70);
		}
	}
}
