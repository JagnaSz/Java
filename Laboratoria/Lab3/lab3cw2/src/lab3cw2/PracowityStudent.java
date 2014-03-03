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
			iloscZajec++;	//zwiêksza iloœæ zajêæ dla Pracownika
			PracowityStudent.this.dodajZajecia();  //zwiêksza iloœæ zajêæ dla PracowitegoSt. 
		}
		
		public void wyswietl() {
			System.out.println(iloscZajec);
		}
	}
}	


