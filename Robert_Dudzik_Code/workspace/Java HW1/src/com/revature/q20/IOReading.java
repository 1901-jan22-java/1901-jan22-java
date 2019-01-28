package com.revature.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.revature.pojos.*;


public class IOReading 
{

	public static void main(String[] args)
	{
		ReadFile();
	}
	
	public static void ReadFile()
	{
		String filepath = "src/com/revature/q20/Data.txt";
		List<Person> people = new ArrayList<Person>();
		try(BufferedReader br = new BufferedReader(new FileReader(filepath)))
		{
			String currLine = "";
			IOReading io = new IOReading();
			while((currLine = br.readLine()) != null)
			{
				String[] info = currLine.split(":");
				Person pop = new Person(info[0], info[1], info[2], info[3]);
				people.add(pop);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		for(int i = 0; i < people.size(); i++)
		{
			System.out.println("Name: " + people.get(i).getFirstName() + " " + people.get(i).getLastName());
			System.out.println("Age: " + people.get(i).getAge());
			System.out.println("State: " + people.get(i).getState());
		}
	}
}
