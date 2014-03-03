package Board;


/**
 * @author aga
 * 
 */

public class BoardCell {
	
	private String content;  //content of cell 
	
	/**
	 * Constructor 
	 * 
	 * @param c - content of cell
	 */
	public BoardCell(String c) {
		this.content = c;
	}
	
	/**
	 * Getter
	 * 
	 * @return the content of cell
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter
	 * 
	 * @param content - the content of cell
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Check if there is any content in cell
	 * 
	 * @return true if cell has non zero-length content
	 */
	public boolean exists() {
		if(content.length() >0) 
			return true;
		else
			return false;
	}
	
}
