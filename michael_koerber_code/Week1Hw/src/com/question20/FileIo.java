package com.question20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIo {

	public void writeData(Object obj) {
		String filepath = "src/com/question20/Data.txt";
		try(BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(filepath, true))){ //Try with resources block
			bufferWriter.write(obj.toString() + "\n");//FileWriter converts the code to be written by the BufferedWriter as a string.
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	static public List<People> readObj(){
		String filepath = "src/com/question20/Data.txt";
		List<People> peoples = new ArrayList<People>();
		try(BufferedReader bufferReader = new BufferedReader(new FileReader(filepath))){
			String currLine = null;
			while((currLine = bufferReader.readLine()) != null) {
				String[] info = currLine.split(":");
				People p = new People(info[0], info[1], info[2], info[3]);
				peoples.add(p);
			}
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return peoples;
	}
	
}
