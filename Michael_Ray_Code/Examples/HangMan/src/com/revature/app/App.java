package com.revature.app;

import java.util.List;

import com.revature.io.FileIO;
import com.revature.io.HangMan;

public class App {
public static void main(String[] args) {
	//Blocks.Test();
	//Blocks b = new Blocks();
	//Blocks c = new Blocks();
	//Person p = new Person("karen", "she has thechildren@gmail.com");
	//FileIO driver = new FileIO();
	
	// HangMan Game
	List<String> words = FileIO.ReadFile("src/com/revature/io/text.txt");
	HangMan hang = new HangMan(words);
	hang.StartNewGame();	
}
}
