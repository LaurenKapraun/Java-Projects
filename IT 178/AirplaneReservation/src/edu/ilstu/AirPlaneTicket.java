/* 
 * File name: AirPlaneTicket.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Mar 16, 2018
 *
 * Class: IT 178
 */
package edu.ilstu;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/** 
 * Creates the layout for the Airplane Application.
 * 
 * It asks users for their flight information and generates
 * a price check, and final ticketing information.
 * 
 * @author Lauren Kapraun
 *
 */
public class AirPlaneTicket extends JFrame implements ActionListener
{
	private Container content;
	private JButton checkPrice, submit;
	private JLabel name, date, title, departureAirportLabel, arrivalAirportLabel, flightDetails, priceLabel;
	private JRadioButton economy, business;
	private ButtonGroup seatPreference;
	private Panel westPanel, northPanel, eastPanel;
	private JTextField nameInput, dateInput;
	private AirplaneDeals flight = new AirplaneDeals();
	
	String[] airportChoice = { "CHI", "LAX", "YVR"};
	String[] economySeats = { "A1", "A2", "A3", "A4", "B1", "B2", "B3", "B4"};
	String[] businessSeats = { "C1", "C2", "C3", "C4", "C5", "C6", "D1", "D2", "D3", "D4", "D5", "D6"};
	private JComboBox<String>  departureAirport, arrivalAirport, economySeatNumber, businessSeatNumber;
	
	/** AirPlaneTicket
	 * 
	 * Default Constructor that builds the application & its layout
	 * 
	 * 
	 */
	public AirPlaneTicket(){
		super("Airplane Ticket");
		
		//Content Container
		content = getContentPane();
		content.setLayout(new BorderLayout());
		
		//Buttons
		checkPrice = new JButton("Check Price");
		submit = new JButton("Submit");
		
		//Set JButton ActionListeners
		checkPrice.addActionListener(this);
		submit.addActionListener(this);
		
		//Labels
		title = new JLabel("Welcome to GoEverywhere");
		name = new JLabel("First & Last Name");
		date = new JLabel ("\n\nDate");
		departureAirportLabel = new JLabel("\n\nDeparture Airport");
		arrivalAirportLabel = new JLabel("\n\nArrival Airport");
		flightDetails = new JLabel("Flight Details");
		priceLabel = new JLabel("");
		
		//Radio Buttons
		economy = new JRadioButton("Economy");
        business = new JRadioButton("Business");
        
        //Group Radio Buttons
        seatPreference = new ButtonGroup( );
        seatPreference.add( economy );
        seatPreference.add( business );

        //RadioButtonHandler event handler
        RadioButtonHandler rbh = new RadioButtonHandler( );
        economy.addItemListener( rbh );
        business.addItemListener( rbh );
		
        //Drop Down Boxes
		departureAirport = new JComboBox<String>(airportChoice);
		arrivalAirport = new JComboBox<String>(airportChoice);
		economySeatNumber = new JComboBox<String>(economySeats);
		businessSeatNumber = new JComboBox<String>(businessSeats);
		
		//Text Boxes
		nameInput = new JTextField(30);
		dateInput = new JTextField(10);
		
		//Panels
		northPanel = new Panel();
		westPanel = new Panel();
		eastPanel = new Panel();
		
		//NorthPanel
		northPanel.add(title);
		content.add(northPanel, BorderLayout.NORTH);
		
		//WestPanel
		westPanel.setPreferredSize(new Dimension(370, 600));
		westPanel.add(name).setPreferredSize(new Dimension(370, 20));
		westPanel.add(nameInput).setPreferredSize(new Dimension(370, 30));
		nameInput.getText();
		
		westPanel.add(departureAirportLabel).setPreferredSize(new Dimension(370, 20));
		westPanel.add(departureAirport).setPreferredSize(new Dimension(370, 30));
		
		westPanel.add(date).setPreferredSize(new Dimension(370, 20));
		westPanel.add(dateInput).setPreferredSize(new Dimension(250, 30));
		dateInput.getText();
		
		westPanel.add(arrivalAirportLabel).setPreferredSize(new Dimension(370, 20));
		westPanel.add(arrivalAirport).setPreferredSize(new Dimension(370, 30));
		
		westPanel.add(economy);
		westPanel.add(business);
		westPanel.add(businessSeatNumber).setPreferredSize(new Dimension(370, 20));
		westPanel.add(economySeatNumber).setPreferredSize(new Dimension(370, 20));
		
		westPanel.add(checkPrice);
		westPanel.add(priceLabel);
		
		westPanel.add(submit).setPreferredSize(new Dimension(370, 40));
		
		content.add(westPanel, BorderLayout.WEST);
		
		//EastPanel
		//Hide East Text until user clicks the "Submit" Button
		priceLabel.setVisible(false);
		checkPrice.setVisible(false);
		submit.setVisible(false);
		businessSeatNumber.setVisible(false);
		economySeatNumber.setVisible(false);
		
		content.add(eastPanel, BorderLayout.EAST);
		
		setSize(700, 700);
		setVisible(true);
	}
	
