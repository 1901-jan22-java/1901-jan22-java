package com.revature.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Person;

public class FileIO {

	public void WriteObj(Object obj){
		String filePath = "src/com/revature/io/text.txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))){
			bw.write(obj.toString() + "\n");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static List<String> ReadFile(String path){
		List<String> words = new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null){
				
				words.add(line);
				
				line = br.readLine();
			}

		}catch(IOException e){
			e.printStackTrace();
		}
		
		return words;
	}
	
	public List<Person> ReadObj(){
		String filePath = "src/com/revature/io/text.txt";
		List<Person> people = new ArrayList<Person>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line = br.readLine();
			while(line != null){
				String[] split = line.split(";");
				
				people.add(new Person(split[0], split[1]));
				
				line = br.readLine();
			}

		}catch(IOException e){
			e.printStackTrace();
		}
		
		return people;
		
	}
}
