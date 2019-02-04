package com.kevin.project0.kevin;

import java.util.Scanner;

import com.kevin.project0.tables.Bank;

/**
 * Hello world!
 *
 */
public class App 
{
	public static boolean startUp(Scanner input, Bank myBank)
	{
		boolean loggedIn = false;

		System.out.println("Welcome to Revature Bank.");
    	System.out.println("Press 1 to log in. Press 2 to make a new account. Press anything else to quit");
    	int testcase = input.nextInt();
    	switch(testcase)
    	{
    		case 1:
    			loggedIn = myBank.logIn(input);
    			if(!loggedIn)
    				System.out.println("Failed to log in. Check Username/Password");
    			break;
    		
    		case 2:
    			if(!myBank.createUser(input))
    				System.out.println("User already exists!");
    			else
    				loggedIn = true;
    			break;
    			
    		default:
    			System.out.println("Quitting app");
    			break;
    	}
    	
    	return loggedIn;
	}
	
    public static void main( String[] args )
    {
    	Bank myBank = new Bank();
    	Scanner console = new Scanner(System.in);
    	boolean runApp = startUp(console, myBank);

    	String input = "";
    	while(runApp)
    	{
        	System.out.println("Choose what you want to do\n"
					+ "Q = quit\n"
					+ "D = deposit\n"
					+ "W = withdraw\n"
					+ "A = make new account");
        	input = console.nextLine().toUpperCase();
        	
        	switch(input)
        	{
        		case "Q":
        			runApp = false;
        			break;
        		case "D":
        			
        			break;
        		case "W":
        			
        			break;
        		case "A":
        			
        			break;
        		default:
        			break;
        	}
        }
    	
    	console.close();
    	
    }
    
    
}
