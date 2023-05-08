package edu.ilstu;

/** 
 * Keeps track of the information about an automobile. 
 * 
 * VIN numbers are used as a unique identifier in the automobile industry. 
 * Our sample file has a shortened simplified version. 
 * 
 * It is also important to make note that the Automobile contains a status field – “available”, “on hold” or “sold”. 
 * If this field is “sold” the automobile record will also have the customer information.
 
 * @author Lauren Kapraun
 * 
 * @since 2017-11-12
 * Last Updated: 11/16/17
 *
 */
public class Automobile
{
	//Create Customer
	public Customer customer1;
	
	//Declare Variables
	private int year, rating;
	private String make, model, condition, status, vin;
	private double price;
	
	//Automobile Method #1: year, make, model, price, condition, rating, status, & vin
	public Automobile(int year, String make, String model, double price, String condition, int rating, 
			String status, String vin) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.price = price; 
		this.condition = condition;
		this.rating = rating;
		this.status = status; 
		this.vin = vin;
	}
	
	//Automobile Method #2: Includes everything from the first method plus the customer information
	public Automobile(int year, String make, String model, double price, String condition, int rating, 
			String status, String vin, Customer customer1) {
		this(year, make, model, price, condition, rating, status, vin);
		this.customer1 = customer1;
		
	}
	
	//Getters for year, make, model, status, customer, and vin
	public int getYear() {return year;}
	public String getMake() {return make;}
	public String getModel() {return model;}
	public String getStatus() {return status;}
	public Customer getCustomer() {return customer1;}
	public String getVin() {return vin;}
	
	//toString method that formats the table layout when code is executed
	public String toString() {
		return String.format("%-8d %-15s %-15s %,15.2f %-10s %10d %-20s %-10s", year, make, model, price, condition, rating, status, vin);
	}
	
	//Checks if user inputed a valid vin for an available car
	public boolean equals(Automobile object) {
		if(vin.equals(object.getVin())) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
