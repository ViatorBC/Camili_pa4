package problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {

	Map<String, Integer> wordCounter;
	
	void count(String dataFile) {
		// make a scanner object for the input file
		Scanner inputFile = null;
		// make wordCounter into a hash map
		wordCounter = new HashMap<String, Integer>();
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
		while(inputFile.hasNext()){
			// learned i could split words this way a little late not gonna fix the other one 
			String line = inputFile.next();
			// if the word isnt null and it isnt empty then we make it capitalized and check if it already exists in the map
			// if it does we increase the counter, otherwise we just put it in the map with the value of 1. 
			if(line != null && line.isEmpty() == false) {
				line = line.toUpperCase();
				if( wordCounter.containsKey(line)) {
					wordCounter.put(line, wordCounter.get(line) + 1);
				}
				else {
					wordCounter.put(line, 1);
				}
			}
		}
		inputFile.close();
	}
	
	void write(String outputFile) {
		FileWriter outputWriter;
		try {
			// make outputWriter a new file writer object with the output file highlighted 
			outputWriter = new FileWriter(outputFile);
			// for loop to go through each member of the map and put them in a text file in a list separated by spaces.
			for(Map.Entry<String, Integer> entry: wordCounter.entrySet()) {
				outputWriter.write(entry.getKey() + "  " + entry.getValue() + "\\  ");
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
