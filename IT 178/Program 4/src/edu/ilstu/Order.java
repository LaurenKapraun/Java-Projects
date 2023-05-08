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

import java.text.DecimalFormat;

/** 
 * This class keeps track of the order type, the cost of the order, and the summary
 *
 */

public class Order
{
	//Set Decimal Format
	DecimalFormat priceFormat = new DecimalFormat("$##.00");
	
	//Declare and set variables
	private int typeOfOrder;
	private int extraToppingCost = 1;
	private double subTotal;
	private double totalPickupCost;
	private double totalDeliveryCost;
	
	//Declare and set constant variables
	private final int COST_OF_ONE_TOPPING = 5;
	private final double SALES_TAX_RATE = 0.075;
	private final double DELIVERY_CHARGE = .20;
	
	
	
	//This method takes information from the PizzaBuilder class and calculates the total cost.
	public void Cost(PizzaBuilder pizza) {
		subTotal = COST_OF_ONE_TOPPING + (extraToppingCost*pizza.determineTopping());
		double calculateTax = subTotal*SALES_TAX_RATE;
		double deliveryCharge = (subTotal*DELIVERY_CHARGE);
		totalPickupCost = subTotal + calculateTax;
		totalDeliveryCost = deliveryCharge + subTotal + calculateTax;
		
	}
	
	//This method will print out the customer information if it's delivery or store location if it's a pickup from a store
	//In addition, it prints out the subtotal and the delivery charge for the order
	public void Summary(Customer customer1, PizzaBuilder pizza1, Store pizzaStore) {
		
		if (pizzaStore.pickUpLocation==1 || pizzaStore.pickUpLocation==2 || pizzaStore.pickUpLocation==3) {
			System.out.println("Order Summery:" 
					+ "\n____________________"
					+ "\n" + pizzaStore.toString()
					+ "\n" + pizza1.toString()
					+ "\nThe subtotal is: " + priceFormat.format(subTotal)
					+ "\nThe total cost is: " + priceFormat.format(totalPickupCost));
		}
		
		else {
			
			System.out.println("Order Summer:" 
					+ "\n____________________"
					+ "\n" + customer1.toString()
					+ "\n" + pizza1.toString()
					+ "\nThe subtotal is: " + priceFormat.format(subTotal)
					+ "\nThe delivery charge is: " + priceFormat.format(DELIVERY_CHARGE)
					+ "\nThe total cost is: " + priceFormat.format(totalDeliveryCost));			
		}
		
	}

	
	//Getters and setter methods for the instance variables
	public int getTypeOfOrder(){ return typeOfOrder; }
	public void setTypeOfOrder(int typeOfOrder){ this.typeOfOrder = typeOfOrder; }


	public int getExtraToppingCost(){ return extraToppingCost; }
	public void setExtraToppingCost(int extraToppingCost){ this.extraToppingCost = extraToppingCost; }

	
	
}
