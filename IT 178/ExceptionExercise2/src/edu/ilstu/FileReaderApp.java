/* 
 * File name: FileReaderApp.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Mar 28, 2018
 *
 * Class: IT 178
 */

package edu.ilstu;

/** 
 * Builds a Scanner object to read from input file "InputData.txt"
 * 
 * Uses a try-catch block & FileNotFoundException in catch block
 * 
 * Throws FileExceptions when FileNotFoundException is raised and passes the message
 * "Input file InputData.txt not found."
 * 
 * @author Lauren Kapraun
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderApp
{

	public static void main(String[] args) throws FileExceptions 
	{
		Scanner fileIn = null;
		String fileName = "InputData.txt";
		
		try{
			fileIn = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException fnfe){
			throw new FileExceptions("Input file " + fileName + " not found.", fnfe);
		}

	}

}
