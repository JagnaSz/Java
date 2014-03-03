package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

import Exceptions.CwCreatingException;

/**
 * 
 * @author aga
 *
 */

public class CwDB{

	private File file;  // file 
	protected LinkedList<Entry> dict; // list of entries - dictionary
	
	/**
	 * Function adds new record (word + clue)
	 * 
	 * @param word
	 * @param clue
	 */
	public void add(String word, String clue) {
		if(!Character.isAlphabetic(word.charAt(0))) {
			dict.add(new Entry(word.substring(1), clue));
		}
		else
			dict.add(new Entry(word, clue));
	}
	
	/**
	 * Constructor
	 * 
	 * @param filename - name of file with date
	 * @throws FileNotFoundException
	 */
	public CwDB(String filename) throws CwCreatingException {
		dict = new LinkedList<Entry>();
		createDb(filename);
	}
	
	/**
     * Creates database from file
     *
     * @param filename - file name
     * @throws CwCreatingException 
     */
	protected void createDb(String filename) throws CwCreatingException {
		file = new File(filename);
		Scanner in = null;
		try{
			in = new Scanner(file, "UTF-8");
		
			while(in.hasNextLine()) {
				add(in.nextLine(), in.nextLine());	
			}
		}catch(FileNotFoundException e1){
			throw new CwCreatingException("Nie ma takiego pliku!");
		}finally{
			if(in != null)
				in.close();
		}
	}
	
	/**
     * Getter
     *
     * @param word - parameter to identify entry
     * @return entry in dictionary with field word, null if no entry have this word
     */
	public Entry get(String word) {
		for(int i=0; i < dict.size(); i++) {
			if(dict.get(i).getWord().equals(word)) {
				return dict.get(i);
			}
		}
	return null;
	}
	
	/**
     * Removes specified entry from dictionary
     *
     * @param word - parameter to identify entry
     */
	public void remove(String word) {
		for(int i=0; i < dict.size(); i++){
			if(dict.get(i).getWord().equals(word)) {
				dict.remove(i);
			}
			else System.out.println("Don't find this word");
		}
	}
	
	 /**
     * Saves database in file
     *
     * @param filename - name of output file
     * @throws IOException
     */
	public void saveDB(String filename) throws IOException {
		PrintWriter out = new PrintWriter(filename, "UTF-8");
		
		for(Entry elem : dict) {
			out.println(elem.getWord());
			out.println(elem.getClue());	
		}
		
		out.close(); 
	}
	
	/**
     * Getter
     *
     * @return size of dictionary (number of elements)
     */
	public int getSize() {
		return dict.size();
	}
	

}
