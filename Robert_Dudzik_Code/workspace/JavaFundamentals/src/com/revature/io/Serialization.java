package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojos.Person;

public class Serialization 
{
	/*
	 * Serialization is the conversion of the 
	 * state of an object into a byte stream
	 * (a sequence of bytes) which can then 
	 * be saved to a database or transferred
	 * over a network. 
	 * Deserialization does the opposite(stream
	 * of bytes -- object) 
	 * 
	 * Classes must implement the Serializable 
	 * interface to be eligible for serialization 
	 * When a class implements Serializable, all of
	 * its subclasses are serializable as well (is-a
	 * relationship).
	 * When an object has a reference to another object
	 * (has-a relationship), that class must also
	 * implement Serializable or a NotSerializableException
	 * will be thrown. 
	 * 
	 * When implementing Serializable, it is 
	 * suggested to give your class a Serial Version
	 * UID. This value is used to verify that the saved
	 * and loaded objects have the same attributes and 
	 * are thus compatible on serialization(basically
	 * ensuring that you are deserializing a stream 
	 * of bytes into the right type of object)
	 * 
	 * If attempting to deserialize a stream of bytes into
	 * the wrong class reference, an InvalidClassException is thrown
	 * 
	 * static fields belong to the class, not the
	 * object, and are not serialized
	 * 
	 * the transient keyword can be applied to 
	 * instance variables so that their values
	 * will not be serialized -- they will
	 * deserialize to the default value for their
	 * respective reference type 
	 * 
	 * In order to do this, we use ObjectInputStream
	 * and ObjectOutputStream which can respectively 
	 * read and write primitive types and graphs of
	 * objects */
	
	public static void main(String[] args)
	{
//		Person p = new Person("gen", "gab12@duke.edu");
//		serializeObject(p);
		Person p = (Person)deserializeObject();
		System.out.println(p);
		
	}
	
	static Object deserializeObject()
	{
		Object obj = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
		{
			obj = ois.readObject();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	
	static String filename = "src/com/revature/io/bytes.txt";
	static void serializeObject(Object obj)
	{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
		{
			oos.writeObject(obj);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