	/** checkFormValidity
	 * 
	 * Helper function that validates that the user has selected valid options
	 * 
	 * @return true if the user selected valid departure & arrival airports
	 */
	private boolean checkFormValidity() {
		if(departureAirport.getSelectedItem() == arrivalAirport.getSelectedItem()) {
			JOptionPane.showMessageDialog(new JFrame(), "Cannot have same departure & destination!");
			return false;
		}
		return true;
	}
	
	/** displayPrice
	 * 
	 * Displays the price next to the "Check Price" button
	 * 
	 */
	private void displayPrice() {
		//Check the parameters
		if(!checkFormValidity()) {
			return;
		}
		
		//Get flight details
		FlightData selectedFlight = flight.getTicket(String.valueOf(departureAirport.getSelectedItem()),
				String.valueOf(arrivalAirport.getSelectedItem()));
		priceLabel.setText("$" + String.valueOf(selectedFlight.getPrice()));
		priceLabel.setVisible(true);
		content.revalidate();
	}
	
	/** generateAndDisplayTicket
	 * 
	 * Helper function to toggle the display of the ticket 
	 * based on clicking "Check Price"
	 * 
	 */
	private void generateAndDisplayTicket() {
		eastPanel.add(flightDetails);
		
		//Check the parameters
		if(!checkFormValidity()) {
			return;
		}
		
		//Get flight details
		FlightData selectedFlight = flight.getTicket(String.valueOf(departureAirport.getSelectedItem()),
				String.valueOf(arrivalAirport.getSelectedItem()));
		eastPanel.setPreferredSize(new Dimension(400, 600));
		
		//Create Ticket Text
		String ticketText = "";
		ticketText += "Flight details <br><br>";
		ticketText += nameInput.getText() + "<br>";
		ticketText += "Flight Number: " + selectedFlight.getFlightNumber() + "<br>";
		ticketText += "Seat: ";
		if(seatPreference.getSelection() == business) {
			ticketText += String.valueOf(businessSeatNumber.getSelectedItem()) + "<br>";
		}
		else {
			ticketText += String.valueOf(economySeatNumber.getSelectedItem()) + "<br><br>";
		}
		
		ticketText += "Airport: " + selectedFlight.getCityOrigin() + " to "
				+ selectedFlight.getCityDestination() + "<br>";
		ticketText += "Date: " + dateInput.getText() + "<br>";
		ticketText += "Time: " + selectedFlight.getFlightTime() + "<br>";
		ticketText += "Price $" + String.valueOf(selectedFlight.getPrice());
		
		//Apply the ticketText as HTML
		flightDetails.setText("<html>" + ticketText + "<html>");
		eastPanel.setVisible(true);
		content.revalidate();
	}
	
	/** actionPerformed
	 * 
	 * Displays Price if the "Check Price" button is clicked
	 * Displays the Ticket Details on the right if the "Submit" button is clicked
	 * 
	 * @param e ActionEvent
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == checkPrice) {
			displayPrice();
		}
		else if(e.getSource() == submit) {
			generateAndDisplayTicket();
		}
	}
	
	/** RadioButtonHandler
	 * 
	 * This class implements ItemListener
	 * 
	 * Displays the checkPrice, submit, economySeatNumber, and businessSeatNumber 
	 * depending on if the user clicks the radio button for economy or business
	 * 
	 */
	private class RadioButtonHandler implements ItemListener {
		public void itemStateChanged( ItemEvent ie ) {
			if ( ie.getSource( ) == economy ) {
				checkPrice.setVisible(true);
				submit.setVisible(true);
				economySeatNumber.setVisible(true);
				businessSeatNumber.setVisible(false);
			}
		  
			else if ( ie.getSource( ) == business ) {
				checkPrice.setVisible(true);
				submit.setVisible(true);
				economySeatNumber.setVisible(false);
				businessSeatNumber.setVisible(true);
			}
			content.revalidate();
		}
	}
	
	/** main
	 * 
	 * Runs the application
	 * 
	 * @param args String[]
	 * 
	 */
	public static void main(String[] args){
		AirPlaneTicket app = new AirPlaneTicket();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
