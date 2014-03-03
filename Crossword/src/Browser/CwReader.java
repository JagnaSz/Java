package Browser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import Board.Crossword;
import Exceptions.CwCreatingException;

/**
 * 
 * @author aga
 *
 */

public class CwReader implements Reader {

	private File file; //folder
	
	/**
	 * Constructor 
	 * 
	 * @param filepath - folder with crosswords
	 */
	public CwReader(String filepath) {
		file = new File(filepath);
		file.mkdirs();
	}
	
	/**
	 * Function loads all crosswords into one database
	 * @throws CwCreatingException 
	 * 
	 */
	public LinkedList<Crossword> getAllCws() throws CwCreatingException {
		LinkedList<Crossword> list = new LinkedList<Crossword>();
		
			for(File f: file.listFiles())
				try {
					list.add(new Crossword(Long.parseLong(f.getName()), f));
				} catch (NumberFormatException e) {
					throw new CwCreatingException("Niepoprawny format plików wejœciowych!");
				} catch (FileNotFoundException e) {
					throw new CwCreatingException("Nie mo¿na otworzyæ plików");
				}
		return list;
	}

}
