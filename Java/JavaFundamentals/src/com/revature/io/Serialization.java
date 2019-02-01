package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojos.Person;

/**
 * Serializable is a marker interface.
 * Marker interface - an interface with no methods.
 * 
 * Serialization is the conversion of the
 * 
 * @author Sanford
 *
 */
public class Serialization {
	
	static String filename = "src/com/revature/io/bytes.txt";
	
	public static void main(String[] args) {
		serializeObject(new Person("John Doe", "email@domain.com"));
		
		Person p = (Person) deserializeObject();
		System.out.println(p);
	}
	
	static void serializeObject(Object obj) {
		try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)) ) {
			oos.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object deserializeObject() {
		
		Object obj = null;
		try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)) ) {
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
