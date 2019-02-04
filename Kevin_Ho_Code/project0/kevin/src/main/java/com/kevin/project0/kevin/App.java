package com.kevin.project0.kevin;

import java.util.Scanner;

import com.kevin.project0.tables.Bank;
import com.kevin.project0.tables.BankUser;

/**
 * Hello world!
 *
 */
public class App 
{
	public static BankUser startUp(Scanner input, Bank myBank)
	{
		boolean loggedIn = false;
		BankUser temp;
		
		System.out.println("Welcome to Revature Bank.");
    	String testcase;
    	boolean runStartUp = true;
    	while(runStartUp)
    	{	
    		System.out.println("Press 1 to log in. Press 2 to make a new account. Press anything else to quit");
        	testcase = input.nextLine();
        	switch(testcase)
    	   	{
    	   		case "1":
    	   			temp = myBank.logIn(input);
    	   			loggedIn = (temp != null);
    	   			if(!loggedIn)
    	   				System.out.println("Failed to log in. Check Username/Password");
    	   			else
    	   				return temp;
    	   			
    	   			break;

    	   		case "2":
    	   			temp = myBank.createUser(input);
    	   			if(temp == null)
    	   				System.out.println("User already exists!");
    	   			else
    	   			{
    	   				System.out.println("Logging in as new user");
    	   				return temp;
    	   			}
    	   		default:
    	   			System.out.println("Quitting app");
    	   			return null;
    	   	}
    	}
    	return null;
	}
	
    public static void main( String[] args )
    {
    	Bank myBank = new Bank();
    	Scanner console = new Scanner(System.in);
    	BankUser loggedInUser = startUp(console, myBank);
    	boolean loggedIn = (loggedInUser!=null);
    	String input = "";
    	while(loggedIn)
    	{
    		if(myBank.getAccounts().size() == 0){
    			System.out.println("No accounts found. Please create one");
    			myBank.addAccount(console, loggedInUser);
    		}
    			
    		else
    		{
    			System.out.println("\nChoose what you want to do\n"
    								+ "Q = quit\n"
    								+ "D = deposit\n"
    								+ "W = withdraw\n"
    								+ "A = make new account\n"
    								+ "C = check account balance");
    			input = console.nextLine().toUpperCase();
        	
    			switch(input)
    			{
    				case "Q":
    					loggedIn = false;
    					break;
    				case "D":
    					myBank.deposit(console, myBank.getAccounts().get(0));
    					break;
    				case "W":
    					myBank.withdraw(console, myBank.getAccounts().get(0));
    					break;
    				case "A":
    					myBank.addAccount(console, loggedInUser);
    					break;
    				case "C":
    					myBank.checkBalance();
    					break;
    				default:
    					break;
    			}
    		}
        }

    	//System.out.println(myBank.getUsers().get(0).toString());
    	console.close();
    }
    
    
}
