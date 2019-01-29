package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojos.Person;

public class Serialization {
	
	/*
	 * Serialization is the conversion of the state of an object
	 * into a byte stream ( a sequence of bytes) which can then be 
	 * saved to a database or transferred over a network
	 * 
	 * Deserialization does the opposite(stream of bytes -> object)
	 */
	
	public static void main(String[] args) {
//		Person p = new Person("vikki", "vwood");
//		serializeObject(p); // will result in exception - class Person does not implement serializable.... yet
		
		Person p = (Person) deserializeObject();
		System.out.println(p);
	}
	
	
	static String filename = "src/com/revature/io/bytes.txt";
	
	static void serializeObject(Object obj) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(filename))) {
			oos.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	
	static Object deserializeObject() {
		
		Object obj = null;
		try(ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(filename))) {
			obj = ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
}
