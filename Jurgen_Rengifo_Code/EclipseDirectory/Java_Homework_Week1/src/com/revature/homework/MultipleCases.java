package com.revature.homework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;
//implement a scanner to go through each case one by one
public class MultipleCases
{
	public static void main(String[] args)
	{
		//make a choice
		int choice;
		Scanner s=new Scanner(System.in);
		//asks user for input
		System.out.println("Enter your choice:\n1)Find the square root of number\n2)Display today's date\n3)Split the string and store in array\n");
		choice=s.nextInt();
		switch(choice)
		{

			case 1:
				System.out.println("Enter the number\n");
				int n=s.nextInt();
				double squareRoot=Math.sqrt(n);
				System.out.println("Square root of "+n+" is "+squareRoot);
				break;
			case 2:
				LocalDateTime date = LocalDateTime.now();
				System.out.println(date.toString());
				break;
			case 3:
				String st="I am learning Core Java";
				String[] stArray=st.split(" ");
				for(int i=0;i<stArray.length;i++)
				{
					System.out.println(stArray[i]);
				}
		}
	}
}