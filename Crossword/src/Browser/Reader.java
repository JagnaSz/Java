package Browser;

import java.util.LinkedList;

import Board.Crossword;
import Exceptions.CwCreatingException;

/**
 * 
 * @author aga
 *
 */

public interface Reader {

	 public LinkedList<Crossword> getAllCws() throws CwCreatingException;
}
