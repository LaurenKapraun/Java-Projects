/* 
 * File name: TrainTicket.java
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
 * This class manages the information about train tickets.
 * 
 * @author Lauren Kapraun
 *
 */
public class TrainTicket extends Ticket
{

	private String trainNumber;
	private char ticketType;
	private String departureDay;
	private String departureTime;
	private String departureLocation;
	private String arrivalDay;
	private String arrivalTime;
	private String arrivalLocation;
	
	/**
	 * Default Constructor that takes values for instance fields in 
	 * this class and the super class
	 * 
	 * @param firstName			for ticket
	 * @param lastName			for ticket
	 * @param ticketPrice		price of ticket
	 * @param seatNumber			users seat number
	 * @param trainNumber		train identifier
	 * @param ticketType			business and sleeper types
	 * @param departureDay		day of departure
	 * @param departureTime		time of departure
	 * @param departureLocation	departure location
	 * @param arrivalDay			day of arrival
	 * @param arrivalTime		time of departure
	 * @param arrivalLocation	arrival location
	 */
	public TrainTicket(String firstName, String lastName, double ticketPrice,
			String seatNumber, String trainNumber, char ticketType, String departureDay,
			String departureTime, String departureLocation, String arrivalDay,
			String arrivalTime, String arrivalLocation){
		super(firstName, lastName, ticketPrice, seatNumber);
		this.trainNumber = trainNumber;
		this.ticketType = ticketType;
		this.departureDay = departureDay;
		this.departureTime = departureTime;
		this.departureLocation = departureLocation;
		this.arrivalDay = arrivalDay;
		this.arrivalTime = arrivalTime;
		this.arrivalLocation = arrivalLocation;
	}
	
	/**
	 * Method to retrieve the price of the train ticket from the
	 * TrainDeals class by passing the ticketType
	 * 
	 */
	public void setTrainTicketPrice() {
		super.setTicketPrice(TrainDeals.getTicketPrice(ticketType));
	}

	/* (non-Javadoc)
	 * @see edu.ilstu.Ticket#displayTicketInfo()
	 */
	@Override
	public void displayTicketInfo()
	{
		String ticketType;
		if(this.ticketType == 'c' || this.ticketType == 'C') {
			ticketType = "Coach";
		}
		else {
			ticketType = "Sleeper";
		}
			
		System.out.println("\n" + getLastName() + "," + getFirstName()
				+ "\nTrain number: " + trainNumber
				+ "\nSeat: " + getSeatNumber() + "\t\tType: " + ticketType + "\t\tPrice: " + formatPrice(getTicketPrice())
				+ "\n\nDeparture: "
				+ "\nStation: " + departureLocation + "\tDate: " + formatDate(departureDay) + "\tTime: " + formatTime(departureTime)
				+ "\n\nArrival: "
				+ "\nStation: " + arrivalLocation + "\tDate: " + formatDate(arrivalDay) + "\tTime: " + formatTime(arrivalTime));
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
