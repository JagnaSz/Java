package myMain;

import java.io.FileNotFoundException;

import mypkg.BadFormatException;
import mypkg.Subtitle;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, BadFormatException {
	
		try {
			Subtitle.delay("C:/Users/aga/workspace/lab5cw3/src/mypkg/in.txt", "C:/Users/aga/workspace/lab5cw3/src/mypkg/out.txt", 140, 50);
		}
		catch (BadFormatException e) {
			e.printStackTrace();
		
		}
	}

}
