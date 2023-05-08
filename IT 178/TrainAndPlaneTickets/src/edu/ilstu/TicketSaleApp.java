/* 
 * File name: TicketSaleApp.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Mar 2, 2018
 *
 * Class: IT 178
 */

package edu.ilstu;


import java.util.ArrayList;
import java.util.Scanner;

/** 
 * This class runs the program
 *  
 * @author Lauren Kapraun
 *
 */
public class TicketSaleApp{
	private Scanner kb = new Scanner(System.in);
	ArrayList<Ticket> tickets;

	/**
	 * This method initializes the ArrayList tickets
	 * 
	 * Then calls the method getTickets
	 * 
	 * Then calls the method printTickets
	 * 
	 */
	private void run(){
		tickets = new ArrayList<>();
		getTickets();
		printTickets();
	}
	
	/**
	 * This method asks the user if they want a ticket
	 * 
	 * If the user does, it asks which type of ticket they would like
	 * 
	 * This continues to loop until the user types "N"
	 * 
	 */
	private void getTickets() {
		String ticketChoice = " ";
		
		while(!ticketChoice.equalsIgnoreCase("N")) {
			System.out.print("Do you want to buy a train ticket or airplane ticket?"
					+ "\nPlease type y or n: ");
			ticketChoice = kb.nextLine();
			
			if(ticketChoice.equalsIgnoreCase("Y")) {
				System.out.print("\nWould you like a train or airplane ticket? "
						+ "\nPlease type t or p: " );
				ticketChoice = kb.nextLine();
				if(ticketChoice.equalsIgnoreCase("T")) {
					getTrainTicket();
				}
				else if(ticketChoice.equalsIgnoreCase("P")){
					getAirplaneTicket();
				}
				else {
					System.out.println("Invalid Response. Please Run again...");
					ticketChoice = "n";
				}
			}
			
			else if(ticketChoice.equalsIgnoreCase("N")) {
				System.out.println("\nThank you for your interest!");
			}
			
			else {
				System.out.println("Invalid Response.\n");
			}
		}
	}
	
	/**
	 * This method gathers the ticket information added and prints
	 * it to the console.
	 * 
	 */
	private void printTickets() {
		for(Ticket ticket: tickets) {
			ticket.displayTicketInfo();
		}
	}
	
	/**
	 * This method Asks the user to enter their information to
	 * purchase an airplane ticket
	 * 
	 * Then it sets the ticket price based on the user input
	 * 
	 * It then adds all the information to the ArrayList
	 * 
	 */
	private void getAirplaneTicket(){
        System.out.print("\nEnter the first name: ");
        String firstName = kb.nextLine();
        
        System.out.print("Enter the last name: ");
        String lastName = kb.nextLine();
        
        System.out.print("Enter the flight number: ");
        String flightNumber = kb.nextLine();
        
        System.out.print("Enter the seat number: ");
        String seatNumber = kb.nextLine();
        
        System.out.print("Enter the section: ");
        String section = kb.nextLine();
        
        System.out.print("Enter the departure day: ");
        String departureDay = kb.nextLine();
        
        System.out.print("Enter the departure time (in 24 hour time: hhmm): ");
        String departureTime = kb.nextLine();
        
        System.out.print("Enter the departure Airport (BLM, CHI, LAX): ");
        String departureAirport = kb.nextLine();
        
        System.out.print("Enter the arrival day: ");
        String arrivalDay = kb.nextLine();
        
        System.out.print("Enter the arrival time (in 24 hour time: hhmm): ");
        String arrivalTime = kb.nextLine();
        
        System.out.print("Enter the arrival airport (CHI, YVR, CHI): ");
        String arrivalAirport = kb.nextLine();
        
        System.out.println(" ");
        
        AirplaneTicket airplaneTicket = new AirplaneTicket(firstName,lastName,0,
                seatNumber, flightNumber, section, departureDay
                ,departureTime, departureAirport, arrivalDay, arrivalTime, arrivalAirport);
        
        airplaneTicket.setAirplaneTicketPrice();
        
        tickets.add(airplaneTicket);
    }
	
	/**
	 * This method Asks the user to enter their information to
	 * purchase a train ticket
	 * 
	 * Then it sets the ticket price based on the user input
	 * 
	 * It then adds all the information to the ArrayList
	 * 
	 */
	private void getTrainTicket(){
        System.out.print("\nEnter the first name: ");
        String firstName = kb.nextLine();
        
        System.out.print("Enter the last name: ");
        String lastName = kb.nextLine();
        
        System.out.print("Enter the train number: ");
        String trainNumber = kb.nextLine();
        
        System.out.print("Enter the seat number: ");
        String seatNumber = kb.nextLine();
        
        System.out.print("Enter the seat type (Coach, Sleeper): ");
        char ticketType = kb.nextLine().charAt(0);
        
        System.out.print("Enter the departure day (mmddyyyy): ");
        String departureDay = kb.nextLine();
        
        System.out.print("Enter the departure time (in 24 hour time: hhmm): ");
        String departureTime = kb.nextLine();
        
        System.out.print("Enter the departure station: ");
        String departureLocation = kb.nextLine();
        
        System.out.print("Enter the arrival day (mmddyyyy): ");
        String arrivalDay = kb.nextLine();
        
        System.out.print("Enter the arrival time (in 24 hour time: hhmm): ");
        String arrivalTime = kb.nextLine();
        
        System.out.print("Enter the arrival station: ");
        String arrivalLocation = kb.nextLine();
        
        System.out.println(" ");
        

        TrainTicket trainTicket = new TrainTicket(firstName, lastName, ticketType,
                seatNumber, trainNumber, ticketType, departureDay, departureTime,
                departureLocation, arrivalDay, arrivalTime, arrivalLocation);
        
        trainTicket.setTrainTicketPrice();
        
        tickets.add(trainTicket);
    }
	
	/**
	 * This is the main method used to run the program
	 * 
	 */
	public static void main(String[] args){
		TicketSaleApp app = new TicketSaleApp();
		app.run();
	}
	
	
	

}
