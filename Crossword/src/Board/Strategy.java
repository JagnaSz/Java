package Board;
import Exceptions.CwCreatingException;
import dictionary.*;

/**
 * 
 * @author aga
 *
 */

public abstract class Strategy {

	public abstract CwEntry findEntry(Crossword cw) throws CwCreatingException;
	public abstract void updateBoard(Board b, CwEntry e);
}
