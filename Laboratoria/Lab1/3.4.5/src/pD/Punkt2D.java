package pD;

import static java.lang.Math.*;


public class Punkt2D {

    private  double x,y;

    public Punkt2D(double _x, double _y) {
	this.x = _x;
	this.y = _y;
    }

    public double getX() {
	return this.x;
    }

    public double getY() {
	return this.y;
    }

    public void setX(double _x) {
	x = _x;
    }

    public void setY(double _y) {
	y = _y;
    }

    public double distance(Punkt2D punkt) {
	double wynik = sqrt(pow((this.x - punkt.x), 2) + pow((this.y - punkt.y), 2));
	return wynik;
    }

    public String toString() {
	/**return getClass().getName()*/
	   return "[x= " + x
	       + ", y= " + y;
	    
    }
} 
