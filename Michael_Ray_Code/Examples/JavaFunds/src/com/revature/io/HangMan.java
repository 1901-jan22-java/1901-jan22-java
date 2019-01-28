package com.revature.io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HangMan {

	Scanner scan;
	private List<String> currentWordPool;
	private Set<String> worngLetters;
	private Set<String> rightLetters;
	private String[] currentWord;
	private String guessedWord = "";
	private String myGuess = "";
	public boolean gameFinished = false;
	private boolean hit = false;
	private int wrongAnswers = 0;
	private int numOfLetters = 0;
	private int curRightGuessedLetters = 0;
	
	{
		scan = new Scanner(System.in);
		currentWordPool = new ArrayList<String>();
		worngLetters = new HashSet<String>();
		rightLetters = new HashSet<String>();
	}
	public HangMan(){
		
	}
	public HangMan(List<String> words){
		currentWordPool = words;
	}
	
	public void StartNewGame(){
		currentWord = GetNewWord();
		guessedWord = "";
		numOfLetters = 0;
		curRightGuessedLetters = 0;
		for(String word : currentWord){
			numOfLetters += word.length();
			for(int i = 0; i < word.length(); i++){
				guessedWord += "_ ";
			}
			guessedWord += " ";
		}
		gameFinished = false;
		wrongAnswers = 0;
		
		Draw();
		
		
		while(!gameFinished)
		{
			Update(scan.nextLine());
		}
	}
	public void Update(String guess){
						
		hit = false;
		
				
		if(guess.length() > 0){
			myGuess = guess;
			UpdateGuessedWord();
			if(!hit){
				AddToWrong("" + guess.charAt(0));
				wrongAnswers++;
			}
		}
		
		
		
		Draw();
		
		if(wrongAnswers == 7){
			gameFinished = true;
			System.out.println("You LOST!");
			System.out.print("The word was: ");
			PrintWord();
		}
		else if(curRightGuessedLetters == numOfLetters){
			gameFinished = true;
			System.out.println("You WON!");
		}
		//System.out.println(currentWord[0]);
	}
	void PrintWord(){
		for(String word : currentWord){
			System.out.print(word + " ");
		}
	}
	void UpdateGuessedWord(){
		String newGuessedWord = "";
		int count = 0;
		for(String word : currentWord){
			for(int i = 0; i < word.length(); i++){
				
				if(word.charAt(i) == myGuess.charAt(0)){
					newGuessedWord += myGuess.charAt(0) + " ";
					if(!rightLetters.contains("" + myGuess.charAt(0))){
						curRightGuessedLetters++;
					}
					hit = true;
				}
				else{
					newGuessedWord += guessedWord.charAt(count) + " ";
				}
				count += 2;		
			}
			count++;
			newGuessedWord += " ";
		}
		
		if(hit){
			rightLetters.add("" + myGuess.charAt(0));
		}
		guessedWord =  newGuessedWord;
	}
	void AddToWrong(String wrong){
		worngLetters.add(wrong);
	}
	void Draw()
	{
		DrawHangMan();
		System.out.println();
		DrawGuessWord();
		System.out.println();
		DrawWrongLetters();
		System.out.println();
	}
	void DrawGuessWord(){
		
		System.out.println(guessedWord);
		
	}
	void DrawWrongLetters(){
		System.out.println("Wrong Letters: ");
		for(String wrong : worngLetters){
			System.out.print(wrong + ",");
		}
	}
	void DrawHangMan(){
		switch(wrongAnswers){
		case 0:{
			System.out.println("      ------");
			System.out.println("      |    |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("------------");
			break;
		}
		case 1:{
			System.out.println("      ------");
			System.out.println("      |    |");
			System.out.println("    (-_-)  |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("------------");
			break;
		}
		case 2:{
			System.out.println("      ------");
			System.out.println("      |    |");
			System.out.println("    (-_-)  |");
			System.out.println("      |    |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("------------");
			break;
		}
		case 3:{
			System.out.println("      ------");
			System.out.println("      |    |");
			System.out.println("    (-_-)  |");
			System.out.println("     /|    |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("------------");
			break;
		}
		case 4:{
			System.out.println("      ------");
			System.out.println("      |    |");
			System.out.println("    (-_-)  |");
			System.out.println("     /|\\   |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("------------");
			break;
		}
		case 5:{
			System.out.println("      ------");
			System.out.println("      |    |");
			System.out.println("    (-_-)  |");
			System.out.println("     /|\\   |");
			System.out.println("      |    |");
			System.out.println("           |");
			System.out.println("           |");
			System.out.println("------------");
			break;
		}
		case 6:{
			System.out.println("      ------");
			System.out.println("      |    |");
			System.out.println("    (-_-)  |");
			System.out.println("     /|\\   |");
			System.out.println("      |    |");
			System.out.println("     /     |");
			System.out.println("           |");
			System.out.println("------------");
			break;
		}
		case 7:{
			System.out.println("      ------");
			System.out.println("      |    |");
			System.out.println("    (-_-)  |");
			System.out.println("     /|\\   |");
			System.out.println("      |    |");
			System.out.println("     / \\   |");
			System.out.println("           |");
			System.out.println("------------");
			break;
		}
		}
	}
	
	String[] GetNewWord(){
		int wordNum = (int)(Math.random() * (double)currentWordPool.size());
		
		String word = currentWordPool.get(wordNum);
		
		return word.split(" ");
	}

	
	public void LoadWordPool(List<String> words){
		currentWordPool = words;
	}
}
