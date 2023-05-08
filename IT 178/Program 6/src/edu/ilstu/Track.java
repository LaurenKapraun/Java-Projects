package edu.ilstu;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/** 
 * This class is responsible for holding the array of reservations and all of the methods to process the transactions.
 
 * @author Lauren Kapraun
 *
 */
public class Track
{
	//Create Array
    private Reservation[] reservations;
    private int numReservations;  
    private final int MAX_RESERVATIONS = 40;
    private String name;
    
    
	//Default Constructor
	public Track() { 
		this.reservations = new Reservation[MAX_RESERVATIONS]; 
	}
	
	//Constructor that accepts 1 String argument - the name of the Track
	public Track(String name) {
		this.name = name;
	    this.numReservations = 0;
	}
	
	//Getter & Setter
	public String getName(){return name;}
	public void setName(String name){this.name = name;}
	
	//Add a Reservation
	public void addReservation(Reservation r) {
		reservations[numReservations] = r;
		numReservations++;
	}
	
	//Print out One Passenger
	public void printItinerary(String reservationNumber) {
		boolean reservationExists = false;
		
		for (int i=0; i<numReservations; i++) {
		    Reservation res = reservations[i];
		    if (res.getReservationNumber().equals(reservationNumber)) {
		        System.out.println(res.toString());
		        reservationExists = true;
		    }
		}
		
		if (!reservationExists)
		    System.out.println(reservationExists + " is not a valid reservation number.");
	}

	//Print out All Itineraries
	public void printAllItineraries() {
        for (int i=0; i<numReservations; i++) {
		    Reservation res = reservations[i];
		    System.out.println(res.toString());
		    System.out.println();
		}
	}

	//Write To File
	public void writeToFile() {
		try {
			PrintWriter pw = new PrintWriter("LKK-UpdatedData.txt");
			for (int i=0; i<numReservations; i++) {
	    		    Reservation res = reservations[i];
	    		    pw.println(res.getPassengerName());
	    		    pw.println(res.getReservationNumber());
	    		    pw.println(res.getDepatureRoute().getRouteNumber());
	    		    pw.println(res.getDepatureRoute().getRouteDate());
	    		    pw.println(res.getDepatureRoute().getDepartureTrack().getName());
	    		    pw.println(res.getDepatureRoute().getArrivalTrack().getName());
	    		    pw.println(res.getDepatureRoute().getDepatureTime());
	    		    pw.println(res.getDepatureRoute().getArrivalTime());
	    		    pw.println(res.getDepatureRoute().getSeat());
	    		    pw.println(res.getArrivalRoute().getRouteNumber());
	    		    pw.println(res.getArrivalRoute().getRouteDate());
	    		    pw.println(res.getArrivalRoute().getDepartureTrack().getName());
	    		    pw.println(res.getArrivalRoute().getArrivalTrack().getName());
	    		    pw.println(res.getArrivalRoute().getDepatureTime());
	    		    pw.println(res.getArrivalRoute().getArrivalTime());
	    		    pw.println(res.getArrivalRoute().getSeat());
    			}
			//Close PrintWriter
			pw.close();
		} 
		catch (FileNotFoundException e) {
	        System.err.println(e);
	    }
	}
}
