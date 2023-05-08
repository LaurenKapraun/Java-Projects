/* File name:  EventSaleApplication.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Jan 25, 2018
 *
 * Class: IT 178
 */
package edu.ilstu;

import java.util.Scanner;

/**
 * This class manages the ticket sales for an event.
 * 
 * It will:
 * Display the seating map1Y
 * Ask user if they would like to buy a ticket
 * 	If no, thank them for checking out the event
 * 	If yes, ask user for row & column for seat - check if seat is available
 * Display output once the seating map has been updated with ticket sold
 * Continue program until the user enters 'N'
 *
 * @author Lauren Kapraun
 *
 */
public class EventSaleApplication
{
	public static void main(String[] args)
	{
		//Create Scanner
		Scanner kb = new Scanner(System.in);
		
		//Create Event
		Event eventOne = new Event();
		
		//Display Seat Map
		eventOne.displaySeatMap();
		
		//Ask User if they would like to purchase a ticket
		System.out.print("\nWould you like to buy a Ticket? Y or N ");
		String purchaseTicket = kb.nextLine();
		
		//Start Loop for purchasing a ticket
		boolean flag = true;
		while(flag == true){
			//If user does not wish to purchase ticket, thank them for visiting
			if(purchaseTicket.substring(0,1).equalsIgnoreCase("N")){
				System.out.println("Thank you for checking out our event.");
				System.exit(-1);
			}
			//else ask them for row, seat number, name, and insurance
			else{
				int row, seatNumber;
				
				//Call helper to store seat information
				int[] temp = helper(eventOne,kb);
				row = temp[0]-1;
				seatNumber = temp[1]-1;
				
				//Ask user for first and last name, and if they would like insurance
				System.out.println("Please enter your first name:");
				String firstName = kb.nextLine();
				System.out.println("Please enter your last name:");
				String lastName = kb.nextLine();
				System.out.println("Would you like insurance? Y or N");
				String insurance = kb.nextLine();
				
				//Start price calculation
				double price = 0;
				
				//If user wants insurance: 
				if(insurance.substring(0,1).equalsIgnoreCase("Y")){
					if(row >=0 && row <=2 ){
						price = 189 + eventOne.getPROCESSING_FEE() + eventOne.getINSURANCE_FEE(); 
						price = price + (price * eventOne.getSALES_TAX());
					}
					else if(row >=3 && row <= 9){
						price = 169 + eventOne.getPROCESSING_FEE() + eventOne.getINSURANCE_FEE(); 
						price = price + (price * eventOne.getSALES_TAX());
					}
					else if(row >=10 && row <= 19){
						price = 99 + eventOne.getPROCESSING_FEE() + eventOne.getINSURANCE_FEE(); 
						price = price + (price * eventOne.getSALES_TAX());
					}
					else if(row >=20 && row <= 29){
						price = 79 + eventOne.getPROCESSING_FEE() + eventOne.getINSURANCE_FEE(); 
						price = price + (price * eventOne.getSALES_TAX());
					}
				}
				//else if they do not want insurance: 
				else{
					if(row >=0 && row <=2 ){
						price = 189 + eventOne.getPROCESSING_FEE(); 
						price = price + (price * eventOne.getSALES_TAX());
					}
					else if(row >=3 && row <= 9){
						price = 169 + eventOne.getPROCESSING_FEE(); 
						price = price + (price * eventOne.getSALES_TAX());
					}
					else if(row >=10 && row <= 19){
						price = 99 + eventOne.getPROCESSING_FEE(); 
						price = price + (price * eventOne.getSALES_TAX());
					}
					else if(row >=20 && row <= 29){
						price = 79 + eventOne.getPROCESSING_FEE(); 
						price = price + (price * eventOne.getSALES_TAX());
					}
				}
				
				//Create new Ticket
				Ticket tic = new Ticket(row,seatNumber,price,firstName,lastName);
				eventOne.ticketsSold(tic);
				
				//Display updated seating map
				System.out.println("The seating map after the purchase: ");
				eventOne.displaySeatMap();

				//Display purchase information
				System.out.println(lastName + ", " + firstName
						+ "\nRow: " + (row+1) + "\tSeat: " + (seatNumber+1));
				if(insurance.substring(0,1).equalsIgnoreCase("Y")){
					System.out.println("Insurance: $10");
				}
				else{
					System.out.println("Insurance: $0");
				}
				System.out.println("Total Cost: " + price);
			}
			
			//Ask user if they would like to make another purchase
			System.out.println("Please enter 'N' to close this program,if you would like to purchase another ticket , please enter 'Y'");
			purchaseTicket = kb.nextLine();
			
			if(purchaseTicket.substring(0, 1).equalsIgnoreCase("Y")){}
			else if(purchaseTicket.substring(0, 1).equalsIgnoreCase("N")){
				flag = false;
				System.out.println("Thank you for checking out our event.");
			}
		}
		kb.close();
	}
	
	/* helper:
	 * Goes through the event to determine if the seat is available
	 * Loop runs until the user chooses an available seat 
	 *
	 * @param eventOne Event
	 * @param kb Scanner Element
	 * 
	 * @return array of int row and seatNumber
	 */
	public static int[] helper(Event eventOne,Scanner kb){
		//Create new Array of int
		int[] temp = new int[2];
		
		int row , seatNumber;
		boolean ticketBought = false;
		
		//while Seats are unavailable 
		while(ticketBought == false){
			System.out.println("Please enter the row:");
			//input for row
			row = kb.nextInt();
			
			System.out.println("Please enter the Seat Number:");
			//input for Seat Number
			seatNumber = kb.nextInt();
			
			//after nextInt() , have to finish the line off
			kb.nextLine();
			
			//if available stop loop and assign the values to the temp array
			if(eventOne.checkAvailability(row-1,seatNumber-1)){
				ticketBought = true;
				temp[0] = row;
				temp[1] = seatNumber;
			}
			else{
				System.out.println("I'm sorry that seat is taken , please choose another one");    
			}
		}
		return temp;
	}
}
