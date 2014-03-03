package cw1;


import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main {
	
	public static void main(String[] args) {
		
			SizedFrame frame = new SizedFrame();
			frame.setSize(700, 600);
			frame.setVisible(true);
			frame.setResizable(false);
			
	}
}


class SizedFrame extends Frame {

	public SizedFrame(){
		
		MyPanel p = new MyPanel();
		p.setSize(660, 550);
		add(p);
		
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
               System.exit(0);
            }
        });

		}
}
