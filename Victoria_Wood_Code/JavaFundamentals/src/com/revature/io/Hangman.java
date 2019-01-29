package com.revature.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Hangman {
	static String filepath = "src/com/revature/io/words.txt";
	
	public static void main(String[] args) {
		System.out.println("Welcome to Hangman!");
		guess(getWord());
				
	}

	
	static void print(char[] letters) {
		String out = "";
		for(char c: letters) {
			out += c + " ";
		}
		System.out.println(out);
	}

	
	
	static void guess(String word) {
		int numGuesses = 0;
		Set<String> wrong = new HashSet<String>();
		char[] guessed = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			guessed[i] = '_';
		}
		Scanner scan = new Scanner(System.in);
		while(!String.valueOf(guessed).equalsIgnoreCase(word) & numGuesses <= 5) {
			print(guessed);
			System.out.println("Guess a letter");
			String letter = scan.nextLine();
			if(word.contains(letter)) {
				//replace _ with letter
				for( int i = 0; i <guessed.length; i ++) {
					if(word.charAt(i) == letter.charAt(0)) {
						guessed[i] =letter.charAt(0);
					}
				}
			}else {
				//user guess incorrectly
				wrong.add(letter);
				Arrays.sort(wrong.toArray());
				numGuesses += 1;
				System.out.println("WRONG! Your incorrect guesses so far are:" 
						+ wrong.toString());
			}
			
		}
		if (numGuesses > 5) {
			System.out.println("You ran out of guesses, you lose!");
		} else {
			System.out.println("Congrats! You win!");
		}

	}
	
	
	static String getWord() {
		List<String> words = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader( new FileReader(filepath))){
			String currLine = null;
			while((currLine=br.readLine()) != null) {
				words.add(currLine);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		int index = (int) (Math.random() * words.size()-1);
		return words.get(index);
	}
}
