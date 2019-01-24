package com.revature.IO;

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

	public void writeObject(Object obj) {
		String filepath = "src/com/revature/io/text.txt";
		try(BufferedWriter bw = new BufferedWriter(
				new FileWriter(filepath, true))) {
			bw.write(obj.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	public List<Person> readObj(){
		String filepath = "src/com/revature/io/text.txt";
		List<Person> people = new ArrayList<Person>();
		try(BufferedReader br = new BufferedReader(
				new FileReader(filepath))) {
			String currentLine = null;
			while((currentLine = br.readLine()) != null) {
				String[] info = currentLine.split(";");
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
	
	public static void main(String[] args) {
		
	}

}
