package edu.ilstu;

/** 
 * Display the itinerary for one passenger
 
 * @author Lauren Kapraun
 *
 */
public class TrackOutput
{
    //Output Single Itinerary
	public static void printItinerary(Track track, String reservationNumber) 
    {
        track.printItinerary(reservationNumber);
    }
    
	//Output All Itineraries
    public static void printAllItineraries(Track track) 
    {
        track.printAllItineraries();
    }
    
    //Write to File
    public static void writeToFile(Track track) 
    {
        track.writeToFile();
    }

}
