package mypkg;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptographer {
	
	static void cryptfile(String  we, String wy , Algorythm algorytm) throws IOException {
		
		File file = new File(we);
		Scanner in = new Scanner(file);
		PrintWriter zapis = new PrintWriter(wy);
		
		while (in.hasNextLine()) {
		zapis.println(algorytm.crypt(in.nextLine()));
		}
		
		zapis.close();
		in.close();
	}
	
	static void decryptfile(String we, String wy,  Algorythm algorytm) throws IOException {
		
		File file = new File(we);
		Scanner in = new Scanner(file);
		PrintWriter zapis = new PrintWriter(wy);

		while (in.hasNextLine()) {
			zapis.println(algorytm.decrypt(in.nextLine()));
			}
		
		zapis.close();
		in.close();
	}
}
