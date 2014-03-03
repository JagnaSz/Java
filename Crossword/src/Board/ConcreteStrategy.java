package Board;

import java.util.Random;

import Exceptions.CwCreatingException;
import dictionary.CwEntry;
import dictionary.Entry;
import dictionary.InteliCwDB;


/**
 * 
 * @author aga
 *
 */

public class ConcreteStrategy extends Strategy {
	private String pass = new String(); //cw's password
	private int i = 0;
	
	/**
	 * Function finds entry which can be suitable in crossword
	 * 
	 * @param cw - input crossword
	 * @return crossword's entry
	 * @throws CwCreatingException 
	 */
	public  CwEntry findEntry(Crossword cw) throws CwCreatingException{ 
		CwEntry entry = null;
		Entry temp = null;
		
		try{
			if(pass.isEmpty()) 
				findPass(cw);
			
			if (i < pass.length() && temp == null ){
				temp = cw.getCwDB().getRandom(pass.charAt(i) + ".{1,"+ Integer.toString(cw.getBoardCopy().getWidth()-1) +"}" );	
			}
			
			if(temp != null) {
				entry = new CwEntry(temp.getWord(), temp.getClue(), 0, i);
			}
			else if(i < pass.length() && (cw.getBoardCopy().getCell(1,i).getContent())==""){
				cw.getBoardCopy().getCell(0,i).setContent(pass.substring(0,1));
				entry = new CwEntry(pass.substring(i,i+1), "", 0, i);
			}
					
			i++;
		
		return entry;
		}catch(Exception e) {
			throw new CwCreatingException("Niepoprawny format pliku");
		}
	}
	
	/**
	 * Updates board,inserts entry to board
	 * 
	 * @param b - board to update
	 * @param e - value (word) to insert
	 */
	public  void updateBoard(Board b, CwEntry e){

		for(int i=0; i< e.getWord().length(); i++)	{
			b.getCell(i,e.getY()).setContent(e.getWord().substring(i, i+1));
		}
			
	}

	/**
	 * Function finds password of  crossword
	 * 
	 * @param crossword - input crossword
	 * @throws CwCreatingException 
	 */
	public void findPass(Crossword crossword) throws CwCreatingException {
		pass = crossword.getCwDB().getRandom(crossword.getBoardCopy().getHeight()).getWord();		
	}
}
