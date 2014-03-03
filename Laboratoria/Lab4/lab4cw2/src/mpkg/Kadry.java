package mpkg;
import java.util.*;


public class Kadry  {

	static LinkedList<Pracownik> pracownik = new LinkedList<Pracownik>();
	static Scanner in = new Scanner(System.in);
	
	static void dodajStudenta(String p, double w) {
		pracownik.add(new Student(p,w));
	}
	
	static void dodajEtatowego(String p, double w) {
		pracownik.add(new PracowityEtatowy(p,w));
	}
	
	static void usun(String pes) {
		for(int i=0; i< pracownik.size(); i++) {
			if (pracownik.get(i).pesel.equals(pes)) 
				pracownik.remove(i);
			else System.out.println("Nie znaleziono pracownika o podanym numerze pesel");
		}
	}
	
	static void szukaj(String pes) {
			for(int i=0; i< pracownik.size(); i++) {
				if (pracownik.get(i).pesel.equals(pes)) 
					System.out.println("pesel: " + pracownik.get(i).pesel + ", brutto: " + pracownik.get(i).wynagrodzenieBrutto);
				
			}		
	}
	
	static double pobierzBrutto(String p) {
		for(int i=0; i< pracownik.size(); i++) {
			if (pracownik.get(i).pesel.equals(p)) 
				return pracownik.get(i).wynagrodzenieBrutto;
			else System.out.println("Nie znaleziono pracownika o podanym numerze pesel");
		}
		return -1;
	}
	
	static void nadpiszBrutto(String p, double nowy) {
		for(int i=0; i< pracownik.size(); i++) {
			if (pracownik.get(i).pesel.equals(p)) 
				pracownik.get(i).wynagrodzenieBrutto = nowy;
		}
	}
	
	static double pobierzNetto(String p) {
		for(int i=0; i< pracownik.size(); i++) {
			if (pracownik.get(i).pesel.equals(p)) 
				return pracownik.get(i).wynagrodzenieNetto();
				
		}
		return -1;
	}
	
	static void sortuj() {
		Collections.sort(pracownik, new Sort());
	}

	public static void wyswietl() {
		for(Pracownik element: pracownik)
		    System.out.println(element);
	    }
	
	public static void main(String[] args) {
		boolean quit = false;
		int choice;
		
		do {
		    System.out.println("------Co chcesz zrobiæ?------");
		    System.out.println("Menu programu:");
		    System.out.println("1. Dodaj pracownika");
		    System.out.println("2. Usuñ pracownika");
		    System.out.println("3. Szukaj pracownika");
		    System.out.println("4. Zmieñ wynagrodzenie brutto");
		    System.out.println("5. Pobierz wynagrodzenie brutto");
		    System.out.println("6. Pobierz wynagrodzenie netto");
		    System.out.println("7. Wyœwietl listê pracowników");
		    System.out.println("8. Posortuj po wynagrodzeniu brutto");
		    System.out.println("9. Zakoñcz");
		    choice = in.nextInt();
		    
		    switch(choice){

		    case 1:
		    	System.out.print("Podaj pesel: ");
		    	String pes = in.next();
		    	if(Pesel.sprawdz(pes)) {
		    		System.out.print("Podaj jego wynagrodzenie brutto");
		    		double brutto = in.nextDouble();
		    		System.out.print("Dodajesz (s)tudenta czy (p)racownika etatowego? Wybierz s lub p: ");
		    		String ans = in.next();
		    		if(ans.equals("s"))
		    			dodajStudenta(pes, brutto);
		    		else 
		    			dodajEtatowego(pes, brutto);
		    	}
		    	else
		    		System.out.println("Niepoprawny pesel.");
			break;

		    case 2:
		    	System.out.print("Podaj pesel pracownika, którego chcesz usun¹æ: ");
		    	String p = in.next();
		 
		    	usun(p);
			
			break;

		    case 3:
		    	System.out.print("Podaj pesel pracownika, którego chcesz wyszukaæ: ");
				String pe = in.next();
				
				szukaj(pe);
			break;
			
		    case 4:
		    	System.out.print("Podaj pesel: ");
		    	String _p = in.next();
		    	System.out.print("Podaj jego nowe wynagrodzenie brutto");
		    	double _b = in.nextDouble();
			
				nadpiszBrutto(_p, _b);
			
			break;

		    case 5:
		    	System.out.print("Podaj pesel pracownika, zostanie wyœwietlona kwota brutto: ");
		    	String _pe = in.next();
			
		    	double wyn = pobierzBrutto(_pe);
		    	System.out.println("Wynagrodzenie brutto: " + wyn);
			break;

		    case 6:
		    	System.out.print("Podaj pesel pracownika, zostanie wyœwietlona kwota netto: ");
		    	String _pes = in.next();
			
		    	double w = pobierzNetto(_pes);
		    	System.out.println("Wynagrodzenie netto: " + w);
			break;
			
		    case 7:
		    	wyswietl();
		    	
			break;
			
		    case 8:
		    	sortuj();
		    break;
		    
		    case 9:
			quit = true;
			break;
			
		    default:
			System.out.println("Nieznane polecenie.");
		    }
		    
		}while(!quit);
		System.out.println("Bye-bye!");
	    }

		
	}
	
	
	

