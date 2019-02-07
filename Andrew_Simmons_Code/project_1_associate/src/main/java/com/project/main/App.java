package com.project.main;
//Henry + Andrew
import com.jdbc.util.DataAccessObject;
import java.util.Scanner;

public class App {
	static Scanner scan = new Scanner(System.in);
	static DataAccessObject  service = new DataAccessObject();
	static int invalid = 0;
	public static void main(String[] args) {

			
		welcome();
	}
	
	
	static void welcome() {
	    while(true) {
    		System.out.println("What would you like to do?"
    				+ "\n1. Create new account"
    				+ "\n2. Log in"
    				+ "\n3. View Associate Statistics"
    				+ "\n4. Quit"
    				);
    		String in = scan.nextLine();
    		int op = 0;
    		try {
    			op = Integer.parseInt(in);
    		}
    		catch(NumberFormatException e) {
    			System.out.println("You must enter a number: either 1, 2, or 3!");
    			welcome();
    			return;
    		}
    		switch(op) {
    		case 1: createAccount();  break;
    	
    	     case 2: logIn(); break;
    		//case 3: getStats(); break;
    		case 4: System.exit(0);
    		default: System.out.println("You must enter a number: either 1, 2, or 3!"); welcome(); break;
    		}
		
		}
	}
	
	
    public static void logIn() {
        System.out.println("Enter your email: ");
        String email = scan.nextLine();
        System.out.println("Enter your password: ");
        String password = scan.nextLine();
        try {
            service.login(email, password);
        } catch (Exception e) {
            System.out.println("Either the email or the password wrong, try again...");
            logIn();
        }
        return;
    }
    /**
     * 
     * Creates an account
     * 
     **/
    public static void createAccount() {
        System.out.println("Enter your first name: ");
        String firstName = scan.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scan.nextLine();
        System.out.println("Enter your email: ");
        String email = scan.nextLine();
        System.out.println("Create a password: ");
        String password = scan.nextLine();
        service.createAssociate(firstName, lastName, email, password);
    }

}