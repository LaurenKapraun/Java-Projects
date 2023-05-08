/** 
 *  Program Assignment 4
 *  
 *  This application takes pizza orders for a store called ISU.
 *  
 * @author Lauren Kapraun
 * @since 2017-10-21
 * Last Updated: 10/26/17
 *
 */

package edu.ilstu;

import java.util.Scanner;

/** 
 * This class keeps track of the store location
 *
 */
public class Store
{
	//Set up Scanner
	Scanner keyboard = new Scanner (System.in);
	
	//Declare variable
	public int pickUpLocation;
	
	//This method shows the menu of the store locations and lets the customer choose one of the stores in order to prepare the pizza for pickup
	public int pickingLocation() {
		System.out.println("Pick a location that is close to you by typing 1, 2, or 3:"
				+ "\n\t1-207 W North St, Normal IL"
				+ "\n\t2-305 S Main St, Normal IL"
				+ "\n\t3-208 Landmark, Bloomington IL");
		pickUpLocation = Integer.parseInt(keyboard.nextLine());
		
		return pickUpLocation;
	}

	//Getter and setter for variable
	public String getPickUpLocation(){ 
		if(pickUpLocation == 1) {
			return "207 W North St, Normal IL";
		}
		
		else if(pickUpLocation == 2) {
			return "305 S Main St, Normal IL";
		}
		
		else {
			return "208 Landmark, Bloomington IL";
		}
		
		
	}
	public void setPickUpLocation(int pickUpLocation){ this.pickUpLocation = pickUpLocation; }
	
	//toString that prints the location of the store chosen
	public String toString() {
		return "This is a pickup order, location of the store to pickup from is " + getPickUpLocation();
	}
}
