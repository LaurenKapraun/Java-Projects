/* File name:  Swimmer.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Feb 7, 2018
 *
 * Class: IT 178
 */

package edu.ilstu;

/**
 * This class has the following instance fields: firstName, lastName, time
 * 
 * There is a constructor that accepts values for all instance fields
 *
 * The following methods are created:
 * Getter methods for all instance fields 
 * getTimeInMilliseconds(): Method that returns the time value as milliseconds
 * toString method that formats the Swimmer Information
 *
 *
 * @author Lauren Kapraun
 *
 */

public class Swimmer
{
	//Instance fields for: firstName, lastName, and time
	private String firstName;
	private String lastName;
	private String time;


	/* Swimmer:
	 * Constructor that accepts the values for all instance fields
	 * 
	 * @param firstName String for swimmer's first name
	 * @param lastName String for swimmer's last name
	 * @param time String for swimmer's time
	 * 
	 */
	public Swimmer(String firstName, String lastName, String time) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.time = time;
	}


	/* getFirstName:
	 * Getter for first name
	 * 
	 * @return firstName
	 * 
	 */
	public String getFirstName(){
		return firstName;
	}


	/* getLastName:
	 * Getter for last name
	 * 
	 * @return lastName
	 * 
	 */
	public String getLastName(){
		return lastName;
	}


	/* getTime:
	 * Getter for time
	 * 
	 * @return time
	 * 
	 */
	public String getTime(){
		return time;
	}


	/* getTimeInMilliseconds:
	 * Method that converts swimmer's time into milliseconds
	 * 
	 * @return milliseconds
	 * 
	 */
	public double getTimeInMilliseconds(){
		double milliseconds;

		//Get Swimmer's time
		String[] tempArray = this.getTime().split(":");
		//Convert to double and calculate time into milliseconds
		milliseconds = Double.parseDouble((tempArray[1]))*1000.0;

		//Return calculated time
		return milliseconds;
	}


	/* toString:
	 * toString that formats the display for Swimmer first name, last name, and time
	 * 
	 * @return firstName
	 * @return lastName
	 * @return time
	 * 
	 */
	@Override
	public String toString()
	{
		return firstName + " " + lastName + ", " + time + "\n";
	}



}
