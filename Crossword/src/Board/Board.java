package Board;

import java.util.regex.Pattern;


/**
 * 
 * @author aga
 *
 */

public class Board {
	
	private BoardCell[][] board; //cw's board
	private int width;  // board's width
	private int height; // board's height
	
	/**
	 * Constructor
	 * 
	 * @param w - board's width
	 * @param h - board's height
	 */
	public Board(int w, int h) {
		this.width = w;
		this.height = h;
		board = new BoardCell[width][height];
		
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				board[i][j] = new BoardCell("");	
			}
		}
	}
	
	/**
	 * Getter
	 * 
	 * @return width of board
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Getter
	 * 
	 * @return height of board
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Getter
	 * 
	 * @param x - horizontal position
	 * @param y - vertical position
	 * @return cell's content
	 */
	public BoardCell getCell(int x, int y) {
		if(x>=0 && y>=0)
			return board[x][y];
		return null;
	}
	
	/**
	 * Setter
	 * 
	 * @param x - horizontal position 
	 * @param y - vertical position
	 * @param c - value to set
	 */
	public void setCell(int x, int y, BoardCell c) {
		board[x][y] = c;
	}
	
	
	/**
	 * Function creates pattern of word in position fromx, promy, tox, toy
	 * 
	 * @param fromx - beginning for x ax
	 * @param fromy - beginning for y ax
	 * @param tox - end for x ax
	 * @param toy - end for y ax
	 * @return pattern (String)
	 */
	public Pattern createPattern(int fromx, int fromy, int tox, int toy) {
        String pattern = "";
        if (fromx == tox) {
                for (int i = fromy; i < toy; i++) {
                        if (getCell(fromx, i).exists())
                                pattern += getCell(fromx, i).getContent();
                        else
                                pattern += ".";
                }
        } else if (fromy == toy) {
                for (int i = fromx; i < tox; i++) {
                        if (getCell(i, fromy).exists())
                                pattern += getCell(i, fromy).getContent();
                        else
                                pattern += ".";
                }
          }
        return Pattern.compile(pattern);
	}
}
