package com.revature.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman 
{
	static String filepath = "src/com/revature/io/Words.txt";

	public static void main(String[] args)
	{
		//System.out.println(getWord());
		System.out.println("Welcome to hangman, you have 5 incorrect guesses.");
		guess(getWord());
	}
	
	static void guess(String word)
	{
		char[] guessed = new char[word.length()];
		for(int i = 0; i < word.length(); i++)
		{
			guessed[i] = '_';
		}
		Scanner scan = new Scanner(System.in);
		String wrong = "";
		while(!String.valueOf(guessed).equalsIgnoreCase(word));
		{
			print(guessed);
			System.out.println("Guess a letter");
			String letter = scan.nextLine();
			if(word.contains(letter))
			{
				//Replace _ with letter
				for(int i = 0; i < guessed.length; i++)
				{
					if(word.charAt(i) == letter.charAt(0))
					{
						guessed[i] = letter.charAt(0);
					}
				}
			}
			else
			{
				//user guessed incorrectly
				wrong += letter + ", ";
				System.out.println("Wrong, your incorrect guesses are: " + wrong.substring(0, wrong.length() - 2));
			}
		}
	}
	
	static void print(char[] letters)
	{
		String out = "";
		for(char c : letters)
		{
			out += c + " ";
		}
		System.out.println(out);
	}
	
	static String getWord()
	{
		List<String> words = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(filepath)))
		{
			String currLine = null;
			while((currLine=br.readLine()) != null)
			{
				words.add(currLine);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		int index = (int)(Math.random() * words.size() - 1);
		return words.get(index);
	}
}
