package mypkg;



import java.io.IOException;


public class ROTT11 implements Algorythm {
	
	static private final int CH_A = (int) 'A';
	static private final int CH_Z = (int) 'Z';

	static private final int CH_a = (int) 'a';
	static private final int CH_z = (int) 'z';

	private int rotation = 11;
	
	
	public String crypt(String nazwa) throws IOException {
		
			StringBuffer result = new StringBuffer((int) nazwa.length());
			String zdanie;
			zdanie = nazwa;
			
		 		for (char c : zdanie.toCharArray()) {
		 			
		 			int CH_c = (int) c;
		 			int new_char = 0;
		 			if (Character.isUpperCase(c)) {
		 				if((CH_c >= CH_A) && (CH_c <= (CH_Z-rotation))) {
		 					new_char = CH_c + rotation;
		 				}
		 				else  {
		 				    new_char = CH_c + rotation - 26; 
		 				}
		 	
		 			}
		 			else if (Character.isLowerCase(c)) {
		 				if((CH_c >= CH_a) && (CH_c <= (CH_z-rotation))) {
		 					new_char = CH_c + rotation;
		 				}
		 				else  {
		 				    new_char = CH_c + rotation - 26; 
		 				}
		 			}
		 			else new_char = CH_c;
		 			
		 			result.append((char) new_char);
		 			
		 		}
		
		 		return result.toString();
		 		
			
	}	
			
				
	public String decrypt(String nazwa) throws IOException {
		
		
		StringBuffer result = new StringBuffer((int) nazwa.length());
		
		
		String zdanie;
		zdanie = nazwa;
		
	 		for (char c : zdanie.toCharArray()) {
	 			
	 			int CH_c = (int) c;
	 			int new_char = 0;
	 			if (Character.isUpperCase(c)) {
	 				if((CH_c >= (CH_A+rotation)) && (CH_c <= CH_Z)) {
	 					new_char = CH_c - rotation;
	 				}
	 				else  {
	 					new_char = CH_c - rotation + 26; 
	 				}
	 	
	 			}
	 			else if (Character.isLowerCase(c)) {
	 				if((CH_c >= (CH_a+rotation)) && (CH_c <= CH_z)) {
	 					new_char = CH_c - rotation;
	 				}
	 				else  {
	 					new_char = CH_c - rotation + 26; 
	 				}
	 			}
	 			else new_char = CH_c;
	 			
	 			result.append((char) new_char);
	 			
	 		}
	 		
	 		return result.toString();
		
	}
}
