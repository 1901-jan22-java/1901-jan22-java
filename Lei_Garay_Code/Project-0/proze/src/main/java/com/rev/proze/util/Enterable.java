package com.rev.proze.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.rev.proze.exceptions.Custom;
import com.rev.proze.exceptions.OnlyAlphabets;
import com.rev.proze.exceptions.OnlyYesNo;
import com.rev.proze.exceptions.SelectionInput;
import com.rev.proze.exceptions.ValidEmail;
import com.rev.proze.exceptions.ValidName;
import com.rev.proze.exceptions.ValidPassword;
import com.rev.proze.exceptions.ValidUsername;


public interface Enterable 
{
	String onlyAlphabets 	= "^[a-zA-Z]*$";
	String validName		= "^[a-zA-Z\\-]+$";
	String validEmails 		= "^(.+)@(.+)$";
	String validUsername 	= "[a-zA-Z0-9\\_\\-]{3,}";
	String validPassword	= "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
	String validMenuOption  = "^[1-3]";
	String validUserOption  = "^[1-4]";
	String validAmount		= "^[0-9]\\d{0,9}(\\.\\d{1,3})?%?$";
	
		
	default String getString(String targetInformation) 
			throws 	OnlyAlphabets
	{
		System.out.print("\nEnter " + targetInformation + ": ");
		String output = "";
		Scanner scanner = new Scanner(System.in);
		try{output = scanner.nextLine();
			if	(!output.matches(onlyAlphabets))	{	throw new OnlyAlphabets();	}														
		}
		catch(OnlyAlphabets e)	
		{System.out.print(e.getMessage()); output = getString(targetInformation);	}

		return output;
	}
	
	default String getAnyString(String targetInformation) 
	{
		System.out.print("|		Enter " + targetInformation + ": ");
		String output = "";
		Scanner scanner = new Scanner(System.in);
		output = scanner.nextLine();
		return output;
	}
	
	default String getName(String targetInformation) 
			throws ValidName
	{
		
		System.out.print("| 	Enter " + targetInformation + ": ");
		String output = "";
		Scanner scanner = new Scanner(System.in);
		try
		{	
			output = scanner.nextLine();
			if	(!output.matches(validName))	{	throw new ValidName();	}														
		}
		catch(ValidName e)	
		{output = getName(targetInformation);	}

		return output;
	}
	
	default String getEmail(String targetInformation) 
			throws 	ValidEmail
	{
		System.out.print("|	Enter " + targetInformation + ": ");
		String output = "";
		Scanner scanner = new Scanner(System.in);
		try
		{	
			output = scanner.nextLine();
			if	(!output.matches(validEmails))	{	throw new ValidEmail();	}														
		}
		catch(ValidEmail e)	
		{	
			output = getEmail(targetInformation);	
		}

		return output;
	}
	
	default Integer getInteger(String targetInformation) 
			throws 	Custom
	{
		System.out.print("\nEnter " + targetInformation + ": ");
		Integer output = 0;
		Scanner scanner = new Scanner(System.in);
		try
		{	
			output = scanner.nextInt();
			if(output > 99999 || output > 99999) 
			{
			    throw new Custom("too big of a number");
			    
			}														
		}
		catch (Custom e) { e.printStackTrace(); }
		catch (InputMismatchException e) 
		{ System.out.println("Not a valid input.\n"); 
			output = getInteger("input again");
		}

		return output;
	}
	
	default Integer getMenuSelection(String targetInformation) 
			throws 	SelectionInput
	{
		System.out.print("|		Enter " + targetInformation + ": ");
		Integer output = 0;
		String temp = "";
		Scanner scanner = new Scanner(System.in);
		try
		{	
			temp = scanner.nextLine();
			if(!temp.matches(validMenuOption)) { 	throw new SelectionInput();}														
		}
		catch (SelectionInput e) { output = getMenuSelection(targetInformation); }
		try
		{	
			output = Integer.parseInt(temp);
		}
		catch (NumberFormatException e) { return output; }
		return output;
	}
	
	default Integer getUserSelection(String targetInformation) 
			throws 	SelectionInput
	{
		System.out.print("|		Enter " + targetInformation + ": ");
		Integer output = 0;
		String temp = "";
		Scanner scanner = new Scanner(System.in);
		try
		{	
			temp = scanner.nextLine();
			if(!temp.matches(validUserOption)) { 	throw new SelectionInput();}														
		}
		catch (SelectionInput e) { output = getMenuSelection(targetInformation); }
		try
		{	
			output = Integer.parseInt(temp);
		}
		catch (NumberFormatException e) { return output; }
		return output;
	}
	
	default Integer getUserCustomRange(int beg, int end) 
			throws 	SelectionInput
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print(" Select option: ");
		String validInput = new StringWorks().getRangeRegex(beg, end);
		Integer output = 0;
		boolean retry = false;
		String temp = "";
		while(!retry)
		{	
			
			try
			{	
				temp = scanner.nextLine();
				if(!temp.matches(validInput)) 		{ 	throw new SelectionInput();	}
				else								{ 	retry = true;				}
			}
			catch (SelectionInput e) { System.out.print(" Select option: ");}
		}
				output = Integer.parseInt(temp);
			
		return output;
	}
	
	default String getUsername(String targetInformation) 
			throws 	ValidUsername
	{
		System.out.print(new Definitions().unRqmts);
		System.out.print("|		Enter " + targetInformation + ": ");
		String output = "";
		Scanner scanner = new Scanner(System.in);
		try
		{	
			output = scanner.nextLine();
			if(!output.matches(validUsername)) { 	throw new ValidUsername();}														
		}
		catch (ValidUsername e) 
		{ 
			output = getUsername("username again"); 
		}

		return output;
	}
	
	default String getPassword(String targetInformation) 
			throws 	ValidPassword
	{
		System.out.print(new Definitions().pwRqmts);
		System.out.print("Enter " + targetInformation + ": ");
		String output = null;
		Scanner scanner = new Scanner(System.in);
		try
		{	
			output = scanner.nextLine();
			if(!output.matches(validPassword)) { 	throw new ValidPassword();}														
		}
		catch (ValidPassword e) 
		{ 
			output = getPassword("password again"); 
		}

		return output;
	}
	
	default boolean getYesNo() throws OnlyYesNo
	{
		String output;
		boolean moveOn = false;
		Scanner scanner = new Scanner(System.in);
		try
		{	
			output = scanner.nextLine();
			if		(output.length() == 00)			{	output = "y";		moveOn = true;		}
			else if	(output.contains("n"))			{	output = "n";		moveOn = false;		}
			else if	(output.contains("y"))			{	output = "y";		moveOn = true;		}
			else									{	throw new OnlyYesNo();			}
		}
		catch(OnlyYesNo e)		{System.out.print(e.getMessage());}
		
		return moveOn;
	}
	
	default Double getAmount(String targetInformation) 
			throws 	Custom
	{
		System.out.print("\nEnter " + targetInformation + ": ");
		Double output = 0.0;
		Scanner scanner = new Scanner(System.in);
		try
		{	
			output = scanner.nextDouble();
			if(!output.toString().matches(validAmount)) 
			{
			    throw new Custom("Invalid type");
			    
			}														
		}
		catch (Custom e) { e.printStackTrace(); }
		catch (InputMismatchException e) 
		{ System.out.println("Not a valid input.\n"); 
			output = getAmount("input again");
		}

		return output;
	}

}
