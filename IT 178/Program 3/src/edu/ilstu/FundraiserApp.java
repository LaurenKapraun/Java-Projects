/** 
 *  Program Assignment 3
 *  
 *  This program is the supplemental tester for Fundraiser.java
 
 * @author Lauren Kapraun
 * @since 2017-10-09
 * Last Updated: 10/09/17
 *
 */
package edu.ilstu;

import java.util.Scanner;


public class FundraiserApp
{

	/**
	 * This is the starting point for the application Fundraiser.java
	 * 
	 * The main method handles all of the input and output for the program.
	 *  
	 * @param args
	 */
	
	public static void main(String[] args)
	{		
		//Create new order for user
		Fundraiser order1 = new Fundraiser();
		
		//Set Scanner
		Scanner keyboard = new Scanner (System.in);
		
		//Print Out Menu
		System.out.println("\tWelcome to the Pastry and Cookies Products" +
			"\nPastry" +
			"\n\nCinnamon\t\t $13.00" +
			"\nCheese\t\t $13.00" +
			"\nStrawberry\t $13.00" + 
			"\n\nCookie Dough"+
			"\n\nChocolate Chip\t $22.00" +
			"\n\nPeanut Butter\t $22.00\n"
		);
		

		//Ask for Number of each Pastry
		System.out.print("\nEnter number Cinnamon pastry: ");
		double numberOfCinnamonPastries = keyboard.nextDouble();
		System.out.print("Enter number Cheese pastry: ");
		double numberOfCheesePastries = keyboard.nextDouble();
		System.out.print("Enter number Strawberry pastry: ");
		double numberOfStrawberryPastries = keyboard.nextDouble();
		
		//Set User inputs for Pastries
		order1.setNumberOfCheesePastries(numberOfCheesePastries);
		order1.setNumberOfCinnamonPastries(numberOfCinnamonPastries);
		order1.setNumberOfStrawberryPastries(numberOfStrawberryPastries);
		
		//Calculate Pastry Price
		double totalPastryPrice = order1.calculatePastryCost(numberOfCinnamonPastries+numberOfCheesePastries+numberOfStrawberryPastries);
		
		//Ask for Number of each Cookie Dough
		System.out.print("Enter number Chocolate Chip cookie dough: ");
		double numberOfChocolateChipDough = keyboard.nextDouble();
		System.out.print("Enter number Peanut Butter cookie dough: ");
		double numberOfPeanutButterDough = keyboard.nextDouble();
		
		//Set User inputs for Cookies
		order1.setNumberOfChocolateChipDough(numberOfChocolateChipDough);
		order1.setNumberOfPeanutButterDough(numberOfPeanutButterDough);
		
		//Calculate Cookie Price
		double totalCookiePrice = order1.getCOOKIE_DOUGH_PRICE()*(numberOfChocolateChipDough+numberOfPeanutButterDough);
		
		//Closes keyboard input
		keyboard.close();
		
		
		//Print Order Summary
		System.out.println("\n\nOrder Summary" +
			"\n\t\t\tOrder Counts" + 
			"\nCinnamon\t\t\t" + numberOfCinnamonPastries +
			"\nCheese\t\t\t" + numberOfCheesePastries +
			"\nStrawberry\t\t" + numberOfStrawberryPastries +
			"\nChocolate Chip\t\t" + numberOfChocolateChipDough +
			"\nPeanut Butter\t\t" + numberOfPeanutButterDough
		);
		
		System.out.printf("\n\nTotal Order Cost: $%.2f",(totalPastryPrice+totalCookiePrice));
		System.out.printf("\n\nSchool Share: $%.2f",order1.calculateSchoolShare());
		System.out.printf("\n\nNet Cost to be paid: $%.2f",order1.calculateNetCost());
		
	}

}
