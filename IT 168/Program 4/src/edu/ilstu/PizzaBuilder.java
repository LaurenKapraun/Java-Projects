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
 * This class is used to customize the pizza, like the sauce, toppings, and cheese.
 * 
 * It also keeps track o the number of toppings that are needed in the Order class to calculate the cost.
 *
 */

public class PizzaBuilder
{
	//Declare Variables
	public String choice2;
	private String sauceChoice, cheeseChoice;
	private int choice;
	private int toppingCount;
	private String toppings="", currentTopping="";
	
	//Set up Scanner
	Scanner keyboard = new Scanner (System.in);
	
	
	//This method displays the list of sauces and lets the customer choose one
	public String chooseSauce() {
		System.out.print("\nSecond, let's build your pizza"
				+ "\nPick a sauce by typing the sauce: "
				+ "\n\tList of Sauces: salsa \tBBQ \tTapenade \tpesto \tBechamel");
		
		System.out.print("\nAnswer: ");
		sauceChoice = keyboard.nextLine();
		return sauceChoice;
	}
	
	
	//This method lets the customer pick more than one topping and makes sure the user doesn't pick the same topping twice
	public String chooseTopping(){
		System.out.println("\nTopping List:"
				+ "\n\t1-Onion"
				+ "\n\t2-Olives"
				+ "\n\t3-Tomato"
				+ "\n\t4-Mushrooms"
				+ "\n\t5-Green Peppers"
				+ "\n\t6-Pepperoni");
		
		System.out.print("Pick Topping from the list above ");
		
		
		boolean flag = true;
		choice = keyboard.nextInt( );
		
		while(flag){
			currentTopping = selectTopping(choice);
			if (toppings.contains(currentTopping)){
				System.out.println("you already chose this Topping, choose another");
				
				flag=false;
			}
			else{
				toppings += " " + currentTopping;
				flag=false;
				toppingCount++;
			}
		
			
		}
		return toppings;
		
	}
	
	
	//This method contains the topping choices
	private String selectTopping(int choice){
		String topping = " ";
		
		switch(choice){
			case 1:
				topping = "onion ";
				break;
				
			case 2:
				topping = "olives ";
				break;
				
			case 3:
				topping = "tomato";
				break;
				
			case 4:
				topping = "mushrooms ";
				break;
				
			case 5:
				topping = "green peppers ";
				break;
				
			case 6:
				topping = "pepperoni ";
				break;
		}
		return topping;

	}
	
	
	//This method will let the user choose between extra cheese or normal cheese
	public String chooseCheese() {
		System.out.println("do you want extra cheese, it's Free :)? Type Y for Yes, and N for No");
		keyboard.nextLine();
		String response=keyboard.nextLine( );
		boolean isInvalid = true;
		while(isInvalid) {
		if (response.equals("N")){
			cheeseChoice = "normal amount of";
			isInvalid=false;
		}
		else if(response.equals("Y")) {
			cheeseChoice = "extra";
			isInvalid=false;
		}else {
			System.out.println("Invalid response. Please type Y for extra cheese or N for normal cheese");
			response=keyboard.nextLine();
		}
		}
		return cheeseChoice;
	}
	
	
	//This method updates the counter for the calculation. If the user picked only one topping, then the price of the pizza should not be effected.
	//If the user picked more than one topping, then the price of the pizza will increase by $1 for each additional topping
	public int determineTopping() {
		
		if(toppingCount == 0) {
			
			return 0;
		}
		else {
			return toppingCount-1;
		}
	}
	
	
	//Getters and Setters for Instance Variables
	public String getSauceChoice(){ return sauceChoice;}
	public void setSauceChoice(String sauceChoice){ this.sauceChoice = sauceChoice; }
	
	public int getChoice(){ return choice;}
	public void setChoice(int choice){ this.choice = choice; }

	
	public String getCheeseChoice(){ return cheeseChoice; }
	public void setCheeseChoice(String cheeseChoice){ this.cheeseChoice = cheeseChoice; }

	
	//toString that prints the sauce, cheese and all the toppings the customer picked
	public String toString() {
		return "The pizza will have " + sauceChoice + " sauce, "
				+ "with " + cheeseChoice + " cheese, "
				+ "and " + this.toppings+"toppings";
	}
	
	
	
	

}
