package com.revature.assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Question 20
 * 
 * @author Sanford
 *
 */

public class DataReader {
	
	public static void main(String[] args) {
		String filepath = "src/com/revature/Data.txt";
		System.out.println(readPersonData(filepath));
	}
	
	public static ArrayList<PersonData> readPersonData(String filepath) {
		
		ArrayList<PersonData> people = new ArrayList<>();
		try ( BufferedReader br = new BufferedReader(new FileReader(filepath)) ) {
			
			for(String s = br.readLine(); s != null ; s = br.readLine()) {
				String[] info = s.split(":");
				PersonData p = new PersonData( info[0], info[1], info[2], info[3] );
				people.add(p);
			}
			
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		
		return people;
		
	}
	
}

class PersonData {
	
	private String name;
	private int age;
	private String state;
	
	public PersonData(String name, int age, String state){
		this.name = name;
		this.age = age;
		this.state = state;
	}
	
	public PersonData(String firstName, String lastName, int age, String state){
		this.name = firstName + " " + lastName;
		this.age = age;
		this.state = state;
	}
	
	public PersonData(String name, String age, String state){
		this.name = name;
		this.age = Integer.parseInt(age);
		this.state = state;
	}
	
	public PersonData(String firstName, String lastName, String age, String state){
		this.name = firstName + " " + lastName;
		this.age = Integer.parseInt(age);
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "\n{\n\tName: " + name + "\n" +
				"\tAge: " + age + " years\n" +
				"\tState: " + state + " state\n}";
	}
	
}