package com.revature.app;

import com.revature.classbasics.Blocks;
import com.revature.io.FileIO;
import com.revature.pojos.Person;
import com.revature.classbasics.*; //imports all classes w/in package 
//not other classes in sub-packages

public class App {
	
	public static void main(String[] args) {
		/*
		 * Blocks.test(); // can access test method in Blocks by importing // can do
		 * without writing by writing out 'full name' - package
		 * 
		 * Blocks b = new Blocks(); Blocks c = new Blocks();
		 */		
		/*
		 * Person p = new Person("Victoria Wood", "vwood@gm.slc.edu"); FileIO driver =
		 * new FileIO(); driver.writeObj(p);
		 */	
		
		
		NestedClasses.StaticClass sc = new NestedClasses.StaticClass();
		sc.message();
	}

}
