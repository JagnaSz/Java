package lab3cw2;

abstract class Student {
	protected int iloscZajec=1;
	
	public abstract void dodajZajecia();
	public abstract void wyswietl();
}

abstract class Pracownik {
	protected int iloscZajec=4;
	
	public abstract void dodajZajecia();
	public abstract void wyswietl();
}



class PracowityStudent extends Student {
	public InnerPracownik rzutujNaPracownika() {
		return new InnerPracownik();
	}

	public void dodajZajecia() {
		iloscZajec++;
	}

	public void wyswietl() {
		System.out.println(iloscZajec);
	}

	class InnerPracownik extends Pracownik {

		public void dodajZajecia() {
			iloscZajec++;	//zwi�ksza ilo�� zaj�� dla Pracownika
			PracowityStudent.this.dodajZajecia();  //zwi�ksza ilo�� zaj�� dla PracowitegoSt. 
		}
		
		public void wyswietl() {
			System.out.println(iloscZajec);
		}
	}
}	


