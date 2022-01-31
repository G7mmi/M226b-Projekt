package model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Wall {
	
	int x;
	int y;
	int width;
	int height;
	Color myColor;
	
	Rectangle hitBox;
	
	public Wall(int x, int y, int width, int height, Color myColor) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.myColor = myColor;
		
		hitBox = new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics2D gtd) {
		gtd.setColor(Color.LIGHT_GRAY);
		gtd.drawRect(x, y, width, height);
		gtd.setColor(myColor);
		gtd.fillRect(x+1, y+1, width-2, height-2);
		
	}
}
