package com.revature.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Hangman {
	
	
	private String filepath;
	private final ArrayList<String> words = new ArrayList<String>();
	
	private char[] word;
	private String wordString;

	private final ArrayList<Integer> scores = new ArrayList<>();
	
	
	
	public Hangman() {
		this.filepath = "src/com/revature/words_alpha.txt";
		readFile();
	}
	
	public Hangman(String filepath) {
		this.filepath = filepath;
		readFile();
	}
	
	
	
	private void readFile(){
		try ( BufferedReader br = new BufferedReader(new FileReader(this.filepath)) ) {
			String line = null;
			while( ( line = br.readLine()) != null ) {
				words.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getRandomWord() {
		int n = (int) (Math.random() * words.size() - 1);
		return words.get(n);
	}
	
	public void begin() {
		wordString = getRandomWord();
		word = wordString.toCharArray();
		System.out.println(wordString + " " + String.valueOf(word));
		
	}
	
	public void game() {
		begin();
		
		int incorrect = 0;
		Set<Character> wrong = new TreeSet<>();
		
		char[] guessed = new char[word.length];
		for(int i = 0; i < word.length; i++)
			guessed[i] = '_';
		
		try ( Scanner s = new Scanner(System.in) ){
			boolean correct = false;
			String wordPrint = format(guessed);
			for(; !isCorrect(String.valueOf(guessed)) ;) {
				if(correct) wordPrint = format(guessed);
				System.out.println("Wrong Guesses: " + wrong.toString());
				System.out.println("Word: " + wordPrint);
				System.out.print("Guess a letter or word: ");
				String line = s.nextLine();
				
//				if( isCorrect(line) ) {
//					
//				} else {
				
				char c = line.charAt(0);
				correct = wordString.contains( ""+Character.toLowerCase(c) );
				if(correct) {
					System.out.println("Correct Letter!");
					for(int i = 0; i < word.length; i++) {
						if(word[i] == c) {
							guessed[i] = word[i];
						}
					}
				} else {
					System.out.println("Wrong Letter!");
					wrong.add(c);
					incorrect++;
				}
//				}
			}
		}
		
		scores.add(word.length - incorrect);
	}
	
	public boolean isCorrect(String str) {
		return wordString.equalsIgnoreCase(str);
	}
	
	public static String format(char[] a) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < a.length; i++) {
			sb.append(a[i]);
			if(i!=a.length-1) sb.append(" ");
		}
		return sb.toString();
	}
	
}
