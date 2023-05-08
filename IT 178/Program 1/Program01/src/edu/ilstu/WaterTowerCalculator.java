/* 
 * File name: WaterTowerCalculator.java
 *
 * Programmer: Lauren Kapraun
 *
 * Date: Sep 5, 2017
 */
package edu.ilstu;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class WaterTowerCalculator
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		//Format Decimals and Commas for Large Numbers
		DecimalFormat largeNumberDecimalAndCommas = new DecimalFormat("#,000.00");
		
		//Declare Constant Variables
		final double VALUE_OF_PI = 3.14;
		final double CONVERSION_RATE_FOR_GALLONS = 7.48;
		
		//Declare Variables
		double widthOfWaterTower; //Declare Width Variable
		double radiusOfWaterTower, radiusOfWaterTowerSquared, radiusOfWaterTowerCubed; //Declare Radius Variables
		double areaOfWaterTowerInInches, areaOfWaterTowerInFeet; //Declare Area Variables
		double volumeOfWaterTowerInInches, volumeOfWaterTowerInFeet; //Declare Volume Variables
		double gallonsOfWaterNeeded; //Declare Gallons of Water Needed
			
		
		//Pop-Up Prompt for User
		String userWidthInput = JOptionPane.showInputDialog( null,
				"Please enter the width of the sphere in inches" );
		widthOfWaterTower = Integer.parseInt(userWidthInput);
		
		
		
		//Equations for Radius, Radius Squared, and Radius Cubed
		radiusOfWaterTower = widthOfWaterTower/2;
		radiusOfWaterTowerSquared = radiusOfWaterTower*radiusOfWaterTower;
		radiusOfWaterTowerCubed = radiusOfWaterTower*radiusOfWaterTower*radiusOfWaterTower;
		
		//Equations for Area in Inches and in Feet
		areaOfWaterTowerInInches = 4*VALUE_OF_PI*radiusOfWaterTowerSquared;
		areaOfWaterTowerInFeet = areaOfWaterTowerInInches/12;
		
		//Equations for Volume in Inches in Feet
		volumeOfWaterTowerInInches = (4.0/3)*VALUE_OF_PI*radiusOfWaterTowerCubed;
		volumeOfWaterTowerInFeet = volumeOfWaterTowerInInches/12;
		
		//Equation for the amount of Water needed in Gallons
		gallonsOfWaterNeeded = volumeOfWaterTowerInFeet*CONVERSION_RATE_FOR_GALLONS;
		
		//Print Output Results
		System.out.println("Width of the Sphpere = \n" + widthOfWaterTower
				+"\nArea in inches = " + largeNumberDecimalAndCommas.format(areaOfWaterTowerInInches)
				+"\nArea in feet = " + largeNumberDecimalAndCommas.format(areaOfWaterTowerInFeet)
				+"\nVolumn in inches = " + largeNumberDecimalAndCommas.format(volumeOfWaterTowerInInches)
				+"\nVolumn in feet = " + largeNumberDecimalAndCommas.format(volumeOfWaterTowerInFeet)
				+"\nGallons of water = " + largeNumberDecimalAndCommas.format(gallonsOfWaterNeeded));
	}

}
