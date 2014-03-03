package Board;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import Exceptions.CwCreatingException;
import dictionary.CwDB;
import dictionary.CwEntry;
import dictionary.InteliCwDB;

/**
 * 
 * @author aga
 *
 */

public class Crossword {
	private LinkedList<CwEntry> entries;  //list of entries in crossword
	private Board b;  //cw's board
	private InteliCwDB cwdb; //cw's intelligent database
	private long ID;
	private File file;  //file to load and read cw
	
	
	/**
	 * Constructor
	 * 
	 * @param width - width of board
	 * @param height - height of board
	 * @param cwDB - database
	 */
	public Crossword(int width, int height, InteliCwDB cwDB) {
        entries = new LinkedList<CwEntry>();
        b = new Board(width, height);
        setCwDB(cwDB);
        ID=-1;
	}
	
	/**
	 * Constructor - loads crosswords from file
	 * 
	 * @param ID - name of file
	 * @param file - file with cw
	 * @throws FileNotFoundException
	 */
	public Crossword(final Long ID, File file) throws FileNotFoundException {
	
		if(entries == null)
			entries = new LinkedList<CwEntry>();
		
		file = new File(file.getAbsolutePath());
		Scanner in = new Scanner(file) ;
		String linia;
		String [] wym;
		
		linia = in.nextLine();
		wym = linia.split(" ");
		int w = Integer.parseInt(wym[0]);
		int h = Integer.parseInt(wym[1]);
		
		b = new Board(w, h);
		//System.out.println(b.getWidth() + " " + b.getHeight());
		while(in.hasNextLine()){
			linia = in.nextLine();
			String[] wspl = linia.split(" ");
			int x = Integer.parseInt(wspl[0]);
			int y = Integer.parseInt(wspl[1]);
			String word = in.nextLine();
			String clue = in.nextLine();
			
			addCwEntry(new CwEntry(word,clue, x,y),new ConcreteStrategy());
			//System.out.println(x +" "+ y + word + " " +clue);
		}
		this.ID = ID;
		this.file = file;
	
		in.close();	
	}
	
	/**
	 * Getter
	 * 
	 * @return ID
	 */
	public long getID() {
		return this.ID;
	}
	
	/**
	 * Getter
	 * 
	 * @return list of entries
	 */
	public LinkedList<CwEntry> getEntries() {
		return entries;
	}
	
	/**
	 * Getter
	 * 
	 * @return read-only iterator
	 */
	public Iterator<CwEntry> getROEntryIter() {
		 return Collections.unmodifiableList(getEntries()).iterator();
	}
	
	/**
	 * Getter
	 * 
	 * @return the board
	 */
	public Board getBoardCopy() {
		return b;
	}
	
	/**
	 * Getter
	 * 
	 * @return database
	 */
	public InteliCwDB getCwDB() {
		return cwdb;
	}
	
	/**
	 * Setter
	 * 
	 * @param cwdb - database
	 */
	public void setCwDB(InteliCwDB cwdb){
		this.cwdb = cwdb;
	}
	
	/**
	 * Function checks if crossword contains given word
	 * 
	 * @param word - word to find
	 * @return true if function find this word
	 */
	public boolean contains(String word) {
		ListIterator<CwEntry> it = getEntries().listIterator();
        while (it.hasNext()) {
                CwEntry temp = it.next();
                if (temp.getWord().equals(word))
                        return true;
        }
        return false;
	}
	
	/**
     * Function adds crossword entry to list of entries and updates board
     *
     * @param cwe - entry
     * @param s - strategy
     */
	public final void addCwEntry(CwEntry cwe, Strategy s){
		  entries.add(cwe);
		  s.updateBoard(b,cwe);
		}
	
	/**
     * Function generates crossword
     *
     * @param s - strategy 
	 * @throws CwCreatingException 
     * 
     */
	public final void generate(Strategy s) throws CwCreatingException{
		  CwEntry e = null;
		  while((e = s.findEntry(this)) != null){
		    addCwEntry(e,s);
		  }
		}
	
	/**
     * Function prints all entries 
     *
     */
	public void PrintAllEntries() {
		for(int i=0; i<b.getHeight(); i++) {
			for(int j=0; j< b.getWidth(); j++) {
				System.out.print(b.getCell(j,i).getContent() + " ");
			}
			System.out.println();
		
		}
	}

	
}
