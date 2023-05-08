/* 
 * File name: IllegalFilenameException.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Mar 26, 2018
 *
 * Class: IT 178
 */

package edu.ilstu;

/** 
 * This class calls for the Illegal Filename Exception.
 * 
 * This class extends the IllegalArgumentException
 * 
 * @author Lauren Kapraun
 *
 */

public class IllegalFilenameException extends IllegalArgumentException
{
	/** IllegalFilenameException
	 * 
	 * Calls to super
	 * 
	 * @param message String
	 */
	public IllegalFilenameException(String message ) {
	    super( message );
	 }
}
