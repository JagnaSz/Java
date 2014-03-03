package Browser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import dictionary.CwEntry;
import Board.Crossword;
import Exceptions.CwCreatingException;

/**
 * 
 * @author aga
 *
 */

public class CwWriter implements Writer {

	private File file; //directory
	
	/**
	 * Constructor 
	 * 
	 * @param filepath - path to destination folder
	 */
	public CwWriter(String filepath) {
		file = new File(filepath);
		file.mkdirs();
	} 
	
	/**
	 * Function saves crossword in file
	 * 
	 * @param cw - crossword which must be saved
	 * @throws CwCreatingException 
	 * 
	 */
	public void write(Crossword cw) throws CwCreatingException {
		Long ID = getUniqueID();
		FileWriter CwFile = null;
		try {
			 if(cw == null)
					throw new CwCreatingException("Krzyzówka jest pusta!");
			 
			CwFile = new FileWriter(file.getAbsolutePath() + "/" + ID.toString());
			CwFile.write(cw.getBoardCopy().getWidth() + " " + cw.getBoardCopy().getHeight() + "\n");
		
					
					for(CwEntry e: cw.getEntries()){
						CwFile.write(e.getX() + " " + e.getY() + "\n");
						CwFile.write(e.getWord() + "\n");
		                CwFile.write(e.getClue() + "\n");
					}
			
		} catch (IOException e) {
			throw new CwCreatingException("Nie mo¿na zapisaæ pliku!");
		}finally{
				if(CwFile != null)
					try {
						CwFile.close();
					} catch (IOException e) {
						throw new CwCreatingException("Nie mo¿na zapisaæ pliku");
					}
		}
	}

	/**
	 * Getter
	 * 
	 * @return unique ID for saving crosswords
	 */
	public long getUniqueID() {
		return new Long(new Date().getTime());
	}

}
