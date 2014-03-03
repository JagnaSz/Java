package dictionary;

/**
 * 
 * @author aga
 *
 */

public class Entry {
	private String word;
	private String clue;
	
	/**
	 * Constructor
	 * 
	 * @param word - word in crossword
	 * @param clue - clue in crossword
	 */
	public Entry(String word, String clue) {
		this.word = word;
		this.clue = clue;
	}

	/**
	 * Getter
	 * 
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Getter
	 * 
	 * @return the clue
	 */
	public String getClue() {
		return clue;
	}

}
