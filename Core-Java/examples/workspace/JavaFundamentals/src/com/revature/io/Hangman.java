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
		System.out.println("Welcome to Hangman! You have 5 incorrect guesses before you looooooooooooose");
		guess(getWord(), 5);
	}

	static void guess(String word, int numGuesses) {
		Set<String> wrong = new HashSet<String>();
		char[] guessed = new char[word.length()];
		for(int i = 0; i < word.length(); i++) {
			guessed[i] = '_';
		}
		Scanner scan = new Scanner(System.in);

		while(numGuesses>0 && !String.valueOf(guessed).equalsIgnoreCase(word)) {
			print(guessed);
			System.out.println("Guess a letter");
			String letter = scan.nextLine();
			//SHOULD be doing user input validation 


			if(word.contains(letter)) {
				//replace _ with letter
				for(int i = 0; i < guessed.length; i++) {
					if(word.charAt(i)==letter.charAt(0)) {
						guessed[i] = letter.charAt(0);
					}
				}
			}
			else {
				//user guessed incorrectly 
				numGuesses--;
				wrong.add(letter);
				Arrays.sort(wrong.toArray());
				System.out.println("WRONG! Your incorrect "
						+ "guesses thus far are " + wrong.toString() + " and you have " + numGuesses + " left");
			}
		}

		if(numGuesses!=0) {
			System.out.println("Congrats! You win. Your word was "+ word);
		}
		else {
			System.out.println("You didn't guess in time! Your word was " + word);
		}
	}

	static void print(char[] letters) {
		String out = "";
		for(char c : letters) {
			out += c + " "; 
		}
		System.out.println(out);
	}

	static String getWord() {
		List<String> words = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(
				new FileReader(filepath))){
			String currLine = null;
			while((currLine=br.readLine())!=null) {
				words.add(currLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int index = (int) (Math.random() * words.size()-1);

		return words.get(index);
	}


}
