/* 
 * File name: Filename.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Mar 26, 2018
 *
 * Class: IT 178
 */
package edu.ilstu;

/** 
 * Checks that the user input has a "."
 * 
 * Takes user input to decide file extension
 * 
 * @author Lauren Kapraun
 *
 */

public class Filename
{
	public static final char PERIOD = '.';
	private String fileName;
	
	/**Filename
	 * 
	 * Checks for a period in the user input
	 * 
	 * @param newFileName String
	 * @throws IllegalFilenameException
	 */
	public Filename( String newFileName )
		throws IllegalFilenameException {
			if (newFileName.indexOf( PERIOD ) != -1){
				fileName = newFileName;
			}
			else{
				throw new IllegalFilenameException ("File does not contain " + PERIOD);
			}
	}
	
	/** getFileType
	 * 
	 * Gets user input to decide the application used to open file
	 * 
	 * @return fileType The type of application the file uses
	 */
	public String getFileType( ){
	    String extension = fileName.substring(fileName.length()-3);
	    String fileType = null;
	    
	    if(extension.equalsIgnoreCase("doc") || extension.equalsIgnoreCase("ocx")){
	    	fileType = "MS Word";
	    }
	    else if(extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("lsx")
	    		|| extension.equalsIgnoreCase("csv")){
	    	fileType = "MS Excel";
	    }
	    else if(extension.equalsIgnoreCase("txt")){
	    	fileType = "Notepad";
	    } 
	    
	    return fileType;
	  }
}
