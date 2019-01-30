package com.revature.assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Question 20
 * 
 * @author Sanford
 *
 */

public class DataReader<T extends Data> {
	
	private ArrayList<T> data;
	private String filepath;

	public DataReader() {
		filepath =  "src/com/revature/Data.txt";
	}
	
	public static <T extends Data> ArrayList<T> readPersonData(String filepath) {
		
		ArrayList<T> dataSet = new ArrayList<>();
		try ( BufferedReader br = new BufferedReader(new FileReader(filepath)) ) {
			
			for(String s = br.readLine(); s != null ; s = br.readLine()) {
				String[] info = s.split(":");
//				Data p = new T();
//				dataSet.add(p);
			}
			
		} catch ( IOException e ) {
//			e.printStackTrace();
		}
		
		return dataSet;
	}
	
}

class PersonData implements Data {
	
	private String name;
	private int age;
	private String state;
	
	public PersonData(){
		super();
	}
	
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

class DataReaderTest {
	
	public static void main(String[] args) {
		PersonData pd = new PersonData();
		System.out.println( pd.thisClass() );
		System.out.println( Arrays.asList(pd.thisClass().getFields()) );
		System.out.println( Arrays.asList(pd.thisClass().getDeclaredFields()) );
		Data d = (Data) pd;
		System.out.println( d.thisClass() );
		System.out.println( Arrays.asList(d.thisClass().getFields()) );
		System.out.println( Arrays.asList(d.thisClass().getDeclaredFields()) );
	}
	
}
