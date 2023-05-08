package edu.ilstu;

/** 
 * This class will holds the information about a single route.  
 * 
 * It is responsible for the following data:  
 * route number, route date, departure track, arrival track, departure time, arrival time, and seat assignment
 * 
 * This class includes a default constructor and another constructor that will receive data for all of the instance variables.
 
 * @author Lauren Kapraun
 *
 */
public class Route
{
	//Declare variables
	private String routeNumber;
	private String routeDate;
	private Track departureTrack;
	private Track arrivalTrack;
	private String depatureTime;
	private String arrivalTime;
	private String seat;
	
	//Default Constructor
	public Route() { }
	
	//Route constructor that receives data for all of the instance variables
	public Route(String routeNumber, String routeDate, Track departureTrack, Track arrivalTrack, 
			String depatureTime, String arrivalTime, String seat) {
		this.routeNumber = routeNumber;
		this.routeDate = routeDate;
		this.departureTrack = departureTrack;
		this.arrivalTrack = arrivalTrack;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.seat = seat;
	}

	//Getters & Setters
	public String getRouteNumber(){return routeNumber;}
	public void setRouteNumber(String routeNumber){this.routeNumber = routeNumber;}

	public String getRouteDate(){return routeDate;}
	public void setRouteDate(String routeDate){this.routeDate = routeDate;}

	public Track getDepartureTrack(){return departureTrack;}
	public void setDepartureTrack(Track departureTrack){this.departureTrack = departureTrack;}

	public Track getArrivalTrack(){return arrivalTrack;}
	public void setArrivalTrack(Track arrivalTrack){this.arrivalTrack = arrivalTrack;}

	public String getDepatureTime(){return depatureTime;}
	public void setDepatureTime(String depatureTime){this.depatureTime = depatureTime;}

	public String getArrivalTime(){return arrivalTime;}
	public void setArrivalTime(String arrivalTime){this.arrivalTime = arrivalTime;}

	public String getSeat(){return seat;}
	public void setSeat(String seat){this.seat = seat;}

	
	//toString that formats the data in the form to output to the screen in an itinerary 
	public String toString()
	{
		String s = String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", "Route Number", "Route Date", "Departure Track", "Arrival Track", "Departure Time", "Arrival Time", "Seat");
	    s = s + String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", routeNumber, DateFormatter.formatToWord(routeDate), departureTrack.getName(), arrivalTrack.getName(), depatureTime, arrivalTime, seat);
	    return s;
	}

	
	//Two Route classes are considered equal when they have the same route number & date
	public boolean equals(Object o)
	{
		if (!(o instanceof Route)) {
            return false;
		}  
        //otherwise Cast Object to Route
        Route other = (Route)o;
        
        if (this.routeNumber.equals(other.routeNumber) && this.routeDate.equals(other.routeDate)) {
            return true;
        }
        else {
            return false;
        }
	}
}
