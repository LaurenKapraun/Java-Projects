/* 
 * File name: Ticket.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Mar 2, 2018
 *
 * Class: IT 178
 */

package edu.ilstu;

/** 
 * This class manages information about different types of transportation tickets.
 * 
 * @author Lauren Kapraun
 *
 */
public abstract class Ticket
{
	private String firstName;
	private String lastName;
	private double ticketPrice;
	private String seatNumber;
	
	/**
	 * Ticket Constructor that takes the values for all instance fields
	 * 
	 * @param firstName		for ticket
	 * @param lastName 		for ticket
	 * @param ticketPrice	Price of the purchased ticket
	 * @param seatNumber		Seat Number on ticket
	 */
	public Ticket(String firstName, String lastName, double ticketPrice, String seatNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ticketPrice = ticketPrice;
		this.seatNumber = seatNumber;
	}

	/**
	 * Getter for ticketPrice
	 * 
	 * @return the ticketPrice
	 */
	public double getTicketPrice(){
		return ticketPrice;
	}

	/**
	 * Setter for ticketPrice
	 * 
	 * @param ticketPrice 
	 */
	public void setTicketPrice(double ticketPrice){
		this.ticketPrice = ticketPrice;
	}

	/**
	 * Getter for seatNumber
	 * 
	 * @return the seatNumber
	 */
	public String getSeatNumber(){
		return seatNumber;
	}

	/**
	 * Setter for seatNumber
	 * 
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(String seatNumber){
		this.seatNumber = seatNumber;
	}

	/**
	 * Getter for firstName
	 * 
	 * @return the firstName
	 */
	public String getFirstName(){
		return firstName;
	}

	/**
	 * Getter for lastName
	 * 
	 * @return the lastName
	 */
	public String getLastName(){
		return lastName;
	}
	
	/**
	 * Abstract Method to display the ticket Information
	 */
	public abstract void displayTicketInfo();
}
