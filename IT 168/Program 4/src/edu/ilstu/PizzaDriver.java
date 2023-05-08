/** 
 *  Program Assignment 4
 *  
 *  This application takes pizza orders for a store called ISU.
 *  
 *  A menu will appear that will allow the custom to select options to customize the pizza and choice for delivery or pickup.
 *  
 *  This program verifies every input the user inputs for the choices. "Yes" is not the same as "yes" for an answer.
 *  
 *  The phone number needs to be 10 digits long and only contain numbers.
 * 
 * 
 *  
 * @author Lauren Kapraun
 * @since 2017-10-21
 * Last Updated: 10/26/17
 *
 */

package edu.ilstu;

import java.util.Scanner;

public class PizzaDriver
{

	/**
	 *  This class manages the customer order of the pizza which includes the sauce, cheese, and toppings.
	 *  
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Set up Scanner
		Scanner keyboard = new Scanner (System.in);
		
		
		//Declare validation booleans
		boolean validDeliveryOrPickup = false, validPickUpLocation = false, validPhoneNumber = false, validSauce = false, isInvalid=true, validPlaceOrder = false;
		
		//Declare and Initialize Delivery or Pickup option
		int deliveryOrPickup = 0;
		
		
		//Create Store, Pizza, order, and Customer information
		Store pizzaStore = new Store();
		PizzaBuilder pizza1 = new PizzaBuilder();
		Customer customer1 = new Customer();
		Order order1 = new Order();
		
		/**
		 * Start Output
		 * 
		 */
		
		//Welcome user & ask for delivery or pickup
		System.out.println("\t\tWelcome to ILSTU pizza store, lets cook your Pizza"
				+ "\nFirst: is this for a pickup or delivery? Type 1 for pickup, 2 for delivery");
		System.out.print("Answer: ");
		deliveryOrPickup = Integer.parseInt(keyboard.nextLine());
	
		
		//Validate User Input for Delivery or Pickup
		while(!validDeliveryOrPickup) {
			if(deliveryOrPickup==1 || deliveryOrPickup==2) {
				validDeliveryOrPickup = true;
			}
			else {
				System.out.print("wrong choice, please type 1 for pickup and 2 for delivery: ");
				deliveryOrPickup = Integer.parseInt(keyboard.nextLine());
			}
		}
		
		//Validate Pickup Location
		if (deliveryOrPickup == 1) {
			while(!validPickUpLocation) {
				pizzaStore.pickingLocation();
				if(pizzaStore.pickUpLocation==1 || pizzaStore.pickUpLocation==2 || pizzaStore.pickUpLocation==3) {
					validPickUpLocation = true;
				}
				else {
					System.out.print("Try Again, Not a Valid Location: ");
					
				}
			}
		}
		
		//Validate Delivery Information
		else if (deliveryOrPickup == 2){
			System.out.print("\nPlease enter your full name: ");
			customer1.setName(keyboard.nextLine());
			
			System.out.print("\nPlease enter the address:");
			customer1.setAddress(keyboard.nextLine());
			
			System.out.println("Please provide the phone number starting with the area code: ");
			customer1.setPhoneNumber(keyboard.nextLine());
			
			//Validate Phone Number for Delivery
			while(!validPhoneNumber) {
				if(customer1.getPhoneNumber().length()!=10) {
					System.out.println("Please enter a 10 digit phone number");
					customer1.setPhoneNumber(keyboard.nextLine());
				}
				else {
					validPhoneNumber = true;
				}
			}
		}
		
		//Validate Sauce
		pizza1.chooseSauce();
		while(!validSauce) {
			if(pizza1.getSauceChoice().equals("salsa") || pizza1.getSauceChoice().equals("BBQ") || pizza1.getSauceChoice().equals("Tapenade")
					|| pizza1.getSauceChoice().equals("pesto") || pizza1.getSauceChoice().equals("Bechamel")) {
				validSauce = true;
			}
			else {
				System.out.println("Invalid Sauce type, please select from: salsa, BBQ, "
						+ "Tapenade, tpesto, Bechamel ");
				pizza1.setSauceChoice(keyboard.nextLine());
			}
		}
		
		//Validate Initial Pizza Topping
		pizza1.chooseTopping();
		System.out.println("do you want to add another? type yes or no");
		String choice3= keyboard.nextLine();
		while(isInvalid) {
			if(choice3.equals("no")){
					isInvalid = false;
					pizza1.chooseCheese();
					pizza1.toString();
			}
			else if(choice3.equals("yes")) {
				pizza1.chooseTopping();
				System.out.println("do you want to add another? type yes or no");
				choice3=keyboard.nextLine();
			}
			else {
				System.out.println("Invalid response please type yes or no ");
				System.out.println("do you want to add another? type yes or no");
				choice3=keyboard.nextLine();
			}
		}
		
		
		//Print out Order Summary
		order1.Cost(pizza1);
		order1.Summary(customer1, pizza1, pizzaStore);
		
		//Ask user if they would like to place the order
		System.out.println("Do you want to place the order? type y for yes and n for No");
		String placeOrder = keyboard.nextLine();
		
		//Validate User Input for placing the order
		while(!validPlaceOrder) {
			if(placeOrder.equals("y") ){
				System.out.println("Your pizza will be ready in 30 min, Thanks for doing business with us");
				validPlaceOrder = true;
				
			}
			else if(placeOrder.equals("n")){
				System.out.println("Thanks for thinking of us. please visit us again");
				validPlaceOrder = true;
			}
			else {
				System.out.println("Invalid Response: Do you want to place the order? type y for yes and n for No");
				placeOrder = keyboard.nextLine();
			}
		}
		
		//Close User Input
		keyboard.close();
	}
	
}
