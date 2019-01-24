package com.revature.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {

	static String filepath = "src/com/revature/io/words.txt";
	public static void main(String[] args) {
		System.out.println(getWord());
		
		//System.out.println("Welcome, you have 5 guesses");
		//guess(getWord(), 5);
	}
	
	static void guess(String word, int num) {
		ArrayList<String> wrong = new ArrayList<String>();
		char[] guessed = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			guessed[i] = '_'; 
		}
		
		Scanner s = new Scanner(System.in);
		while (!String.valueOf(guessed).equalsIgnoreCase(word) && num != 0) {
			print(guessed);
			System.out.println("Guess a letter");
			String letter = s.nextLine();
			if (word.contains(letter)) {
				for (int i = 0; i < guessed.length; i++) {
					if (word.charAt(i) == letter.charAt(0)) {
						guessed[i] = letter.charAt(0);
					}
				}
			}
			else
			{
				num--;
				
				wrong.add(letter);
				System.out.println("You guess is wrong [" + wrong + "]");
			}
		}
		
		if (!String.valueOf(guessed).equalsIgnoreCase(word)) {
			System.out.println("You ran out of guesses. The word was " + word);
		} else {
			System.out.println("Win");
		}
		
	}
	
	static void print(char[] letters) {
		String out = "";
		for (char c : letters)
		{
			out += c + "";
		}
		System.out.println(out);
	}
	
	static String getWord() {
		List<String> words = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(
				new FileReader(filepath))) {
			String currentLine = null;
			while((currentLine = br.readLine()) != null) {
				words.add(currentLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int index = (int)(Math.random() + words.size() - 1);
		
		return words.get(index);
	}
}
