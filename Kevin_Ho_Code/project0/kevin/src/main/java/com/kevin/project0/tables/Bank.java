package com.kevin.project0.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kevin.project0.util.ConnectionFactory;


public class Bank {
	//functions like a look up table
	private List<BankUser> users;
	private List<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public Bank(){
		users = new ArrayList<BankUser>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM bankuser";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next())
			{
				BankUser temp = new BankUser(	rs.getString("Username"), rs.getString("Password"),
												rs.getString("First_Name"), rs.getString("Last_Name"),
												rs.getString("Birthdate"), rs.getString("Address"),
												rs.getString("City"), rs.getString("State"),
												rs.getString("PostalCode"), rs.getString("Country"),
												rs.getString("Phone"), rs.getString("Email"));
				users.add(temp);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<BankUser> getUsers() {
		List<BankUser> users = new ArrayList<BankUser>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM bankuser";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next())
			{
				BankUser temp = new BankUser(	rs.getString("Username"), rs.getString("Password"),
												rs.getString("First_Name"), rs.getString("Last_Name"),
												rs.getString("Birthdate"), rs.getString("Address"),
												rs.getString("City"), rs.getString("State"),
												rs.getString("PostalCode"), rs.getString("Country"),
												rs.getString("Phone"), rs.getString("Email"));
				users.add(temp);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return users;
	}

	public List<BankAccount> getAccounts() {
		/*List<BankAccount> accounts = new ArrayList<BankAccount>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM bankaccount";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next())
			{
				BankAccount temp = new BankAccount(	rs.getInt(1), rs.getDouble(2), rs.getString("Type"), 
											rs.getString("Owner"), rs.getString("Name"));
				accounts.add(temp);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}*/
		return accounts;
	}
	public boolean UserExists(String x)
	{
		if(users.size() == 0)
			return false;
		
		for(int i = 0; i < users.size(); i++)
			if(users.get(i).getUsername().equals(x))
				return true;
			
		return false;
	}
	
	public BankUser createUser(Scanner console)
	{
		try{
			System.out.println("Enter your Username");
			String username = console.nextLine();
			if(UserExists(username))
				return null;
			System.out.println("Enter your Password");
			String password = console.nextLine();
			System.out.println("Enter your First Name");
			String first_name = console.nextLine();
			System.out.println("Enter your Last Name");
			String last_name = console.nextLine();
			System.out.println("Enter your Birthdate");
			String birthdate = console.nextLine();
			System.out.println("Enter your Address");
			String address = console.nextLine();
			System.out.println("Enter your City");
			String city = console.nextLine();
			System.out.println("Enter your State");
			String state = console.nextLine();
			System.out.println("Enter your PostalCode");
			String postalcode = console.nextLine();
			System.out.println("Enter your Country");
			String country = console.nextLine();
			System.out.println("Enter your Phone");
			String phone = console.nextLine();
			System.out.println("Enter your Email");
			String email = console.nextLine();
		
			BankUser tmp = new BankUser(username, password, first_name, 
										last_name, birthdate, address, 
										city, state, postalcode, country, phone, email);
			users.add(tmp);
		
			return tmp;
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid input");
		}
		return null;
	}
	
	public BankUser logIn(Scanner console)
	{
		System.out.println("Enter your Username");
		String username = console.nextLine();
		System.out.println("Enter your Password");
		String password = console.nextLine();
		
		for(int i = 0; i < users.size(); i++)
			if(users.get(i).getUsername().equals(username))
				if(users.get(i).getPassword().equals(password))
					return users.get(i);
		return null;
	}

	public BankAccount addAccount(Scanner console, BankUser loggedInUser) {
		try{
			String owner = loggedInUser.getUsername();
			int accountNumber = accounts.size();
			
			System.out.println("Enter the amount of money you're adding to the account");
			double money = Double.parseDouble(console.nextLine());
			
			System.out.println("Enter the account type");
			String type = console.nextLine();
			
			System.out.println("Enter the account nickname");
			String name = console.nextLine();
			
			BankAccount tmp = new BankAccount(accountNumber, money, type, owner, name);
			accounts.add(tmp);
			return tmp;
			
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid inputs");
		} catch(NumberFormatException e)
		{
			System.out.println("Invalid inputs");
		}
		
		return null;
	}

	public boolean deposit(Scanner console, BankAccount myAccount) {
		
		System.out.println("Enter the amount you want to deposit. Current balance = " + myAccount.getMoney());
		try{
			double input = Double.parseDouble(console.nextLine());
		
			myAccount.setMoney(myAccount.getMoney() + input);
			System.out.println("Deposited " + input + " dollars. Current balance = " + myAccount.getMoney());
			return true;
		} catch(InputMismatchException e){
			System.out.println("Invalid input");
		} catch(NumberFormatException e)
		{
			System.out.println("Invalid inputs");
		}
		
		return false;
	}
	
	public boolean withdraw(Scanner console, BankAccount myAccount){

		System.out.println("Enter the amount you want to withdraw. Current balance = " + myAccount.getMoney());
		try{
			double input = Double.parseDouble(console.nextLine());
		
			if(input < 0 || myAccount.getMoney()-input < 0)
			{
				System.out.println("Invalid input");
				return false;
			}
			else
			{
				myAccount.setMoney(myAccount.getMoney()-input);
				System.out.println("Withdrew " + input + " dollars. Current balance = " + myAccount.getMoney());
				return true;
			}
		} catch(InputMismatchException e){
			System.out.println("Invalid input");
		} catch(NumberFormatException e)
		{
			System.out.println("Invalid inputs");
		}
		
		return false;
	}

	public void checkBalance() {
		for(int i = 0; i < accounts.size(); i++)
			System.out.println(accounts.get(i).toString());
	}
}
