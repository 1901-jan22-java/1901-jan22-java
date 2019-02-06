package com.kevin.project0.kevin;

import java.util.Scanner;

import com.kevin.project0.tables.Bank;
import com.kevin.project0.tables.BankUser;

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
    	   				System.out.println("Failed to create new user");
    	   			else
    	   			{
    	   				System.out.println("Logging in as new user");
    	   				runStartUp = false;
    	   				return temp;
    	   			}
    	   		default:
    	   			System.out.println("Quitting app");
    	   			runStartUp = false;
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
    		if(myBank.getAccounts(loggedInUser).size() == 0){
    			System.out.println("No accounts found. Please create one");
    			myBank.addAccount(console, loggedInUser);
    		}

    		else
    		{
    			System.out.println("\nChoose what you want to do\n"
    								+ "C = Check Account Balance\n"
    								+ "A = Make New Account\n"
    								+ "D = Deposit\n"
    								+ "W = Withdraw\n"
    								+ "Q = Quit");
    			input = console.nextLine().toUpperCase();

    			switch(input)
    			{
    				case "Q":
    					loggedIn = false;
    					System.out.println("Quitting app");
    					break;
    				case "D":
    					myBank.deposit(console);
    					break;
    				case "W":
    					myBank.withdraw(console);
    					break;
    				case "A":
    					myBank.addAccount(console, loggedInUser);
    					break;
    				case "C":
    					myBank.printAccounts();
    					break;
    				default:
    					break;
    			}
    		}
        }
    	
    	console.close();
    }
    
}
