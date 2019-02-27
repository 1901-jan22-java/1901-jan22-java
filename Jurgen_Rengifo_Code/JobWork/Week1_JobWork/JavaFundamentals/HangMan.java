package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HangMan {
	static String filepath = "src/com/revature/io/words.txt";
	public static void main(String[] args) {
		System.out.println("Welcome to hangman");
		guess(getWord());
	}
	static void guess(String word) {
		// TODO Auto-generated method stub
		String wrong = "";
		char[] guessed = new char[word.length()];
		for(int i = 0; i < word.length(); i++) {
			guessed[i] = '_';
		}
		while(String.valueOf(guessed).equalsIgnoreCase(word)) {
			
		}
		static void print(char[] letters) {
			String out = "";
			for(char c : letters) {
				
			}
		}
	}
	static String getWord() {
		List<String> words = new ArrayList<String>();
		try(BufferedWriter br = new BufferedWriter(new FileWriter(filepath))){
			String currLine = null;
			while((currLine=br.readLine()!=null)) {
				words.add(currLine);
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int index = (int) (Math.random())
		return null;
	}
}
