package com.revature.app;

import java.util.Date;

public class HW14_SwitchCase {
	enum Choices{
		SquareRoot,
		Date,
		SplitString
	}
public static void main(String[] args) {
	Choices myChoice = Choices.SplitString;
	
	switch(myChoice){
	case SquareRoot:{
		int sqrtNum = 37;
		double num = Math.sqrt(sqrtNum);
		System.out.println("You chose Square Root option");
		System.out.println("Square Root of (" + sqrtNum + ") is ~ " + num);
		break;
	}
	case Date:{
		Date theDay = new Date();
		System.out.println("You chose to get Todays Date");
		System.out.println("Today's date is: " + theDay.toString());
		break;
	}
	case SplitString:{
		String sentence = "I am learning Core Java";
		System.out.println("You chose to Split a String");
		System.out.println("The sentence to split is '" + sentence + "'\n");
		
		String[] arr = sentence.split(" ");
		
		System.out.println("Here is the new split string:");
		
		for(String s : arr){
			System.out.print(s + ", ");
		}
		
		break;
	}
	}
}
}
