package com.revature.question11;

//import from another package that has a class FinalFantasy, which just holds two floats
import com.revature.q11part2.*;

public class Question11{
	/*
	 * access two float-variables from a class that exists in another package
	 * */

	public static void main(String[] args)
	{
		//making a FinalFantasy class of myFloats, constructing with two floats
		FinalFantasy myFloats = new FinalFantasy(2.2f, 2.1f);
		
		System.out.println("Number 1 " + myFloats.getNumber1());
		System.out.println("Number 2 " + myFloats.getNumber2());
		System.out.println("Changing value of Number 2 to 69");
		myFloats.setNumber2(69f);
		System.out.println("Number 2 " + myFloats.getNumber2());
	}
	
	
}
