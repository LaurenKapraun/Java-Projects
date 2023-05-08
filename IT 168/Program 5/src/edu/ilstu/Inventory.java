package edu.ilstu;

/**
 * Represents an inventory of automobiles and related methods
 * 
 * Keeps track of the all automobiles in stock and sold 
 *
 * @author Schaefer
 * 
 * @author Lauren Kapraun
 * @since 2017-11-12
 * Last Updated: 11/16/17
 *
 */
public class Inventory
{
	private final static int ARRAY_SIZE = 100;
	private Automobile[] inventory;
	private int size;
	
	/**
	 * Constructor - creates the inventory array
	 */
	public Inventory(){ inventory = new Automobile[ARRAY_SIZE]; }
	
	//Sort file rows by year
	public void simpleSort() {
		Automobile temp;
		int max;
		for(int i=0; i< size-1; i++) {
			max = indexOfLargest(inventory, size-i);
			temp = inventory[max];
			inventory[max] = inventory[size-i-1];
			inventory[size-i-1] = temp;
		}
	}
	
	//Largest year
	public int indexOfLargest(Automobile[] auto, int size) {
		int index = 0;
		for(int i=1; i<size; i++) {
			if(auto[i].getYear()>auto[index].getYear()) {
				index = i;
			}
		}
		return index;
	}
	
	//Display entire file
	public void displayEntireInventory() {
		for(int i=0; i<size; i++) {
			System.out.println(inventory[i]);
		}
	}
	
	//Display only vehicles that have not sold
	public void displayAvailableInventory() {
		for(int i=0; i<size; i++) {
			if(inventory[i].getStatus().equals("Available") ) {
				System.out.println(inventory[i]);
			}
		}
	}
	
	//Display vehicles that have sold
	public void displaySoldInventory() {
		for(int i=0; i<size; i++) {
			if(inventory[i].getStatus().equals("Sold") ) {
				System.out.println(inventory[i].getYear() + " " + inventory[i].getMake() + " " + inventory[i].getModel());
			}
		}
	}
	
	//Display Mailing List
	public void displayMailListBuyers() {
		System.out.println("Display mailing list of recent buyers\n");
		for(int i=0; i<size; i++) {
			if(inventory[i].getStatus().equals("Sold"))  {
				System.out.println(inventory[i].getCustomer());
				System.out.println("");
			}
		}
		
	}
	
	//Find vehicle by Vin Number
	public void findExactVehicle(String vin) {
		boolean wasFound = false;
		for(int i=0; i<size; i++) {
			if(inventory[i].getVin().equals(vin)) {
				wasFound = true;
				System.out.println("\nWe have find this vehicle:");
				System.out.println(inventory[i]);
			}
		}
		if(wasFound == false) {
			System.out.println("Vehicle not found.");
		}
	}
	
	
	//Getters & Setters
	public Automobile[] getInventory() {return inventory;}
	public void setTable(int Automobile[], Automobile[] inventory) {this.inventory = inventory;}
	
	public int getCount() {return size;}
	public void setCount(int size) {this.size = size;}
	
}
