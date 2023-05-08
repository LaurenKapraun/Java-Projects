/* 
 * File name: Book.java
 * 
 * Programmer:  Lauren Kapraun
 *
 * Date:  Apr 11, 2018
 *
 * Class: IT 178
 */

package edu.ilstu;

import java.util.LinkedList;

/** 
 * The Book Class creates a set instance of Book Type.
 * Then adds 4 Book objects to the set.
 * It then displays the information for each Book Object.
 * 
 * @author Lauren Kapraun
 *
 */

public class Book
{
	private String title;
	private String author;
	private String isbn;
	
	/**
	 * Constructor that accepts values for all Book data information.
	 * 
	 * @param title		String
	 * @param author	String
	 * @param isbn		String
	 */
	public Book(String title, String author, String isbn){
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	
	/**
	 * 	Returns the title of the book
	 * 
	 * @return title
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * 	Returns the author of the book
	 * 
	 * @return author
	 */
	public String getAuthor(){
		return author;
	}

	/**
	 * 	Returns the ISBN of the book
	 * 
	 * @return isbn
	 */
	public String getIsbn(){
		return isbn;
	}
	
	/**
	 * toString that formats Book information
	 */
	@Override
	public String toString()
	{
		return "Title: " + title + 
				"\nAuthor: " + author + 
				"\nISBN: " + isbn +
				"\n";
	}

	/**
	 * Main method that creates a new LinkedList <Book>
	 * Then adds 4 books and prints the array
	 * 
	 * @param args	String[]
	 */
	public static void main(String[] args)
	{
		LinkedList <Book> books = new LinkedList <Book>();
		
		books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "0439708184"));
		books.add(new Book("It Gets Worse: A Collection of Essays", "Shane Lee Dawson", "1501132849"));
		books.add(new Book("Marley: A Dog Like No Other", "John Grogan", "0061240354"));
		books.add(new Book("Hamilton: The Revolution", "Lin-Manuel Miranda", "1455539740"));
		
		for(int i = 0; i < books.size(); i++){
			System.out.println(books.get(i));
		}
	}

}
