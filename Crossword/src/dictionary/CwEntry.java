package dictionary;


/**
 * 
 * @author aga
 *
 */

public class CwEntry extends Entry {
	

	private int x;  // position in horizontal ax
	private int y;  // position in vertical ax
	
	/**
	 * Constructor
	 * 
	 * @param word - word in crossword
	 * @param clue - clue in crossword
	 * @param x  - level in horizontal ax
	 * @param y - level in vertical ax
	 */
	public CwEntry(String word, String clue, int x, int y) {
		super(word, clue);
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Getter
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
}
