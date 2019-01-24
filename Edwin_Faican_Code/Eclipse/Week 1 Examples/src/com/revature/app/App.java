package com.revature.app;

import com.revature.fileio.FileIO;
import com.revature.pojos.Person;

public class App {
	public static void main(String[] args) {
		Person p = new Person("Faian", "no@no.com");
		FileIO driver = new FileIO();
		driver.writeObj(p.toString());
		
		//System.out.println(driver.readObj());
	}
}
