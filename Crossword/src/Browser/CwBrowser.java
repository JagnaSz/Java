package Browser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import com.itextpdf.text.DocumentException;

import dictionary.CwEntry;
import dictionary.InteliCwDB;
import Board.ConcreteStrategy;
import Board.Crossword;
import Exceptions.CwCreatingException;

/**
 * 
 * @author aga
 *
 */

public class CwBrowser {
	
	private LinkedList<Crossword> list; //list of crosswords
	private CwReader reader; 
	private CwWriter writer;
	private InteliCwDB cwdb;
	private Crossword actual; //actual crossword
	
	/**
	 * Constructor
	 * 
	 * @param cwDBfilePath - path to database
	 * @throws CwCreatingException 
	 */
	public CwBrowser(String cwDBfilePath) throws CwCreatingException{
		list = new LinkedList<Crossword>();
		cwdb = new InteliCwDB(cwDBfilePath);
	}
	
	/**
	 * Setter
	 * 
	 * @param file - file with database
	 * @throws FileNotFoundException
	 */
	public void setCwDB(String file) throws CwCreatingException {
			this.cwdb = new InteliCwDB(file);
	}
	
	/**
	 * Function generates crossword
	 * 
	 * @param width - board's width
	 * @param height - board's height
	 * @throws CwCreatingException 
	 */
	public void generateCw(int width, int height) throws CwCreatingException{
		actual = new Crossword(width, height, cwdb);
		actual.generate(new ConcreteStrategy());
		list.add(actual);
		
	}
	
	/**
	 * Getter
	 * 
	 * @return actual crossword
	 */
	public Crossword getCwActual(){
		return actual;
	}
	
	/**
	 * Function sets as actual next crossword into list
	 */
	public void next(){
		int idx = list.indexOf(actual);
		if(idx < list.size()-1)
			actual = list.get(idx+1);
	}
	
	/**
	 * Function sets as actual previous crossword into list
	 */
	public void prev(){
		int idx = list.indexOf(actual);
		if(idx >0)
			actual = list.get(idx-1);
		
	}
	
	/**
	 * Function saves actual crossword in file
	 * 
	 * @param filepath - directory to save crossword in
	 */
	public void writeActual(String filepath) throws CwCreatingException {
		writer = new CwWriter(filepath);
		writer.write(actual);
	}
	
	/**
	 * Function loads crosswords from given folder
	 * 
	 * @param folderpath
	 * @throws FileNotFoundException
	 */
	public void loadCrosswords(String folderpath) throws CwCreatingException {
		reader = new CwReader(folderpath);
		list.addAll(reader.getAllCws());
		actual = list.getLast();	
	}
	
	/**
	 * Getter
	 * 
	 * @return list of crosswords
	 */
	public LinkedList<Crossword> getList() {
		return list;
	}

}
