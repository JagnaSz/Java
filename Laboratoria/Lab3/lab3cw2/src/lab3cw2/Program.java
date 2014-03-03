package lab3cw2;


public class Program {

	public static void main(String[] args) {
		PracowityStudent st = new PracowityStudent();
		/*st.dodajZajecia();
		st.wyswietl();*/
		
		Pracownik a = st.rzutujNaPracownika();
		a.dodajZajecia();
		st.wyswietl();
		a.wyswietl();
		
		
	}

}
