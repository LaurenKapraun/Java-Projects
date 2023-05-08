/* 
 * File name: FilenameTester.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Mar 26, 2018
 *
 * Class: IT 178
 */
package edu.ilstu;

/** 
 * Driver class for Filename.java & IllegalFilenameException.java
 * 
 * Ask user to input file name and extension
 * 
 * @author Lauren Kapraun
 *
 */

import java.util.Scanner;

public class FilenameTester
{
	/** main
	 * 
	 * @param args String[]
	 */
	public static void main( String [] args ) {
	    Scanner scan = new Scanner( System.in );
	    System.out.print( "Enter File Name " );
	    String fileName = scan.next( );
	    try
	    {
	      Filename file = new Filename( fileName );
	      System.out.println( "Your file uses the " + file.getFileType( ) + " application." );
	    }
	    catch (IllegalFilenameException iee )
	    {
	      System.out.println( iee.getMessage( ) );
	    }
	  }
}
