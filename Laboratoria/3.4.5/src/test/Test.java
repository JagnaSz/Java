package test;

import java.util.*;
import pD.*;

public class Test {
    
    static Scanner in = new Scanner(System.in);
    static LinkedList<Punkt3D> punkty = new LinkedList<Punkt3D>();
    
    public static void main(String[] args) {
	
	boolean quit = false;
	int choice;
	
	do {
	    System.out.println("------Co chcesz zrobiæ?------");
	    System.out.println("Menu programu:");
	    System.out.println("1. Wczytaj punkt 3D");
	    System.out.println("2. Wyœwietl wszystkie punkty");
	    System.out.println("3. Oblicz odleg³oœæ");
	    System.out.println("4. Zakoñcz");
	    choice = in.nextInt();
	    
	    switch(choice){

	    case 1:
		System.out.println("***********************************************");
		wczytaj();
		System.out.println("***********************************************");
		break;

	    case 2:
		System.out.println("***********************************************");
		wyswietl();
		System.out.println("***********************************************");
		break;

	    case 3:
		System.out.println("***********************************************");
		dyst();
		System.out.println("***********************************************");
		break;
		
	    case 4:
		quit = true;
		break;
		
	    default:
		System.out.println("Nieznane polecenie.");
	    }
	}while(!quit);
	System.out.println("Bye-bye!");
    }

    
    public static void wczytaj() {
	System.out.print("Podaj 3 wspó³rzêdne x,y,z: ");
	double x = in.nextDouble();
	double y = in.nextDouble();
	double z = in.nextDouble();
	punkty.add(new Punkt3D(x,y,z));	
    }
	
    public static void wyswietl() {
	for(Punkt3D element: punkty)
	    System.out.println(element);
    }
   
    public static void dyst() {
	if(punkty.size() > 1) {
	    System.out.println("Wybierz indeksy dwóch punktów a ja obliczê dystans miêdzy nimi (indeksy zaczynaj¹ siê od 1): ");
	    int a = in.nextInt();
	    int b = in.nextInt();
	    
	    System.out.println("Dystans wynosi: "+ ((Punkt3D)punkty.get(a-1)).distance((Punkt3D)punkty.get(b-1)));
	}
	else 
	    System.out.println("Brak danych! Nie mo¿na nic obliczyæ!");
    }
    
}


