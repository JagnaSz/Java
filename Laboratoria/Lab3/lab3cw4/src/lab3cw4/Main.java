package lab3cw4;

import java.util.*;

public class Main {

	static LinkedList<Shape> ksztalty = new LinkedList<Shape>();
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean quit = false;
		int choice;
		
		do {
		    System.out.println("------What do you wanna do?------");
		    System.out.println("Menu programu:");
		    System.out.println("1. Add Circle");
		    System.out.println("2. Add Triangle");
		    System.out.println("3. Add Rectangle");
		    System.out.println("4. Print list");
		    System.out.println("5. Quit");
		   
		    choice = in.nextInt();
		    
		    switch(choice){

		    case 1:
		    	Shape kolo = new Circle();
		    	ksztalty.add(kolo);
		    break;

		    case 2:
		    	Shape trojkat = new Triangle();
		    	ksztalty.add(trojkat);
			break;

		    case 3:
		    	Shape prostokat = new Rectagnle();
		    	ksztalty.add(prostokat);	
			break;
			
		    case 4:
		    	for(Shape ksz: ksztalty)
		    		ksz.draw();
			break;
		    
		    case 5:
				quit = true;
				break;
		    
		    default:
			System.out.println("Nieznane polecenie.");
		    }
		}while(!quit);
		System.out.println("Bye-bye!");
	    }
	}


