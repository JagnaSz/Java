package mpkg;

public class PracowityEtatowy extends Pracownik {
	
	public PracowityEtatowy(String _pesel, double wynagrodzenie) {
		pesel = _pesel;
		wynagrodzenieBrutto = wynagrodzenie;
	}
	double wynagrodzenieNetto() {
		return 0.50* wynagrodzenieBrutto;
		
	}

	public String toString() {
		return "pesel: " + pesel + ", wynagrodzenie brutto: " + wynagrodzenieBrutto;
	    }

}
