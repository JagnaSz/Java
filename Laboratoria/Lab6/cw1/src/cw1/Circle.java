package cw1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public class Circle extends Shape {
 
	
	public  void draw( Graphics g){
		
		Random random = new Random();
		int COLOUR=random.nextInt()*255;
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D e = new Ellipse2D.Double(random.nextInt(500),random.nextInt(400),150,150);
       

        g2.setColor(new Color(COLOUR));
        g2.fill(e);
        
    }
	
}