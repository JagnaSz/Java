package mypkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Subtitle {
	
	 public static void delay(String in, String out, int delay, int fps) throws FileNotFoundException, BadFormatException {
		File open = new File(in);
		Scanner read = new Scanner(open);
		PrintWriter write = new PrintWriter(out); 
		
		try{
			while(read.hasNext()) {
			
				String line = read.nextLine();
				int first_start = line.indexOf("{");
				int first_stop = line.indexOf("}");
				int second_start = line.indexOf("{", first_stop+1);
				int second_stop = line.indexOf("}", second_start);
				
				int przesun = (int)((double)delay/(1000/(double)fps));
				
				String start = line.substring(first_start+1, first_stop);
				String stop = line.substring(second_start+1, second_stop);
				String text = line.substring(second_stop+1);
			
				Integer time1;
				Integer time2;
				
				try{
					 time1 = Integer.parseInt(start) + przesun;
					 time2 = Integer.parseInt(stop) + przesun;
				}
				
				catch (Exception e) {
					throw new BadFormatException("Z³y format wartoœci klatki");
				}	
				
				if(time1 > time2)
					throw new BadFormatException("Niepoprawna sekwencja klatki pocz¹tkowej i koñcowej");
				
				String str_time1 = time1.toString();
				String str_time2 = time2.toString();
				write.println("{" + str_time1 + "}{" + str_time2 + "}" + text );	
			}
			
		}
				finally{
					read.close();
					write.close();
				}
	}
		
		
}
	
	
