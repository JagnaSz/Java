package Browser;

import Board.Crossword;
import Exceptions.CwCreatingException;

/**
 * 
 * @author aga
 *
 */

public interface Writer {

	public void write(Crossword cw) throws CwCreatingException;;
	public long getUniqueID();
}
