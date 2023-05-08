/* File name:  HouseDrawing.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Mar 19, 2018
 *
 * Class: IT 178
 */

package edu.ilstu;

/**
 * This class draws a house using shapes
 * 
 * The Circle Window is colored Red
 * The Square Window is colored Blue
 *
 * @author Lauren Kapraun
 *
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;

public class HouseGraphics extends JFrame
{
	/** Paint:
	 * Create and Place the parts of the house
	 * 
	 * @param g Graphics
	 */
	public void paint(Graphics g){
		super.paint(g);
		
		//Roof
		Polygon triangle = new Polygon();
		triangle.addPoint(275, 50);
		triangle.addPoint(25, 150);
		triangle.addPoint(525, 150);
		g.drawPolygon(triangle);
		
		//House Body
		g.drawRect(25, 150, 500, 400);
		
		//Door
		g.drawRect(230, 350, 100, 200);
		
		//Circle Window
		g.setColor(Color.RED);
		g.fillOval(50, 250, 100, 100);
		
		//Diamond Window
		g.setColor(Color.BLUE);
		Polygon diamond = new Polygon();
		diamond.addPoint(450, 250);
		diamond.addPoint(400, 300);
		diamond.addPoint(450, 350);
		diamond.addPoint(500, 300);
		g.fillPolygon(diamond);
		
		
	}
	
	/** main
	 * Run the program
	 * 
	 */
	public static void main(String[] args){
		HouseGraphics app = new HouseGraphics();
		app.setSize(600, 600);
		app.setVisible(true);
	}
}
