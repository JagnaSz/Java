package Graphics;

import java.awt.Graphics;

import javax.swing.JFrame;

import Exceptions.CwCreatingException;


public class ExceptionFrame extends JFrame {

	private String message;
	
	public ExceptionFrame(CwCreatingException e){
		message = e.getMessage();
	}
	
	public void paint(Graphics g){
		revalidate();
		g.drawString(message,125,90);
		
	}
}
