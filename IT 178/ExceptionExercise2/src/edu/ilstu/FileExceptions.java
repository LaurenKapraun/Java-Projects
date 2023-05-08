/* 
 * File name: FileExceptions.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Mar 28, 2018
 *
 * Class: IT 178
 */

package edu.ilstu;

/** 
 * Creates an instance field to store a custom message
 * 
 * Constructor that accepts customMessage & assigns the customMessage
 * to the instance field
 * 
 * Constructor that accepts customMessage, & a reference to the super class
 * of Exceptions class. Assigns the custom message to the instance field.
 * 
 * Override the getMessage() method from the super class and build a new value
 * to display when the method is called
 * 
 * @author Lauren Kapraun
 *
 */

public class FileExceptions extends Exception
{
	String customMessage;
	
	/**FileExceptions
	 * 
	 * Constructor that accepts customMessage & assigns the customMessage
	 * to the instance field
	 * 
	 * @param customMessage
	 */
	public FileExceptions(String customMessage){
		super(customMessage);
		this.customMessage = customMessage;
	}
	
	/**FileExceptions
	 * 
	 * Constructor that accepts customMessage, & a reference to the super class
	 * of Exceptions class. Assigns the custom message to the instance field.
	 * 
	 * @param customMessage
	 * @param cause
	 */
	public FileExceptions(String customMessage, Throwable cause){
		super(customMessage, cause);
		this.customMessage = customMessage;
	}
	
	/**getMessage
	 * 
	 * Override the getMessage() method from the super class and build a new value
	 * to display when the method is called
	 * 
	 */
	@Override
	public String getMessage(){
		String finalMessage = customMessage;
		finalMessage += "\n\nFile is not in this location ";
		finalMessage += System.getenv("TEMP");
		return finalMessage;
	}
}
