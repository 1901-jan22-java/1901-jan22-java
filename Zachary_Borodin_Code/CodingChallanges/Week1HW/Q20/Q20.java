package com.revature.hw1.Q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {
	public static void main(String[] args) {
		String filePath = "src/com/revature/hw1/Q20/Data.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath));) {
			String current = null;
			while((current = br.readLine()) != null) {
				String info[] = current.split(":");
				System.out.print("Name: "+ info[0] + " " + info[1] + "\n");
				System.out.print("Age: " + info[2] + " years" +"\n");
				System.out.println("State: "+ info[3] + "\n");
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
