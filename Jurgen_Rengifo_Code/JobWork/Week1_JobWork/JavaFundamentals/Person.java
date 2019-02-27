package com.revature.pojos;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Person {
	
		private String name;
		private String email;
		public Person() {}
		public Person(String name, String email) {
			super();
			this.name = name;
			this.email = email;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return "Person [name=" + name + ", email=" + email + "]";
		}
		//read in text fil and store info into collection of Person
		public List<Person> readObj(){
			String filepath = "src/com/revature/io/text.txt";
			List<Person> people = new ArrayList<Person>();
			try(BufferedWriter br = new BufferedWriter(new FileWriter(filepath))){
				String currLine = null;
				while((currLine=br.readLine()!=null)) {
					String[] info = currLine.split(";");
					Person p = new Person(info) [0], info[1];
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

