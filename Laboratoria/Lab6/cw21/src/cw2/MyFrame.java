package cw2;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


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
		zakres = new JTextField("-1,1",5);
		krok = new JTextField("1",3);
		add(new JLabel("Wspó³czynniki wielomianu: "));
		add(wiel);
		add(new JLabel("Zakres danych: "));
		add(zakres);
		add(new JLabel("Krok: "));
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
			
			revalidate();
			
			try{
				String wspl[] = new String[wiel.getText().length()];
				wspl = wiel.getText().split(",");
				String z[] = new String[zakres.getText().length()];
				z = zakres.getText().split(",");
				String k = new String();
				k = krok.getText();
				
			
				double kr;
				double start;
				double koniec;
				double []w = new double[wspl.length];
			
			
				try{
					for(int i=0; i < wspl.length; i++) {
						if(wspl[i].startsWith("-")){
							w[i] = -Double.parseDouble(wspl[i]);
							w[i] = -w[i];
						}
						else
							w[i] = Double.parseDouble(wspl[i]);
					}
				
					kr = Double.parseDouble(k);
			
			
						start = Double.parseDouble(z[0]);
	
						koniec = Double.parseDouble(z[1]); 
				}catch(Exception e) {
					throw new Exception("Z³y format wprowadzonych danych!");
				}
				
				if(((start < 0)&&(koniec<0)&&(start>koniec)) || ((start > 0)&&(koniec<0)) || ((start>0)&&(koniec>0))&&(start>koniec))
					throw new Exception("Nieprawid³owy zakres danych!");
				
				int nx = (int)((koniec-start)/kr);
				if(nx<0)
					nx = -nx;
				nx+=1;
				
			
				double []x = new double[nx];
				double []y = new double[nx];
				
				while(start<=koniec) {
					for(int i=0;i<nx;i++) {
						x[i]=start;
						for(int j=0; j<wspl.length; j++) {
							y[i]+= w[j]*Math.pow(x[i],w.length-j-1); 
						}
						
						start+=kr;
						
					}
				}
				
				panel = new MyPanel(x,y,nx);
				
				panel.setSize(600,600);
				add(panel);
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
			repaint();
		
		}

	}

}
