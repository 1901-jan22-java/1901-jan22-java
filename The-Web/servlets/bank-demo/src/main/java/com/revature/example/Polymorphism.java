package com.revature.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Polymorphism {
	public static void main(String[] args) {
		
		assert(args.length == 0);
		System.out.println("reached end of method");
		
		B b = new B();
		
		A a =  b;
		
		A c = new A();
		B d = (B) c;
		
		Object obj = null;
		String str = (String) obj;
		
	}
}


class A{
	Object test() throws IOException{
		return null;
		
	}
}

class B extends A{
	@Override
	String test() throws FileNotFoundException, RuntimeException{
		return null;
		/*
		 * When throwing checked exceptions from a method, an
		 * overriding method must throw either that exception or 
		 * a subclass of it, or no exception at all 
		 * it cannot throw a more generic exception and still be 
		 * considered overriding 
		 * but it can throw any RuntimeException
		 */
	}
	
	
	
}