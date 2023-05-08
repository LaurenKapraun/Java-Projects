/** 
 *  Program Assignment 4
 *  
 *  This application takes pizza orders for a store called ISU.
 *  
 * @author Lauren Kapraun
 * @since 2017-10-21
 * Last Updated: 10/26/17
 *
 */

package edu.ilstu;

/** 
 * This class keeps track of the customer name, address, and phone number
 *
 */
public class Customer
{
	//Declare variables
	private String name;
	private String address;
	private String phoneNumber;
	
	//This method reads the customer data and stores it in the instant variables
	public void readInformation(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	//Getters and setters for the variables
	public String getName(){ return name; }
	public void setName(String name){ this.name = name;}

	
	public String getAddress(){ return address;}
	public void setAddress(String address){ this.address = address; }

	
	public String getPhoneNumber(){ return phoneNumber; }
	public void setPhoneNumber(String phoneNumber){ this.phoneNumber = phoneNumber;}
	
	
	//toString that prints the information for the name, address, and the phone number
	public String toString() {
		return "This is a Delivery order, deliver to " + name
				+ "\nAddress: " + address
				+ "\nPhone number to call incase we got lost " + phoneNumber;
	}
	
}