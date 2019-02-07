package com.revature.associate_project;

import java.util.Scanner;

public class App 
{
	public static void startUp(Scanner input, AssociateRepository myAssociate)
	{
		boolean loggedIn = false;
		
    	String testcase;
    	boolean runStartUp = true;
    	while(runStartUp)
    	{	
    		System.out.println("Press 1 to log in. "
    							+ "Press 2 to make a new account. "
    							+ "Press 3 to check grades");
        	testcase = input.nextLine();
        	switch(testcase)
    	   	{
    	   		case "1":
    	   			loggedIn = myAssociate.logIn(input);
    	   			if(!loggedIn)
    	   				System.out.println("Failed to log in. Check Username/Password");
    	   			break;

    	   		case "2":
    	   			loggedIn = myAssociate.createAssociate(input);
    	   			if(!loggedIn)
    	   				System.out.println("Failed to create new user");
    	   			else
    	   			{
    	   				System.out.println("Logging in as new user");
    	   				break;
    	   			}
    	   		case "3":
    	   			myAssociate.checkGrades();
    	   			break;
    	   		default:
    	   			System.out.println("Quitting app");
    	   			runStartUp = false;
    	   			break;
    	   	}
    	}
	}
	
    public static void main( String[] args )
    {
    	AssociateRepository myBank = new AssociateRepository();
    	Scanner console = new Scanner(System.in);
    	startUp(console, myBank);
    	
    	console.close();
    }
    
}