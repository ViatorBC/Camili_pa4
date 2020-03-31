package problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
	// making the set called unique words
	Set<String> uniqueWords;
	
	void remove(String dataFile) {
		// scanner called input file 
		Scanner inputFile = null;
		// make unique words a linked hash set so that each word can only be in once
		uniqueWords = new LinkedHashSet<>();
		
		// eclipse kept yelling at me to either do try catch or throw an exception and the problem said not to throw the exception 
		try {
			// making inputFile a scanner for a new File object that is our data file
			inputFile = new Scanner(new File(dataFile));
		}
		catch (FileNotFoundException e) {
			// if you have no problem1.txt you get a sad face because well thats not cool.
			System.out.println("No file Found :(");
		}
		// make a while loop till the end of the file 
		while(inputFile.hasNextLine()){
			// make a string for a new line as it is being made 
			String line = inputFile.nextLine();
			// split the words into different springs
			String[] words = line.split(" ");
			// for loop for each words length to set it to a capitalized version because all 
			// computer scientists use capitals so i have too as well. 
			for(int i = 0; i <words.length; i++) {
				String str = words[i].toUpperCase();
				// add each string to the hash set
				uniqueWords.add(str);
			}
		inputFile.close();
		}
	}
	
	void write(String outputFile) {
		FileWriter outputWriter;
		// eclipse yelled at me because if there wasnt a file it would literally scream
		try {
			// make outputWriter a new file writer object with the output file highlighted 
			outputWriter = new FileWriter(outputFile);
			// for loop to go through each member of the set and put them in a text file in a list separated by spaces.
			for(String str:uniqueWords) {
				outputWriter.write(str+" ");
			}
			// close the output writer (the compiler yelled at me)
			outputWriter.close();		
		} 
		catch (IOException e) {
			// the compiler would have screamed if i didn't put this in so now i'm sad
			System.out.println("No file Found :(");
		}
	}
	
	
}
