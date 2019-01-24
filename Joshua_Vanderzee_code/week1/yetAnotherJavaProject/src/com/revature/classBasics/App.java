package com.revature.classBasics;

import com.revature.IO.FileIO;
import com.revature.pojos.Person;

public class App {

	public static void main(String[] args) {
		Person p = new Person("James", "james@mail.com");
		FileIO driver = new FileIO();
		driver.writeObject(p);
		System.out.println(driver.readObj());
	}

}
