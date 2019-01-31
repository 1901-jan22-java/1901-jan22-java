package com.revature.assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Question 20
 * 
 * @author Sanford
 *
 */

public class DataReader {
	
	private static final String defaultPath = "src/com/revature/Data.txt";
	
	private ArrayList<PersonData> data;
	private String filepath;

	public DataReader() {
		filepath = defaultPath;
		readPersonDataIntoDataReader();
	}
	
	public DataReader(String filepath) {
		if( filepath.isEmpty() ) this.filepath = defaultPath;
		else this.filepath = filepath;
		readPersonDataIntoDataReader();
	}
	
	public void readPersonDataIntoDataReader() {
		data = readPersonData();
	}
	
	public ArrayList<PersonData> readPersonData(){
		return readPersonData(filepath);
	}
	
	public static ArrayList<PersonData> readPersonData(String filepath) {
		
		ArrayList<PersonData> dataSet = new ArrayList<>();
		try ( BufferedReader br = new BufferedReader(new FileReader(filepath)) ) {
			
			for(String s = br.readLine(); s != null ; s = br.readLine()) {
				String[] info = s.split(":");
				PersonData p = new PersonData(info[0], info[1], info[2], info[3]);
				dataSet.add(p);
			}
			
		} catch ( IOException e ) {
//			e.printStackTrace();
		}
		
		return dataSet;
	}

	public ArrayList<PersonData> getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
}

class PersonData implements Data {
	
	private String name;
	private int age;
	private String state;
	
	public PersonData() {
		super();
	}
	
	public PersonData(String name, int age, String state) {
		this.name = name;
		this.age = age;
		this.state = state;
	}
	
	public PersonData(String firstName, String lastName, int age, String state) {
		this.name = firstName + " " + lastName;
		this.age = age;
		this.state = state;
	}
	
	public PersonData(String name, String age, String state) {
		this.name = name;
		this.age = Integer.parseInt(age);
		this.state = state;
	}
	
	public PersonData(String firstName, String lastName, String age, String state) {
		this.name = firstName + " " + lastName;
		this.age = Integer.parseInt(age);
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "{\n\tName: " + name + "\n" +
				"\tAge: " + age + " years\n" +
				"\tState: " + state + " state\n}";
	}
	
}

class DataReaderTest {
	private static final String[] expected = {
		"[{\n" +
			"\tName: Mickey Mouse\n" + 
			"\tAge: 35 years\n" + 
			"\tState: Arizona state\n" + 
			"}, {\n" + 
			"\tName: Hulk Hogan\n" + 
			"\tAge: 50 years\n" + 
			"\tState: Virginia state\n" + 
			"}, {\n" + 
			"\tName: Roger Rabbit\n" + 
			"\tAge: 22 years\n" + 
			"\tState: California state\n" + 
			"}, {\n" + 
			"\tName: Wonder Woman\n" + 
			"\tAge: 18 years\n" + 
			"\tState: Montana state\n" + 
		"}]"
	// Example format for future strings
//	,
//		"[" +
//			"\t" +
//		"]"
	};
	private DataReader[] dr;
	
	@Before
	public void setUp(String...s) {
		int len = s.length;
		if(len == 0) dr = new DataReader[] { new DataReader() };
		else {
			dr = new DataReader[len];
			for(int i = 0; i < len; i++)
				dr[i] = new DataReader(s[i]);
		}
	}
	
	@After
	public void tearDown() {
		dr = null;
	}
	
	@Test
	public void q20test() {
		int len = dr.length;
		for(int i = 0; i < len; i++) {
			Assert.assertEquals(expected[i], dr[i].toString());
		}
	}
	
}
