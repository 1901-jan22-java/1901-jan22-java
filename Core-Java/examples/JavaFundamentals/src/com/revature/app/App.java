package com.revature.app;

import com.revature.io.FileIO;
import com.revature.pojos.Person;

public class App {

	public static void main(String[] args) {
//		Person p = new Person("Malika", "m@revature.com");
	FileIO driver = new FileIO();
//		driver.writeObj(p);
		System.out.println(driver.readObj());
		
	}

}
