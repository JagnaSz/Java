import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;


public class Wielobok extends Polygon {

	public Wielobok(int[] x, int[] y) {
		super(x, y, Math.min(x.length, y.length));
	} 
	
	void rysuj(Graphics g, Color k) {
		Color b = g.getColor(); g.setColor(k);
		 //zapamiêtanie i zmiana bie¿¹cego koloru dla kanwy graficznej
		g.fillPolygon(this); 
		// narysowanie wieloboku o kszta³cie obiektu klasy Wielobok (Polygon)
		g.setColor(b); // przywrócenie bie¿¹cego koloru kanwy
	}
	
	
}
