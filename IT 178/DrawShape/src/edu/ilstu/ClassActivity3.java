/* File name:  ClassActivity3.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Mar 22, 2018
 *
 * Class: IT 178
 * Lecture Section: 001   
 */

package edu.ilstu;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

/** 
 * This class has a user hit either the "Add Circle" or "Add Square" button 
 * to create new circles or squares.
 * 
 * When the button is pressed, the circle or square positions are randomly 
 * placed within the window.
 * 
 * If the user selects the square button after the circle, 
 * the circles are hidden until the circle button is clicked again.
 * 
 * @author Lauren Kapraun
 *
 */

public class ClassActivity3 extends JFrame {
	
	private Container contents;
	private JButton createCircle, createSquare;
	private boolean drawCircle = false;
	private boolean drawSquare = false;
	private ArrayList<Point> points;
	private ArrayList<Point> squarePoints;
	
	/**
	 * Default ClassActivity3 Constructor
	 * 
	 */
	public ClassActivity3(){
		super("Let's Draw Circles!");
		
		//Setup ArrayLists
		points = new ArrayList<Point>();
		squarePoints = new ArrayList<Point>();
		
		
		contents = getContentPane( ); 
		
		//Create Flow Layout
		contents.setLayout( new FlowLayout( ) ); 
		
		//Create Circle Button
		createCircle = new JButton( "Add Circle" );	
		contents.add( createCircle );
		
		//Create Square Button
		createSquare = new JButton( "Add Square" );	
		contents.add( createSquare );
		
		//Call for ButtonHandler
		ButtonHandler bh = new ButtonHandler( );
		createCircle.addActionListener( bh );
		createSquare.addActionListener( bh );
		
		//Set size of screen & make visible
		setSize(600, 600);
		setVisible(true);
	}
	
	/**
	 * ButtonHandler Class
	 * 
	 * Makes drawCircle or drawSquare true, creates a new circle or square and adds it to the ArrayList
	 * 
	 */
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// On add circle click, create a new random point for circle center and add it to the array
			if(e.getSource( ) == createCircle ) {
				drawCircle = true;
				Random random = new Random();
	    			int x = random.nextInt(600) + 1;
	    			int y = random.nextInt(600) + 1;
	    			
				points.add(new Point(x, y));
			    repaint();
			}
			// On add square click, create a new random point for the square and add it to the array
			else if (e.getSource( ) == createSquare) {
				drawSquare = true;
				Random random = new Random();
	    			int x = random.nextInt(600) + 1;
	    			int y = random.nextInt(600) + 1;
	    			
	    			squarePoints.add(new Point(x, y));
			    repaint();
			}
		}
	}
	
	/**
	 * Paint the Circles
	 * 
	 * @param g		Graphics
	 * 
	 */
	public void paint(Graphics g){
		super.paint(g);
		
		//Create Circle & Set Color to Red
		g.setColor(Color.RED);
		while(drawCircle == true) {
			for (Point point : points) {
				//place on x,y coordinate with a size of 100x100
	            g.fillOval(point.x, point.y, 100, 100);
	        }
			//Stop drawing until button is clicked again
			drawCircle = false;
	    	}  
		
		//Create Square & Set Color to Blue
		g.setColor(Color.BLUE);
		while(drawSquare == true) {
			for (Point point : squarePoints) {
				//place on x,y coordinate with a size of 100x100
	            g.fillRect(point.x, point.y, 100, 100);
	        }
			//Stop drawing until button is clicked again
			drawSquare = false;
	    	}  
	}
	
	
	/** main
	 * Run the program
	 * 
	 */
	public static void main(String[] args){
		ClassActivity3 app = new ClassActivity3();
		app.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
