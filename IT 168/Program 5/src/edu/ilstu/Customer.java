package edu.ilstu;

/** 
 * Keeps track of the customer’s information
 
 * @author Lauren Kapraun
 *
 *@since 2017-11-12
 * Last Updated: 11/16/17
 */
public class Customer
{

	//Declare variables
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String phoneNumber;
	
	//This method reads the customer data and stores it in the instant variables
	public Customer(String firstName, String lastName, String address, String city, 
			String state, String zip, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	//Getters
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getAddress() {return address;}
	public String getCity() {return city;}
	public String getState() {return state;}
	public String getZip() {return zip;}
	public String getEmail() {return email;}
	public String getPhoneNumber() {return phoneNumber;}
	
	//toString that prints out Customer Information
	public String toString() {
		return "Name: " + firstName + " " + lastName
				+ "\nAddress: " + address
				+ "\nCity/State/Zip: " + city + " " + state + " " + zip
				+ "\nEmail: " + email
				+ "\nPhone: " + "("+ phoneNumber.substring(0, 3)+") "+ phoneNumber.substring(3, 6)+"-"+ phoneNumber.substring(6, 10);
	}
}
