package com.revature.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangMan {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.println("Hello fellow human! Want to play a game? (Y/N)");
		String desire = console.nextLine();
		if(desire.equalsIgnoreCase("y")) {
			gameStart(console);
		} else if(desire.equalsIgnoreCase("n")) {
			System.out.println("Human, do not be rude.");
		} else {
			System.out.println("Cannot compute your human speech. I believe I was clear in my options... I'll find someone better to play with");
		}
	}
	
	public static void gameStart(Scanner console) {
		String filepath = "src/com/revature/fileio";
		
		guess(getWord(filepath), console);
	}
	
	public static String getWord(String filepath) {
		List<String> word = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			String currLine = null;
			while((currLine = br.readLine()) != null) {
				word.add(currLine);
			}
			int index = (int) (Math.random()*word.size()-1);
			return word.get(index);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void guess(String word, Scanner console) {
		String wrong = "";
		char[] guesses = new char[word.length()];
		
		for(int i=0; i<word.length(); i++) {
			guesses[i] = '_';
		}
		
		while(!String.valueOf(guesses).equalsIgnoreCase(word)) {
			print(guesses);
			System.out.println("Enter a guess letter!");
			String guess = console.nextLine();
			if(guess.length() == 1 && word.contains(guess)) {
				for(int i=0; i<guesses.length; i++) {
					if(word.charAt(i) == guess.charAt(0)) {
						guesses[i] = guess.charAt(0);
						System.out.println("Impressive, human! That guess was correct. Keep Going. ");
					}
				}
			} else {
				wrong = wrong + guess + ", ";
				System.out.println("Incorrect, human! These are your laughably incorrect guesses so far: " + wrong.substring(0, wrong.length()-2));
			}
		}
	}
	
	public static void print(char[] l) {
		String out = "";
		for(char c : l) {
			out = c + " "; 
		}
		System.out.println(out);
	}
}
