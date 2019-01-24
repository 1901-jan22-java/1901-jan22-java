package com.revature.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	//Using FileI/O to read and write files
	public void writeObj(Object obj) {
		String filepath = "src/com/revature/io/text.txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true))){
			bw.write(obj.toString() + "\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
