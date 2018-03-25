/*****************************************************
 *Name: Ben Tenhover
 *Assignment: Assignment 07
 *Due Date: 3/22/2018
 *Course/Section/Semester: 2045C/002/Spring 2018
 *Email: tenhovbe@mail.uc.edu
 *Citations: StackOverFlow.com, my textbook, CodingRanch, textbook, in-class work
 *Description: Read from the given file and determine the longest word, the letter that appears the most 
 *and the least and the average word size of the file.
 */
package fileContents;

import java.io.IOException;

/**
 * Main Class for to demonstrate the methods in the FileContents Class
 * @author Ben Tenhover
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {

	FileContents fc = new FileContents(); // Declare and instantiate the FileContents object named fc
	fc.getLongestWords();  // Calls the method that determines the longest word in the file
	fc.getMostUsedLetter(); // Calls the method that determines the letter that appears the most in the file
	fc.getLeastUsedLetter(); // Calls the method that determines the letter that appears the least in the file
	fc.getAverageLength(); // Calls the method that determines the average word length of the file
	}
}

