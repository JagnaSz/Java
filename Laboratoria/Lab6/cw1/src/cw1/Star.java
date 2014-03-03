package cw1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.Random;

public class Star extends Shape {

	@Override
	public void draw(Graphics g) {
		Random random = new Random();
		int COLOUR=random.nextInt()*255;
		Graphics2D g2 = (Graphics2D)g;
		
		int[] x = {155, 167, 209, 173, 183, 155, 127, 137, 101, 143};
	    int[] y = {100, 136, 136, 154, 196, 172, 196, 154, 136, 136};

	      GeneralPath star = new GeneralPath();
	      star.moveTo(x[0],y[0]);
	      for (int i=1; i<x.length; ++i) star.lineTo(x[i], y[i]);
	      star.closePath();
	      
	      g2.setColor(new Color(COLOUR));
	      g2.fill(star);
	      //g2.setColor(new Color (0.2f, 0.2f, 0.2f, 0.7f));
	      //g2.draw(star);

	}

}
