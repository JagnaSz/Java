package cw1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Square extends Shape {

		
		public void draw(Graphics g2){
			Random rand = new Random();
			int C=rand.nextInt()*255 ;
			Graphics2D g1 = (Graphics2D) g2;
			
	        g1.setColor(new Color(C));
	        g1.fillRect(rand.nextInt(500),rand.nextInt(400),120,120);
	       
	        
	        
	    }

	}