package cw1;

import java.awt.Graphics;
import java.awt.Panel;
import java.util.LinkedList;


public class MyPanel extends Panel {
	LinkedList<Shape> shapes = new LinkedList<Shape>();
	public MyPanel(){
	
	shapes.add(new Circle());
	shapes.add(new Rectangle());
	shapes.add(new Square());
	shapes.add(new Triangle());
	shapes.add(new Star());
	
	}
	public void paint(Graphics g) {
		
	       for(Shape sh: shapes) 
	    	  sh.draw(g);
	    }
	
	
}
