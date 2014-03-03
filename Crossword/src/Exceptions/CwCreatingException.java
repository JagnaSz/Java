package Exceptions;

/**
 * 
 * @author aga
 *
 */

public class CwCreatingException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public CwCreatingException(){}
	
	/**
	 * Constructor
	 * 
	 * @param message - info about error
	 */
	public CwCreatingException(String message) {
		super(message);
	}
	
}
