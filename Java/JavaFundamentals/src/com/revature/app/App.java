package com.revature.app;

import com.revature.classbasics.NestedClasses;

public class App {
	@SuppressWarnings("unused")
	public static void main(String[] args) {	
		NestedClasses.StaticClass sc = new NestedClasses.StaticClass();
		
		NestedClasses nested = new NestedClasses();
		
		NestedClasses.InstanceClass i = nested.new InstanceClass() ;
		
	}
}
