package edu.ilstu;

/** 
 * This class holds all of the information about a reservation for one person.
 * 
 * It will include the passenger’s name (one variable to hold first and last names), 
 * reservation number, departure route and return route (the routes are objects of the Route class). 
 
 * @author Lauren Kapraun
 *
 */
public class Reservation
{
	//Declare variables
	private String passengerName;
	private String reservationNumber;
	private Route departureRoute;
	private Route arrivalRoute;

	//Default Constructor
	public Reservation() { }
	
	//Reservation Constructor that accepts values for all instance variables
	public Reservation(String passengerName, String reservationNumber, Route departureRoute, Route arrivalRoute){
		this.passengerName = passengerName;
		this.reservationNumber = reservationNumber;
		this.departureRoute = departureRoute;
		this.arrivalRoute = arrivalRoute;
	}
	
	//Getters & Setters
	public String getPassengerName(){return passengerName;}
	public void setPassengerName(String passengerName){this.passengerName = passengerName;}

	public String getReservationNumber(){return reservationNumber;}
	public void setReservationNumber(String reservationNumber){this.reservationNumber = reservationNumber;}
	
	public Route getDepatureRoute() { return departureRoute;}
	public void setDepatureRoute(Route depatureRoute) {this.departureRoute = depatureRoute;}
	
	public Route getArrivalRoute() {return arrivalRoute;}
	public void setArrivalRoute(Route arrivalRoute) {this.arrivalRoute = arrivalRoute;}

	//toString to print out information
	@Override
	public String toString()
	{
	    String s = String.format("%-20s%-20s%n", "Passenger Name", "Reservation Number");
		s = s + String.format("%-20s%-20s%n", passengerName, reservationNumber);
		s = s + "Depature Route\n" + departureRoute.toString() + "\n";
		s = s + "Arrival Route\n" + arrivalRoute.toString();
		return s;
	}

	//Reservations are considered equal when they have the same reservation number
	@Override
	public boolean equals(Object o)
	{
	    //if the Object passed in is not of type Reservation then it cant be equal
        if (!(o instanceof Reservation))
            return false;
            
        //otherwise we need to cast Object to Reservation
        Reservation other = (Reservation)o;
        
        if (this.reservationNumber.equals(other.reservationNumber))
            return true;
        else
            return false;
	}
}

	
	
