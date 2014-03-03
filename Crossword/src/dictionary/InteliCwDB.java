package dictionary;

import java.util.LinkedList;
import java.util.Random;

import Exceptions.CwCreatingException;

/**
 * 
 * @author aga
 *
 */

public class InteliCwDB extends CwDB {

	/**
	 * Constructor
	 * 
	 * @param filename - file with date
	 * @throws CwCreatingException
	 */
	public InteliCwDB(String filename) throws CwCreatingException {
		super(filename);
	}
	
	/**
	 * Function finds all entries that match the pattern
	 * 
	 * @param pattern - regular expression
	 * @return list of matching entries
	 */
	public LinkedList<Entry> findAll(String pattern) {
		LinkedList<Entry> list = new LinkedList<Entry>();
		
		for(int i=0; i<dict.size(); i++){
			if(dict.get(i).getWord().matches(pattern)) {
				list.add(dict.get(i));
			}
		}
		return list;
	}
	
	/**
	 * Function adds entries in alphabetical order
	 * 
	 * @param word
	 * @param clue
	 */
	public void add(String word, String clue) {
		int i;
		for(i=0; i<dict.size();i++) {
			if(word.compareToIgnoreCase(dict.get(i).getWord()) < 0) {
				break;
			}	
		}
		
		if(!Character.isAlphabetic(word.charAt(0)))
			dict.add(i, new Entry(word.substring(1), clue));	
		else
			dict.add(i ,new Entry(word, clue));	
		
	}
	
	/**
	 * Function gets random entry
	 * 
	 * @return entry 
	 */
	public Entry getRandom() {
		Random generator = new Random();
		
		return dict.get(generator.nextInt(dict.size()));	
	}
	
	/**
	 * Function gets entry with word's length equal to parameter
	 * 
	 * @param length - word's length
	 * @return entry
	 * @throws CwCreatingException 
	 */
	public Entry getRandom(int length) throws CwCreatingException {
		LinkedList<Entry> list = new LinkedList<Entry>();
		Random generator = new Random();
		
		try{
		for(int i=0; i<dict.size();i++) {
			if(dict.get(i).getWord().length() == length) {
				list.add(dict.get(i));
			}
		}
		return list.get(generator.nextInt(list.size()));
		}catch(Exception e){
			throw new CwCreatingException("Plik jest pusty!");
		}
	}
	
	/**
	 * Function gets random entry with word matching pattern
	 * 
	 * @param pattern - regular expression
	 * @return entry 
	 */
	public Entry getRandom(String pattern) {
		LinkedList<Entry> list = new LinkedList<Entry>();
		Random generator = new Random();
	
			for(int i=0; i<dict.size(); i++){
				if(dict.get(i).getWord().matches(pattern)) {
					list.add(dict.get(i));
				}
			}
			if(list.isEmpty()) 
				return null;
			else
				return list.get(generator.nextInt(list.size()));
		
		
	}
}
