package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Person;

public class FileIO {
	
	//Using FileI/O to read and write files 
	public void writeObj(Object obj) {
		String filepath = "src/com/revature/io/text.txt";
		/*
		 * Below we see Try-with-resources
		 * Parameterized try block used to instantiate 
		 * entities that implement the AutoCloseable 
		 * interface so that we do not need to programmatically
		 * close the resource ourselves
		 */
		try(BufferedWriter bw = new BufferedWriter(
						new FileWriter(filepath, true))){
			//FileWriter(filePath, booleanToAppend)^
			bw.write(obj.toString() +  "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//read in text file and store info into collection of Person objects
	public List<Person> readObj(){
		String filepath = "src/com/revature/io/text.txt";
		List<Person> people = new ArrayList<Person>();
		try(BufferedReader br = new BufferedReader(
				new FileReader(filepath))){
			String currLine = null;
			while((currLine=br.readLine())!=null) {
				String[] info = currLine.split(";");
				Person p = new Person(info[0], info[1]);
				people.add(p);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return people;
	}

}
