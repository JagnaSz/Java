package cw2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;



public class MyPanel extends JPanel  {
	
	double []x;
	double []y;
	int n;
	int sx = 300;
	int sy = 300;
	double skx;
	double sky;
	
	public MyPanel(double []x, double []y, int n) {
		this.x = x;
		this.y = y;
		this.n = n;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
	
		double max = 0;
		
		for (int i=0; i<n; ++i)
			if(modul(y[i])> max)
				max = modul(y[i]);
		
		sky = 150/max;
		
		if(modul(x[n-1])> modul(x[0]))
			skx = 200/x[n-1];
		else
			skx = 200/x[0];
		if(skx<0)
			skx = -skx;
		
		
		g2.setColor(Color.RED);
		
	    for (int i=0; i<n-1; ++i) 
	    	g2.drawLine(sx+(int)(x[i]*skx), sy-(int)(y[i]*sky), sx+(int)(x[i+1]*skx), sy-(int)(y[i+1]*sky));
	   
	   
	    g2.setColor(Color.black);
	    g2.drawLine(sx-220, sy, sx+220,sy); //oœ x
	    g2.drawLine(sx+210, sy+5, sx+220, sy);
	    g2.drawLine(sx+220,sy,sx+210,sy-5);
	    g2.drawLine(sx, sy+220, sx,sy-220); //oœ y
	    g2.drawLine(sx-5, sy-210, sx, sy-220);
	    g2.drawLine(sx, sy-220, sx+5,sy-210);
	     
	    
	    for(int i=0;i<15;i++){ //podzia³ki
	    	g2.drawLine(sx+15*i, sy-5, sx+15*i, sy+5);
	    	g2.drawLine(sx-15*i, sy-5, sx-15*i, sy+5);
	    	g2.drawLine(sx-5, sy-15*i, sx+5, sy-15*i);
	    	g2.drawLine(sx-5, sy+15*i, sx+5, sy+15*i);
	    }
	    
	    g2.drawString(Double.toString((int)((150/sky)*100)/100), sx+6,sy-145);
	    g2.drawString(Double.toString((int)((x[0])*100)/100),sx+(int)(skx*x[0])-10,sy+15);
	    g2.drawString(Double.toString((int)((x[n-1])*100)/100), sx+(int)(skx*x[n-1])-10, sy+15);
	}
	
	
	public double modul(double x) {
		if(x<0)
			x=-x;
		return x;
	}
}
