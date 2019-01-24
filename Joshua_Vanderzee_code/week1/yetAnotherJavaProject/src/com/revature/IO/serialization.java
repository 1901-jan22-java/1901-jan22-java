package com.revature.IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojos.Person;

public class serialization {

	public static void main(String[] args) {
		Person p = new Person("James", "james@mail.com");
		SerializeObject(p);
		
	}
	
	static String filepath = "src/com/revature/io/bytes.txt";
	
	static void SerializeObject(Object obj) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))){
			oos.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object DeserializeObject() {
		Object obj;
		try(ObjectInputStream br = new ObjectInputStream(
				new FileInputStream(filepath))) {
			String currentLine = null;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
