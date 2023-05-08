/*
 *  File name:  SwimmerApp.java 
 */

package edu.ilstu;

import java.util.ArrayList;

/**
 * This program keeps a record of the results of one event in a swimming competition. 
 * 
 * This class contains an ArrayList of Swimmer objects. There are four ArrayLists with 6 swimmers. 
 * Each ArrayList represents a heat in a swimming event.
 * 
 * @author Patricia Matsuda
 * @author Lauren Kapraun
 *
 */
public class SwimmerApp
{
	/* run:
	 * Creates 4 Array Lists for the 4 heats
	 * Displays each of the heats & the Winners from each heat
	 * 
	 */
	private void run(){
		//ArrayLists for the 4 heats
	    ArrayList<Swimmer> heat1 = new ArrayList<Swimmer>();
	    ArrayList<Swimmer> heat2 = new ArrayList<Swimmer>();
	    ArrayList<Swimmer> heat3 = new ArrayList<Swimmer>();
	    ArrayList<Swimmer> heat4 = new ArrayList<Swimmer>();

	    for (int i = 0; i < 24; i++) {
	        //Add Swimmers 1-6 into heat 1
	    		if (i >= 0 && i < 6){
	          heat1.add(loadArray1().get(i));
	        }
	    		//Add Swimmers 7-12 into heat 2
	        else if (i >= 6 && i < 12) {
	          heat2.add(loadArray1().get(i));
	        } 
	    		//Add Swimmers 13-18 into heat 3
	        else if (i >= 12 && i < 18)  {
	          heat3.add(loadArray1().get(i));
	        } 
	    		//Add Swimmers 19-24 into heat 4
	        else if (i >= 18 && i < 24) {
	          heat4.add(loadArray1().get(i));
	        }
	    }

		//Display each of the Heats
		System.out.println("Heat 1:\n");
	    displayArray(heat1);
	
	    System.out.println("Heat 2:\n");
	    displayArray(heat2);
	
	    System.out.println("Heat 3:\n");
	    displayArray(heat3);
	
	    System.out.println("Heat 4:\n");
	    displayArray(heat4);
	
	    //Display the fastest swimmer from each heat
	    System.out.println("Heat Winners are:");
	    System.out.print("Heat 1: " + findFastestSwimmer(heat1));
	    System.out.print("Heat 2: " + findFastestSwimmer(heat2));
	    System.out.print("Heat 3: " + findFastestSwimmer(heat3));
	    System.out.print("Heat 4: " + findFastestSwimmer(heat4));
	
	}


	/* loadArray1:
	 * Method that loads the ArrayList with Swimmer objects.
	 * 
	 * @return tempArray Array with Swimmer information
	 * 
	 */
	private ArrayList<Swimmer> loadArray1(){
		ArrayList<Swimmer> tempArray = new ArrayList<Swimmer>();

		//Heat 1
		tempArray.add(new Swimmer("Emely Rose","Lee","00:27.15"));
		tempArray.add(new Swimmer("Rachel","Marion","00:45.22"));
		tempArray.add(new Swimmer("Alysson","White","00:40.00"));
		tempArray.add(new Swimmer("Marie Anne","Jameson","00:28.10"));
		tempArray.add(new Swimmer("Ardell","Artman","00:27.13"));
		tempArray.add(new Swimmer("Adella ","Aguirre","00:32.32"));

		//Heat 2
		tempArray.add(new Swimmer("Jennifer","Judson","00:30.05"));
		tempArray.add(new Swimmer("Anna K.","Behrensmeyer","00:31.01"));
		tempArray.add(new Swimmer("Caroline","Herschel","00:27.40"));
		tempArray.add(new Swimmer("Chien-Shiung","Wu","00:30.04"));
		tempArray.add(new Swimmer("Michelle","Phelps","00:32.35"));
		tempArray.add(new Swimmer("Dorothy","Hodgkin","00:38.12"));

		//Heat 3
		tempArray.add(new Swimmer("Frieda","Robscheit-Robbins","00:45:12"));
		tempArray.add(new Swimmer("Elizabeth","Blackburn","00:37.22"));
		tempArray.add(new Swimmer("Edna","Schroedinger","00:38.01"));
		tempArray.add(new Swimmer("Geraldine","Seydoux","00:29.21"));
		tempArray.add(new Swimmer("Maria","Mitchell","00:29.21"));
		tempArray.add(new Swimmer("Ingrid","Daubechies","00:33.24"));

		//Heat 4
		tempArray.add(new Swimmer("Jacqueline ","Barton","00:28.32"));
		tempArray.add(new Swimmer("Cecilia","Mason","00:27.12"));
		tempArray.add(new Swimmer("Jecelyn Bell","Burnell","00:29.11"));
		tempArray.add(new Swimmer("Lise","Meitner","00:31.33"));
		tempArray.add(new Swimmer("Maxine","Planck","00:32.23"));
		tempArray.add(new Swimmer("Anna","Cabral","00:27.02"));

		//return the ArrayList
		return tempArray;

	}
	

	/* displayArray:
	 * Method to display the Swimmer List
	 * 
	 * @param swimmersList ArrayList<Swimmer>
	 * 
	 */
	private void displayArray(ArrayList<Swimmer> swimmersList) {
	    //Loop through each of the Swimmers & Display
		for (Swimmer swimmer: swimmersList) {
	      System.out.print(swimmer.toString());
	    }
	    
	    System.out.print("\n");
	}

	
	/* findFastestSwimmer:
	 * Method to determine the fastest Swimmer in the heat
	 * 
	 * @param swimmersList ArrayList<Swimmer>
	 * @return swimmersList.get(counter) Return the fastest swimmer
	 * 
	 */
	private Swimmer findFastestSwimmer(ArrayList<Swimmer> swimmersList) {
		//Create Array and counter
		double [] array = new double[6];
		int counter = 0;

	    //Get the each swimmer's time in milliseconds
		for (Swimmer swimmer: swimmersList) {
	      array[counter] = swimmer.getTimeInMilliseconds();
	      counter ++;
	    }
		
		//Find the fastest time
	    counter = 0;
	    double lowest = array[0];
	    for(int i = 1; i < array.length; i++){
	        //if a swimmer's time is faster than the temporary stored time, set their time as the fastest
	    		if(array[i] < lowest){
	          lowest = array[i];
	          counter = i;
	        }
	    }

	    //Return the fastest swimmer
	    return swimmersList.get(counter);
	}
	
	
	/* main:
	 * Main Method
	 * 
	 * @param args String[]
	 * 
	 */
	//DO NOT CHANGE THIS MAIN METHOD
	public static void main(String[] args) {
		SwimmerApp app = new SwimmerApp();
		app.run();
	}
}
