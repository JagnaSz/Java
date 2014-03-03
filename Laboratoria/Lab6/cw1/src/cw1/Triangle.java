package cw1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Triangle extends Shape {

	public void draw(Graphics g) {
		Random rand = new Random();
		int COLOUR=rand.nextInt()*255;
		Graphics2D g2d = (Graphics2D) g;
	
		int []X = {250,150,60};
		int []Y = {100,10,90};
		g2d.setColor(new Color(COLOUR));
		g2d.translate(rand.nextInt(500),rand.nextInt(400));
		g2d.fillPolygon(X,Y,3);
		
	}
}
