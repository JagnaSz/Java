package mpkg;

public class Student extends Pracownik {
	
	public Student(String _pesel, double wynagrodzenie) {
		pesel = _pesel;
		wynagrodzenieBrutto = wynagrodzenie;
	}
	double wynagrodzenieNetto() {
		return 0.77* wynagrodzenieBrutto;
		
	}
	
	public String toString() {
		return "pesel: " + pesel + ", wynagrodzenie brutto: " + wynagrodzenieBrutto;
	    }

}
