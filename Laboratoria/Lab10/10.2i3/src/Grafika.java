import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Grafika extends java.applet.Applet{

	Samochod S; Lokomotywa L;
	
	public void init(){
		setBackground(Color.orange); // ustawienie koloru t�a okna apletu
		setSize(500,400); // zmiana rozmiaru okna apletu
		
		L = new Lokomotywa();
		S = new Samochod();
	}
	
	public void paint(Graphics g){
		int[] x = {0, getWidth()/2, getWidth()}; 
		// nowa tablica jest tworzona na podstawie opisu jej element�w,
		int[] y = {0, 60, 0}; 
		// oddzielonych przecinkami i zawartych w nawiasach klamrowych
		Wielobok T = new Wielobok(x, y);
		
				
		 //klasy Graphics i Font trzeba importowa�
		g.clearRect(0, 0, getWidth(), getHeight()); 
		//wype�nienie obszaru apletu kolorem t�a
		Font f = new Font("SanSerif", Font.ITALIC, 18);
		 //utworzenie czcionki o podanej nazwie, stylu i rozmiarze
		g.setFont(f);
		
		T.rysuj(g, Color.WHITE);
		
		g.setColor(Color.blue);
		String s="RYSOWANIE WIELOBOK�W";
		g.drawString(s, (getWidth()-g.getFontMetrics().stringWidth(s))/2, 20);
		
		L.rysuj(g, Color.black);
		S.rysuj(g, Color.red);
		}
}
