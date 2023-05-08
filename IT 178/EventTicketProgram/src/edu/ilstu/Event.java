/* File name:  Event.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Jan 25, 2018
 *
 * Class: IT 178
 */

package edu.ilstu;
/**
 * 
 * This class will keep track of the tickets sold.
 * 
 * The constants in this class include: 
 * SALES_TAX: 7.75%
 * PROCESSING_FEE: $15
 * INSURANCE_FEE: $10
 * 
 * There will be one instance field:
 * 2D array that stores the Ticket objects
 * 
 * The Methods used include:
 * Event(): A default no-arg constructor that creates the 2D array
 * displaySeatMap: Displays a seat map, showing available & taken seats
 * checkAvailability: checks if a seat location is available. Accepts 2 numbers, one for row & one for column.
 * 	It returns a Boolean value: false = sold, true = available
 * ticketsSold: updates the array when a ticket is sold. 
 * getters for all constants
 *
 * @author Lauren Kapraun
 *
 */
public class Event
{
	private final double SALES_TAX = 0.0775;
	private final double PROCESSING_FEE = 15;
	private final double INSURANCE_FEE = 10;
	private Ticket[][] tickets;

	/* Event:
	 * Default no-arg constructor that creates the 2D array
	 * 
	 * 
	 */
	public Event() {
		//create array with 30 rows and 8 columns
		tickets = new Ticket[30][8];
	}


	/* displaySeatMap:
	 * Displays a seat map, showing available & taken seats
	 * Marks [X] on taken seats, marks[ ] on empty seats
	 * 
	 */
	public void displaySeatMap() {
		for(int row = 0; row < tickets.length; row++) {
			//Print row number
			System.out.print(row+1);
			for(int col = 0; col < tickets[0].length; col++) {
				//If seat is purchased mark with X
				if(checkAvailability(row,col) == false){
					System.out.print("\t[X]");
				}
				//else leave blank
				else{
					System.out.print("\t[ ]");
				}
			}
			//Start new line
			System.out.println(" ");
		}
	}

	
	/* checkAvailability:
	 * Checks if a seat location is available. Accepts 2 numbers, one for row & one for column.
	 * It returns a Boolean value: false = sold, true = available
	 * 
	 * @param row integer
	 * @param col integer
	 * 
	 * @return true if tickets does not equal null
	 * @return false if tickets[row][col] equals null
	 * 
	 */
	public boolean checkAvailability(int row, int col) {
		//if seat does not = null, seat is sold
		if(tickets[row][col]!= null){
			return false;
		}
		//else seat is available
		else{
			return true;
		}
	}

	/* ticketsSold:
	 * updates the array when a ticket is sold
	 * set tickets[tic row] [ tic seatNumber ] to tic 
	 * 
	 * @param tic Ticket
	 * 
	 */
	public void ticketsSold(Ticket tic) {
		//Update seat map
		tickets[tic.getRow()][tic.getSeatNumber()] = tic;
	}

	/* getTickets:
	 * Getter for tickets
	 * 
	 * @return tickets 
	 * 
	 */
	public Ticket[][] getTickets(){
		return tickets;
	}


	/* getSALES_TAX:
	 * Getter for sales tax
	 * 
	 * @return SALES_TAX
	 * 
	 */
	public double getSALES_TAX(){
		return SALES_TAX;
	}


	/* getPROCESSING_FEE:
	 * Getter for processing fee
	 * 
	 * @return PROCESSING_FEE
	 * 
	 */
	public double getPROCESSING_FEE(){
		return PROCESSING_FEE;
	}


	/* getINSURANCE_FEE:
	 * Getter for insurance fee
	 * 
	 * @return INSURANCE_FEE
	 * 
	 */
	public double getINSURANCE_FEE(){
		return INSURANCE_FEE;
	}
}
