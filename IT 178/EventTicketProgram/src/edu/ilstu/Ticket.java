/* File name:  Ticket.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Jan 25, 2018
 *
 * Class: IT 178
 */
package edu.ilstu;


/**
 * This class represents and stores information about a ticket for an event.
 * 
 * Instance fields include:
 * row, seatNumber, seatPrice, firstName, lastName
 * 
 * Methods include:
 * Ticket: constructor that accepts the values for all instance fields.
 * Getters for all instance variables
 *
 * @author Lauren Kapraun
 *
 */

public class Ticket
{
	//Create private instance fields for: row, seatNumber, seatPrice, firstName, and lastName
	private int row;
	private int seatNumber;
	private double seatPrice;
	private String firstName;
	private String lastName;

	/* Ticket:
	 * constructor that accepts the values for all instance fields
	 * 
	 * @param row
	 * @param seatNumber
	 * @param seatPrice
	 * @param firstName
	 * @param lastName
	 * 
	 */
	public Ticket(int row, int seatNumber, double seatPrice, String firstName, String lastName) {
		this.row = row;
		this.seatNumber = seatNumber;
		this.seatPrice = seatPrice;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/* getRow:
	 * Getter for row
	 * 
	 * @return row
	 * 
	 */
	public int getRow(){
		return row;
	}

	/* getSeatNumber:
	 * Getter for seatNumber
	 * 
	 * @return seatNumber
	 * 
	 */
	public int getSeatNumber(){
		return seatNumber;
	}

	/* getSeatPrice:
	 * Getter for seatPrice
	 * 
	 * @return seatPrice
	 * 
	 */
	public double getSeatPrice(){
		return seatPrice;
	}

	/* getFirstName:
	 * Getter for firstName
	 * 
	 * @return firstName
	 * 
	 */
	public String getFirstName(){
		return firstName;
	}

	/* getLastName:
	 * Getter for lastName
	 * 
	 * @return lastName
	 * 
	 */
	public String getLastName(){
		return lastName;
	}

}
