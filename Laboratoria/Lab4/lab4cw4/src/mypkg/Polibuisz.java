package mypkg;


import java.io.IOException;
import java.util.Scanner;

public class Polibuisz implements Algorythm {

	public String crypt(String nazwa) throws IOException {
		
		char [][] tab = { {'a', 'b', 'c', 'd','e'}, {'f', 'g', 'h', 'i', 'k'}, {'l', 'm', 'n', 'o', 'p'}, {'q', 'r', 's', 't', 'u'}, {'v', 'w' ,'x' ,'y', 'z'}};
		
		String result = new String();
		nazwa = nazwa.toLowerCase();
		Scanner in = new Scanner(nazwa);
		while(in.hasNext()) {
			nazwa = in.next();
			for(int i = 0; i < nazwa.length(); i++){
				for(int j = 0; j < 5; j++) {
					for(int k = 0; k < 5; k++) {
						if(nazwa.charAt(i)== tab[j][k]) {
							result += (char)j+1;
							result += (char)k+1;
						}
					}
				}	
			}
			result += " ";
		}	
		in.close();
		return result;
		
	}

	
	public String decrypt(String zdanie) throws IOException {
		
		char [][] tab = { {'a', 'b', 'c', 'd','e'}, {'f', 'g', 'h', 'i', 'k'}, {'l', 'm', 'n', 'o', 'p'}, {'q', 'r', 's', 't', 'u'}, {'v', 'w' ,'x' ,'y', 'z'}};
		
		String result = new String();                        
		Scanner in = new Scanner(zdanie);
		String nazwa = new String();
		
		while(in.hasNext()) {
			nazwa = in.next();
			char[] c = nazwa.toCharArray();
			for(int i=0; i < c.length; i+=2) {
				result+= tab[(int)(c[i]-49)][(int)(c[i+1]-49)];
				
			}
			result+=" ";					
		}	
		in.close();
		return result;
	}

}
