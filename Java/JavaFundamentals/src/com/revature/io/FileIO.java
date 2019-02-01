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

/**
 * Using File I/O to read and write files
 * 
 * @author Sanford
 *
 */

public class FileIO {
	
//	public static void main(String[] args) {
//		String filepath = "src/com/revature/text.txt";
//		System.out.println(filepath);
//	}

	private static final String FILEPATH = "src/com/revature/text.txt";
	
	public void overwriteObj(Object obj) {
		try ( BufferedWriter bw = new BufferedWriter(new FileWriter(FILEPATH, true)) ) {
			bw.write(obj.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void writeObj(Object obj) {
		try ( BufferedWriter bw = new BufferedWriter(new FileWriter(FILEPATH)) ) {
			bw.write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Person> readPeople(){
		List<Person> people = new ArrayList<Person>();
		try ( BufferedReader br = new BufferedReader(new FileReader(FILEPATH)) ) {
			String s = null;
			
			while( (s = br.readLine())!= null ) {
				String[] info = s.split(";");
				Person p = new Person( info[0], info[1] );
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
