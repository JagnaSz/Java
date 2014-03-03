package mypkg;


import java.io.IOException;
import java.util.Scanner;

public class Program {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		//boolean quit = false;
		int choice = 0;
		//do {
		    System.out.println("------Co chcesz zrobiæ?------");
		    System.out.println("Menu programu:");
		    System.out.println("1. Szyfruj plik.");
		    System.out.println("2. Deszyfruj plik");
		    
		    choice = in.nextInt();
		    
		    switch(choice){

		    case 1:
		    	System.out.println("Jakim szyfrem chcesz szyfrowaæ? Wybierz (R)OTT11 lub (P)olibiusz");
		    	String c = in.next();
		    	if(c.toLowerCase().equals("r")){
		    		Cryptographer.cryptfile(args[0], args[1], new ROTT11());
		    	}
		    	else
		    		Cryptographer.cryptfile(args[0], args[1], new Polibuisz());
		    	
		    break;

		    case 2:
		    	System.out.println("Jakiego rodzaju szyfr mam odszyfrowaæ? Wybierz (R)OTT11 lub (P)olibiusz");
		    	String ch = in.next();
		    	if(ch.toLowerCase().equals("r")){
		    		Cryptographer.decryptfile(args[0], args[1], new ROTT11());
		    	}
		    	else
		    		Cryptographer.decryptfile(args[0], args[1], new Polibuisz());

			break;

	default:
		System.out.println("Nieznane polecenie.");
	    }
	    
	//}while(!quit);
	System.out.println("Bye-bye!");
    }

}
