/* 
 * File name: AirplaneTicket.java
 * 
 * Programmer:  Lauren Kapraun
 * 
 * Date:  Mar 2, 2018
 *
 * Class: IT 178
 */

package edu.ilstu;

/** 
 * This class is a subclass of the Ticket Class
 * 
 * This class manages the information about airplane tickets.
 * 
 * @author Lauren Kapraun
 *
 */
public class AirplaneTicket extends Ticket
{	
	private String flightNumber;
	private String flightSection;
	private String departureDay;
	private String departureTime;
	private String departureAirport;
	private String arrivalDay;
	private String arrivalTime;
	private String arrivalAirport;
	
	
	/**
	 * Default Constructor that takes values for instance fields in 
	 * this class and the super class
	 * 
	 * @param firstName
	 * @param lastName
	 * @param ticketPrice
	 * @param seatNumber
	 * @param flightNumber
	 * @param flightSection
	 * @param departureDay
	 * @param departureTime
	 * @param departureAirport
	 * @param arrivalDay
	 * @param arrivalTime
	 * @param arrivalAirport
	 */
	public AirplaneTicket(String firstName, String lastName, double ticketPrice,
			String seatNumber, String flightNumber, String flightSection, String departureDay,
			String departureTime, String departureAirport, String arrivalDay,
			String arrivalTime, String arrivalAirport){
		super(firstName, lastName, ticketPrice, seatNumber);
		this.flightNumber = flightNumber;
		this.flightSection = flightSection;
		this.departureDay = departureDay;
		this.departureTime = departureTime;
		this.departureAirport = departureAirport;
		this.arrivalDay = arrivalDay;
		this.arrivalTime = arrivalTime;
		this.arrivalAirport = arrivalAirport;
	}
	
	/**
	 * Method to retrieve the price of the airplane ticket from the
	 * AirplaneDeals class by passing the airport of origin and destination airport
	 * 
	 */
	public void setAirplaneTicketPrice(){
		super.setTicketPrice(AirplaneDeals.getTicketPrice(departureAirport, arrivalAirport));
	}
	
	
	/* (non-Javadoc)
	 * @see edu.ilstu.Ticket#displayTicketInfo()
	 */
	@Override
	public void displayTicketInfo()
	{
		System.out.println("\n" + getLastName() + "," + getFirstName()
			+ "\nFlight number: " + flightNumber
			+ "\nSeat: " + getSeatNumber() + "\t\tTotal cost: " + formatPrice(getTicketPrice())
			+ "\n\nDeparture: "
			+ "\nAirport: " + departureAirport + "\tDate: " + formatDate(departureDay) + "\tTime: " + formatTime(departureTime)
			+ "\n\nArrival: "
			+ "\nAirport: " + arrivalAirport + "\tDate: " + formatDate(arrivalDay) + "\tTime: " + formatTime(arrivalTime));
	}
	
	/**
	 * Helper Function to format Date MM/dd/yyyy
	 * 
	 * @return date.substring(0,2) + "/" + date.substring(2,4) + "/" + date.substring(4) + "\t"
	 */
	private String formatDate(String date) {
	    return date.substring(0,2) + "/" + date.substring(2,4) + "/" + date.substring(4) + "\t";
	}
	
	/**
	 * Helper Function to format Time and determine am/pm
	 * 
	 * @return time.substring(0,2) + ":" + time.substring(2) + hour
	 */
	private String formatTime(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        String hourLabel;
        
        if(Integer.parseInt(time.substring(0,2)) <= 12){
            hourLabel = "am";
        }
        else{
            hour = hour%12;
            if (hour == 0) hour = 12;
            hourLabel = "pm";
        }
        
        return hour + ":" + time.substring(2) + hourLabel;
    }
	
	/**
	 * Helper Function to format price
	 * 
	 * @return String.format("$%.2f", price)
	 */
	private String formatPrice(double price) {
        return String.format("$%.2f", price); 
    }
	
}
