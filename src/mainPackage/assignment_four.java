package mainPackage;

import java.io.*;
import java.util.*;

public class assignment_four {

	public static void main(String[] args) {
		
		ArrayList<Double> newData = new ArrayList<Double>(); // Declaring newData ArrayList.
		
		newData = ReadFile(newData); // Calling ReadFile to save all Strings in text file to doubles into ArrayList newData therefore initializing it.
		
		System.out.println("Unsorted data: " + newData); // Unsorted data.
		
		Collections.sort(newData); // This method sorts the ArrayList from small to big.
		
		System.out.println("Sorted data: " + newData); // This is the updated and organized ArrayList.
		
		WriteFile(newData); // This function writes the organized ArrayList newData to a new text file.
		
		System.out.println("\nTransfer Complete!"); // Update.
		
	}
	
	public static ArrayList<Double> ReadFile(ArrayList<Double> newData) { // Function for reading file and storing data in an array for sorting.
				
		double stringToDouble = 0; // Holder for doubles.
		
		try { // Need to encapsulate try and catch in order to use BufferedReader to catch errors.
			
			BufferedReader reader = new BufferedReader(new FileReader("inputs/data.txt")); // Opens the text file data.txt.
			String line; // Need this for the while loop in order to get to EOF.
			
			while((line = reader.readLine()) != null) { // While loop to go through data.txt, convert all data from Strings to Double and add them to ArrayList newData.
				
				stringToDouble = Double.parseDouble(line);
				newData.add(stringToDouble);
				
			}

			reader.close(); // Need this to close file, if not error will occur. Also it is good practice anyways, remember this from C programming.
			
		} catch (IOException e) {
			
			System.out.println("Error!"); // Prints Error on screen if error occurs.
			
		}
		
		return newData; // Returns the ArrayList to main function.
		
	}
	
	public static void WriteFile(ArrayList<Double> newData) { // Function to write the new data to a new text file.
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("outputs/data-sorted.txt")); // Creates data-sorted.txt, if already created then will overwrite whatever is in there.
			
			for(int x = 0; x < newData.size(); x++) { // For loop to go through newData and export the sorted data to new file.
				writer.write(Double.toString(newData.get(x)) + "\n"); // Converts the double to string and stores it in text file.
				
			}
			
			writer.close(); // Closes file.
			
		} catch (IOException e) {
			
			System.out.println("Error!");
			
		}
		
	}
	
}
