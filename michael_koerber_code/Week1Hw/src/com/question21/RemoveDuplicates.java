package com.question21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RemoveDuplicates {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String str = buffer.readLine(); // Read a string from the user
		System.out.println(removeDuplicateChars(str));
	}
	
	private static String removeDuplicateChars(String string) {
        char[] charArray = string.toCharArray(); // add each letter of the string to a character array to iterate over each of them
        String newString = ""; //create new string to add characters to
 
        for (char character : charArray) { // for each loop to check each character in the array
            if (newString.indexOf(character) == -1) { // if the character being iterated over is not in the newString
                newString += character;//  add the character to the new string.
            }
        }
        return newString;
    }
}
