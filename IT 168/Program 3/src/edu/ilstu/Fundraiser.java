/** 
 *  Program Assignment 3
 *  
 *  This program keeps track of the information for one Fundraiser order. 
 *  
 *  It includes the constants: PASTRY_PRICE, COOKIE_DOUGH_PRICE, TIER_ONE_SHARE, and TIER_TWO_SHARE.
 *  
 *  This program also Declare Instance Variables: numberOfCheesePastries, numberOfCinnamonPastries, 
 *  numberOfStrawberryPastries, numberOfChocolateChipDough, numberOfPeanutButterDough
 *  
 * @author Lauren Kapraun
 * @since 2017-10-09
 * Last Updated: 10/09/17
 *
 */
package edu.ilstu;


public class Fundraiser
{
	// Declare and Set Constant Variables
	private final double PASTRY_PRICE = 13;
	private final double COOKIE_DOUGH_PRICE = 22;
	private final double TIER_ONE_SHARE = 0.08;
	private final double TIER_TWO_SHARE = 0.15;

	
	// Declare Instance Variables
	private double numberOfCheesePastries, numberOfCinnamonPastries, numberOfStrawberryPastries, numberOfChocolateChipDough, numberOfPeanutButterDough;

	
	//Declare Instance Variables for Total Pastries & Cookie Dough
	private double totalPastries, totalCookieDough;
	
	// Get Variables
	public double getNumberOfCheesePastries() { return numberOfCheesePastries; }

	public double getNumberOfCinnamonPastries() { return numberOfCinnamonPastries; }

	public double getNumberOfStrawberryPastries() { return numberOfStrawberryPastries; }

	public double getNumberOfChocolateChipDough() { return numberOfChocolateChipDough; }

	public double getNumberOfPeanutButterDough() { return numberOfPeanutButterDough; }

	public double getPASTRY_PRICE() { return PASTRY_PRICE; }

	public double getCOOKIE_DOUGH_PRICE() { return COOKIE_DOUGH_PRICE; }

	public double getTIER_ONE_SHARE() { return TIER_ONE_SHARE; }

	public double getTIER_TWO_SHARE() { return TIER_TWO_SHARE; }

	
	// Set the Pastry Count Instance Fields
	public void setNumberOfCheesePastries(double numberOfCheesePastries){
		this.numberOfCheesePastries = numberOfCheesePastries;
	}

	public void setNumberOfCinnamonPastries(double numberOfCinnamonPastries){
		this.numberOfCinnamonPastries = numberOfCinnamonPastries;
	}

	public void setNumberOfStrawberryPastries(double numberOfStrawberryPastries){
		this.numberOfStrawberryPastries = numberOfStrawberryPastries;
	}

	// Set the Cookie Dough Count Instance Fields
	public void setNumberOfChocolateChipDough(double numberOfChocolateChipDough){
		this.numberOfChocolateChipDough = numberOfChocolateChipDough;
	}

	public void setNumberOfPeanutButterDough(double numberOfPeanutButterDough){
		this.numberOfPeanutButterDough = numberOfPeanutButterDough;
	}
	
	
	
	
	//Set School Share Percentage based on User Input
	public double calculateSchoolShare() {
		totalPastries = numberOfCheesePastries + numberOfCinnamonPastries + numberOfStrawberryPastries; //Calculate Total Pastries
		totalCookieDough = numberOfChocolateChipDough + numberOfPeanutButterDough; //Calculate Total Cookie Dough
		double pastryShare=0.0, cookieShare=0.0;
		
		//If Statement for pastries
		if (totalPastries <= 10)
		{
			pastryShare = TIER_ONE_SHARE;
		}
		else
		{
			pastryShare =  TIER_TWO_SHARE;
		}

		//If Statement for Cookies
		if (totalCookieDough <= 5)
		{
			cookieShare = TIER_ONE_SHARE;
		}
		else
		{
			cookieShare = TIER_TWO_SHARE;
		}
		
		
		double schoolShareTotal = (pastryShare*(calculatePastryCost(totalPastries))+(cookieShare*calculateCookieCost(totalCookieDough)));
		
		return schoolShareTotal;
	}
	
	
	//Calculate Total Pastry Cost
	public double calculatePastryCost(double totalPastries){
		double calculatePastryCost = totalPastries * PASTRY_PRICE;
		return calculatePastryCost;
	}
	
	//Calculate Total Cookie Dough Cost
	public double calculateCookieCost(double totalCookieDough){
		double calculateCookieCost = totalCookieDough * COOKIE_DOUGH_PRICE;
		return calculateCookieCost;
	}
	
	//Calculate Net Cost
	public double calculateNetCost(){
		return (calculatePastryCost(totalPastries) + calculateCookieCost(totalCookieDough) - calculateSchoolShare());
	}

}