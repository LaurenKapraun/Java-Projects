/*
 *  Programmer:  Tonya Pierce
 *
 *  Date:  October 15, 2017
 *
 *  File name:  DateFormatter.java
 *
 *  Class:  IT 168
 *  Section:
 *  Instructor:  
 */
package edu.ilstu;

/**
 * Converts date form
 *
 * @author tspier1
 *
 */
public class DateFormatter
{

	public static String formatToWord (String numberDate)
	{
		String[] splitDate = numberDate.split("/");
		
		int monthNumber = Integer.parseInt(splitDate[0]); 
		
		String monthWord = determineMonth(monthNumber);
		
		return monthWord + " " + splitDate[1] + ", " + splitDate[2];
		
	}
	
	private static String determineMonth(int monthNumber)
	{
		String[] monthList = {"", "January", "February", "March",
				"April", "May", "June", "July", "August",
				"September", "October", "November", "December"};
		
		String monthWord = monthList[monthNumber];
		
		return monthWord;
	}
	
	
	
}
