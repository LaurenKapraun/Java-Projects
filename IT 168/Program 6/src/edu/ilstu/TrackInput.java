package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** 
 * There are two input files.  
 * 
 * The first file, TrackData.txt, holds all of the existing reservations.  
 * This is read at the beginning of the program and stored in an array.  
 * 
 * The second file, Transactions.txt,  has the transaction codes and data that is associated with each code.
 
 * @author Lauren Kapraun
 *
 */
public class TrackInput {
	
	//Read TrackData.txt
	public static void readTrackData(Track track) {
	   //Get TrackData.txt
		String fileName = "TrackData.txt";
	    
	    try {
	        Scanner sc = new Scanner(new File(fileName));
        
            //Input information from TrackData.txt
	        while (sc.hasNextLine()) {
            		String passengerName = sc.nextLine();
            		String reservationNumber = sc.nextLine();
                
                String routeNumberDep = sc.nextLine();
                String departureDate = sc.nextLine();
                String departureTrackDep = sc.nextLine();
                String arrivalTrackDep = sc.nextLine();
                String departureTimeDep = sc.nextLine();
                String arrivalTimeDep = sc.nextLine();
                String departureSeat = sc.nextLine();
                
                String routeNumberReturn = sc.nextLine();
                String returnDate = sc.nextLine();
                String departureTrackReturn = sc.nextLine();
                String arrivalTrackReturn = sc.nextLine();
                String departureTimeReturn = sc.nextLine();
                String arrivalTimeReturn = sc.nextLine();
                String returnSeat = sc.nextLine();
                
                //Create a Reservation object and add it to Track
                Route departureRoute = new Route(routeNumberDep, departureDate, new Track(departureTrackDep), new Track(arrivalTrackDep), departureTimeDep, arrivalTimeDep, departureSeat);
                Route arrivalRoute = new Route(routeNumberReturn, returnDate, new Track(departureTrackReturn), new Track(arrivalTrackReturn), departureTimeReturn, arrivalTimeReturn, returnSeat);
                Reservation res = new Reservation(passengerName, reservationNumber, departureRoute, arrivalRoute);
                track.addReservation(res);
	        }
	        //close scanner
	        sc.close();
	    } 
	    catch (FileNotFoundException ex) {
	        System.out.println(fileName + " does not exist");
	    } 
	}
	
	//Read Transactions.txt
	public static void readTransactionData(Track track) {
	    String fileName = "Transactions.txt";
	    
	    try {
	        Scanner sc = new Scanner(new File(fileName));
        
            while (sc.hasNextLine()) {
                String transactionCode = sc.nextLine();
                
                if (transactionCode.equals("1")) {
                    String passengerName = sc.nextLine();
                    String reservationNumber = sc.nextLine();
                    
                    String routeNumberDep = sc.nextLine();
                    String departureDate = sc.nextLine();
                    String departureTrackDep = sc.nextLine();
                    String arrivalTrackDep = sc.nextLine();
                    String departureTimeDep = sc.nextLine();
                    String arrivalTimeDep = sc.nextLine();
                    String departureSeat = sc.nextLine();
                    
                    String routeNumberReturn = sc.nextLine();
                    String returnDate = sc.nextLine();
                    String departureTrackReturn = sc.nextLine();
                    String arrivalTrackReturn = sc.nextLine();
                    String departureTimeReturn = sc.nextLine();
                    String arrivalTimeReturn = sc.nextLine();
                    String returnSeat = sc.nextLine();
                    
                    //fCreate a Reservation object and add it to Track
                    Route departureRoute = new Route(routeNumberDep, departureDate, new Track(departureTrackDep), new Track(arrivalTrackDep), departureTimeDep, arrivalTimeDep, departureSeat);
                    Route arrivalRoute = new Route(routeNumberReturn, returnDate, new Track(departureTrackReturn), new Track(arrivalTrackReturn), departureTimeReturn, arrivalTimeReturn, returnSeat);
                    Reservation res = new Reservation(passengerName, reservationNumber, departureRoute, arrivalRoute);
                    track.addReservation(res);
                } 
                else if (transactionCode.equals("2")) {
                    String reservationNumber = sc.nextLine();
                    TrackOutput.printItinerary(track, reservationNumber);
                } 
                else if (transactionCode.equals("3")) {
                    TrackOutput.printAllItineraries(track);
                } 
                else if (transactionCode.equals("4")) {
                    TrackOutput.writeToFile(track);
                }
            }
            //Close Scanner
            sc.close();
	    } 
	    catch (FileNotFoundException ex) {
	        System.out.println(fileName + " does not exist");
	    } 
	}
}
