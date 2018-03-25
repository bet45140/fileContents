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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Contents of the given file, including average word length, the letter that appears the most and least, and the longest word in the file
 * @author Ben Tenhover
 *
 */
public class FileContents {

	/**
	 * @return returns the most used letter in the specified file
	 * @throws FileNotFoundException
	 */
	public void getMostUsedLetter() throws FileNotFoundException {
		TreeMap<Character, Integer> hashMap = new TreeMap<Character, Integer>(); // Declare and instantiate the TreeMap object named hashMap.
		File file = new File("words.txt"); // Declare and instantiate the File object named file
		Scanner in = new Scanner(file,"utf-8");// Declare and instantiate the Scanner object named in


		while (in.hasNext()) {
			char[] chars = in.nextLine().toLowerCase().toCharArray(); // Changes all letters to lowercase
			for (Character c : chars) {
				if(!Character.isLetter(c)){
					continue;
				}
				else if (hashMap.containsKey(c)) {
					hashMap.put(c, hashMap.get(c) + 1);
				} else {
					hashMap.put(c, 1);
				} // This loop counts every letter in the file
			}
		}

		for (Map.Entry <Character, Integer> entry : hashMap.entrySet()) {
			int maxValue = (Collections.max(hashMap.values()));  // This will return maximum value in the Hashmap, which is the letter that appears the most
			if (entry.getValue() == maxValue) 
			{
				System.out.println("The letter that appears the most in this file is " +  entry.getKey() + ""
						+ ", which appears " + entry.getValue() + " times."); // Prints a message displaying the letter that appears the most, as well as how many times it appears
			}

		}
	}

	/**
	 * @return Returns the least used letter in the specified file
	 * @throws FileNotFoundException
	 */
	public void getLeastUsedLetter() throws FileNotFoundException {
		TreeMap<Character, Integer> hashMap = new TreeMap<Character, Integer>();
		File file = new File("words.txt");// Declare and instantiate the File object named file
		Scanner in = new Scanner(file,"utf-8");// Declare and instantiate the Scanner object named in


		while (in.hasNext()) {
			char[] chars = in.nextLine().toLowerCase().toCharArray(); // Changes all letters to lowercase
			for (Character c : chars) {
				if(!Character.isLetter(c)){
					continue;
				}
				else if (hashMap.containsKey(c)) {
					hashMap.put(c, hashMap.get(c) + 1);
				} else {
					hashMap.put(c, 1);
				} // This loop counts every letter in the file
			}
		}

		for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
			int minValue = (Collections.min(hashMap.values()));  // This will return minimum value in the Hashmap, which is the letter that appears the least
			if (entry.getValue() == minValue) 
			{
				System.out.println("The letter that appears the least in this file is " +  entry.getKey() + ""
						+ ", which appears " + entry.getValue() + " times."); // Prints a message displaying the letter that appears the least, as well as how many times it appears
			}

		}
	}

	/**
	 * @return Returns the longest word in the specified file
	 * @throws FileNotFoundException
	 */
	public void getLongestWords() throws FileNotFoundException {

		String longestWord = ""; 
		String current; // Current word being checked
		Scanner in = new Scanner(new File("words.txt"));// Declare and instantiate the Scanner object named in

		while (in.hasNext()) {
			current = in.next();
			if (current.length() > longestWord.length()) {
				longestWord = current; // Returns the longest word in the file
			}

		}
		System.out.println("The longest word in this file is " + longestWord + "."); // Prints a message displaying the longest word in the file

	}

	/**
	 * @return Returns the average word length of the specified file
	 * @throws FileNotFoundException
	 */
	public void getAverageLength() throws FileNotFoundException {

		File file = new File("words.txt"); // Declare and instantiate the File object named file
		try(Scanner in = new Scanner(new FileInputStream(file))){
			int wordCount  = 0; // Declares the int wordCount to start at 0.
			while(in.hasNext()){
				in.next();
				wordCount++; // Determines the total number of words in the file
			}
			String fileContent = new Scanner(new File("words.txt")).useDelimiter("\\Z").next(); // Convert the file content into a string
			int letterCount = fileContent.length(); // Determines the total number of letters in the file
			double avgWordLength = letterCount / wordCount; // Calculates the average word length of the file

			System.out.printf("The average word length in letters of this file is " + "%.2f" ,avgWordLength); // Prints a message displaying the average word length to 2 decimal places
		}
	}
}


