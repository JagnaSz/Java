package cw2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class MyFrame extends JFrame {
	
	final JTextField wiel;
	final JTextField zakres;
	final JTextField krok;
	final JButton button;
	MyPanel panel;
	public MyFrame(){
		
		setTitle("Wykresy funkcji!");
		this.setLayout(new FlowLayout());
		wiel = new JTextField(10);
		zakres = new JTextField(5);
		krok = new JTextField(3);
		add(new JLabel("Wpisz wielomian: "));
		add(wiel);
		add(new JLabel("Podaj zakres danych: "));
		add(zakres);
		add(new JLabel("Podaj krok: "));
		add(krok);
		
		ButtonListener bl = new ButtonListener();
		button = new JButton("Narysuj wykres!");
		button.addActionListener(bl);
		add(button);
		pack();
	}
	
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			String wspl = new String();
			wspl = wiel.getText();
			String z = new String();
			z = zakres.getText();
			String k = new String();
			k = krok.getText();
			System.out.println(k);
			
			double kr = Double.parseDouble(k);
			double start = Double.parseDouble(z.substring(0,1));
			double koniec = Double.parseDouble(z.substring(1,z.length()));
			double []w = new double[wspl.length()];
			for(int i= 0; i < w.length; i++)
				w[i] = Double.parseDouble(wspl.substring(i, i+1));
			
			int n = (int)((koniec-start)/kr)+1;
			System.out.println(n);
			double []x = new double[n];
			double []y = new double[n];
		
			System.out.println(w.length + " " + x.length + " " + y.length);
			while(start<=koniec) {
				for(int i=0;i<n;i++) {
					x[i]=start;
					for(int j=0; j<w.length; j++) {
						y[i]+= w[j]*Math.pow(x[i],w.length-j-1); 
					}
					
					start+=kr;

				}
			}
			
			for(int i=0;i<n;i++)
				System.out.println(x[i] + " " + y[i]);
			
			panel = new MyPanel(x,y,n);
			panel.setSize(600,600);
			add(panel);
			
			repaint();
			
		
		}

	}

}
