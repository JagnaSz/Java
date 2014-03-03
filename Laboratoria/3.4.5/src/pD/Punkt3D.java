package pD;

import static java.lang.Math.*;

public class Punkt3D extends Punkt2D {
    
    private double z;

    public Punkt3D(double _x, double _y, double  _z) {
	super(_x, _y);  //super s³u¿y do do wywo³ywania konstruktorów klasy nadrzêdnej
	this.z = _z;
    }

    public void getZ(double _z) {
	this.z = _z;
    }

    public double getZ() {
	return this.z;
    }

    public double distance(Punkt3D pkt) {
	double pow_2d = pow(super.distance(pkt), 2);

	double wynik = sqrt(pow_2d + pow(this.z - pkt.z, 2));

	return wynik;
    }

    public String toString() {
	return super.toString()
	    +", z= " + z
	    + "]";
    }
    
}
