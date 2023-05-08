package edu.ilstu;

import java.util.Scanner;


/** 
 * Driver for the Automobile Program.
 
 * @author Lauren Kapraun
 * 
 * @since 2017-11-12
 * Last Updated: 11/16/17
 *
 */
public class AutoDriver
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Create Scanner for User Input
		Scanner keyboard = new Scanner(System.in);

		//InputOutput and Inventory Objects
		InputOutput io = new InputOutput();
		Inventory inventory = new Inventory();
		
		//Variables
		int size = io.readInventory(inventory.getInventory());
		inventory.setCount(size);
		boolean validMenuChoice = false;
		boolean keepAsking = false;
		int menuChoice=0;
		
		//Ask user what they would like to see until they select #7
		while(!keepAsking) {
			try {
			System.out.print("\nSpecialty Auto \n" +
			"\n(1) Display the entire automobile inventory list" +
			"\n(2) Display the entire automobile inventory sorted by year" +
			"\n(3) Display automobiles available for sale" +
			"\n(4) Display list of recently sold automobiles" +
			"\n(5) Output a mailing list of recent buyers" +
			"\n(6) Find automobile by VIN number" +
			"\n(7) Quit" + 
			"\n\nEnter your choice (1-7): ");
			String choiceString = keyboard.nextLine();
			menuChoice = Integer.parseInt(choiceString);
			}catch(NumberFormatException nFE) {
				
			}
		
			//Validate User Input for Delivery or Pickup
			while(!validMenuChoice) {
				if(menuChoice==1 || menuChoice==2 || menuChoice==3 || menuChoice==4 || menuChoice==5 || menuChoice==6 || menuChoice==7) {
					validMenuChoice = true;
					
				}
				else {
					System.out.println("Invalid choice, please try again.");
					System.out.print("\nSpecialty Auto \n" +
							"\n(1) Display the entire automobile inventory list" +
							"\n(2) Display the entire automobile inventory sorted by year" +
							"\n(3) Display automobiles available for sale" +
							"\n(4) Display list of recently sold automobiles" +
							"\n(5) Output a mailing list of recent buyers" +
							"\n(6) Find automobile by VIN number" +
							"\n(7) Quit" + 
							"\nEnter your choice (1-7): ");
					menuChoice = keyboard.nextInt();
				}
			}
			
			//Display based on user input
			switch (menuChoice) {
				case 1:
					System.out.println(String.format("%-8s %-15s %-15s %15s %-10s %10s %-20s %8s", 
							"Year", "Make","Model", "Price", "Condition", "Rating", "Status", "VIN"));
					inventory.displayEntireInventory();
					break;
				case 2:
					inventory.simpleSort();
					System.out.println("\nDisplay all automobile records sorted by year");
					inventory.displayEntireInventory();
					break;
				case 3:
					System.out.println(" ");
					System.out.println(String.format("%-8s %-15s %-15s %15s %-10s %10s %-20s %8s", 
							"Year", "Make","Model", "Price", "Condition", "Rating", "Status", "VIN"));
					inventory.displayAvailableInventory();
					break;
				case 4: 
					inventory.displaySoldInventory();
					break;
				case 5:
					inventory.displayMailListBuyers();
					break;
				case 6:				
					System.out.print("Find exact automobile by VIN number"
							+ "\nPlease enter the VIN number: ");
					String vinNumber = keyboard.nextLine();
					inventory.findExactVehicle(vinNumber);
					break;
				default:
					System.out.println("\nQuitting application.");
					keepAsking = true;
					break;
			}
		}
		
		//Close Scanner
		keyboard.close();
	}

}
