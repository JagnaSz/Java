package cw2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MyPanel extends JPanel  {
	
	double []x;
	double []y;
	int n;
	int sx = 300;
	int sy = 300;
	public MyPanel(double []x, double []y, int n) {
		this.x = x;
		this.y = y;
		this.n = n;
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		GeneralPath plot = new GeneralPath();
		
	      plot.moveTo(sx,sy);
	      for (int i=1; i<n; ++i) 
	    	  plot.lineTo(sx+x[i],sy- y[i]);
	      
	      
	      g2.drawLine(sx-220, sy, sx+220,sy); //x
	      g2.drawLine(sx+210, sy+5, sx+220, sy);
	      g2.drawLine(sx+220,sy,sx+210,sy-5);
	      g2.drawLine(sx, sy+220, sx,sy-220); //y
	      g2.drawLine(sx-5, sy-210, sx, sy-220);
	      g2.drawLine(sx, sy-220, sx+5,sy-210);
	      g2.setColor(Color.BLUE);
	      plot.moveTo(200, 200);
	      
	      g2.draw(plot);
	      
		
		
	}
	
	
}
