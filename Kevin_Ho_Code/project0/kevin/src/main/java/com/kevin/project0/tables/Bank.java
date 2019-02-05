package com.kevin.project0.tables;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	private List<BankAccount> accounts;
	
	public Bank(){
		users = getUsers();
	}
		
	public List<BankUser> getUsers(){
		users = new ArrayList<BankUser>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "SELECT * FROM bankuser";
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			while(rs.next())
			{
				BankUser temp = new BankUser(	rs.getString("Username"), rs.getString("Password"),
												rs.getString("First_Name"), rs.getString("Last_Name"),
												rs.getString("Birthdate"), rs.getString("Phone"), 
												rs.getString("Email"));
				users.add(temp);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return users;
	}
	
	public List<BankAccount> getAccounts(BankUser user){
		accounts = new ArrayList<BankAccount>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement ps = null;
			String query = "SELECT * FROM bankaccount WHERE bankaccount.owner = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			BankAccount temp;
			while(rs.next())
			{
				temp = new BankAccount(	rs.getInt(1), rs.getDouble(2), 
													rs.getString("Type"), rs.getString("Owner"));
				accounts.add(temp);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return accounts;
	}
	public boolean UserExists(String x)
	{
		if(users.size() == 0)
			return false;
		
		for(int i = 0; i < users.size()-1; i++)
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
			System.out.println("Enter your Phone");
			String phone = console.nextLine();
			System.out.println("Enter your Email");
			String email = console.nextLine();
		
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				conn.setAutoCommit(false);
				PreparedStatement insertUser = null;
				String query = "INSERT INTO bankuser (username, password, first_name,"
													+ "last_name, birthdate, phone, email) "
								+ "VALUES (?,?,?,?,?,?,?)";
						
				insertUser = conn.prepareStatement(query);
				insertUser.setString(1, username);
				insertUser.setString(2, password);
				insertUser.setString(3, first_name);
				insertUser.setString(4, last_name);
				insertUser.setString(5, birthdate);
				insertUser.setString(6, phone);
				insertUser.setString(7, email);
				
				insertUser.executeUpdate();
				conn.commit();
				
				BankUser tmp = new BankUser(username, password, first_name, 
						last_name, birthdate, phone, email);
				users.add(tmp);

				return tmp;	
			}
			 catch (SQLException e){
				e.printStackTrace();
			}
		} catch(InputMismatchException e){
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
				{
					System.out.println("Log in successful");
					accounts = getAccounts(users.get(i));
					return users.get(i);
				}
		System.out.println("Log in failed");
		
		return null;
	}

	public BankAccount addAccount(Scanner console, BankUser loggedInUser) {
		try{
			int accountnumber=0;
			String owner = loggedInUser.getUsername();
			System.out.println("Enter the amount of money you're adding to the account");
			double money = Double.parseDouble(console.nextLine());
			System.out.println("Enter C if Checking, and S if Savings");
			String type = console.nextLine();
			switch(type.toUpperCase())
			{
				case "C":
					type = "Checking";
					break;
				case "S":
					type = "Savings";
					break;
				default:
					System.out.println("Invalid Type. Exiting account creation");
					return null;
			}
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				conn.setAutoCommit(false);
				
				PreparedStatement insertUser = null;
				String query = "INSERT INTO bankaccount (money, type, owner)"
								+ "VALUES (?,?,?)";
				
				insertUser = conn.prepareStatement(query);
				insertUser.setDouble(1, money);
				insertUser.setString(2, type);
				insertUser.setString(3, owner);
				
				insertUser.executeUpdate();
				conn.commit();
				
				query = "SELECT account_number FROM bankaccount WHERE OWNER = ?";
				insertUser = conn.prepareStatement(query);
				insertUser.setString(1, owner);
				ResultSet rs = insertUser.executeQuery();
				if(rs.next())
					accountnumber = rs.getInt(1);

				BankAccount tmp = new BankAccount(accountnumber, money, type, owner);
				accounts.add(tmp);
				return tmp;
					
			}
			 catch (SQLException e){
				e.printStackTrace();
			}
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid inputs");
		} catch(NumberFormatException e)
		{
			System.out.println("Invalid inputs");
		}
		
		return null;
	}
	/*
	public boolean withdraw(Scanner console){

		System.out.println("Enter the amount you want to withdraw. Current balance = " + myAccount.getMoney());
		try{
			myAccount.withdraw(console);
			CallableStatement cs = null;
			try(Connection conn = ConnectionFactory.getInstance().getConnection())
			{
				String sql = "call withdraw(?,?)";
				cs = conn.prepareCall(sql);
				cs.setInt(1, input);
				cs.setDouble(2, getAccount(input).getMoney());
				cs.executeUpdate();
				conn.commit();
				return true;
			} catch (SQLException e)
			{
				System.out.println("Deposit failed");
				return false;
			}
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
*/
	
	public boolean deposit(Scanner console)
	{
		System.out.println("Please enter which account number you wish to deposit to");
		printAccounts();
    	
		try
		{
			int input = console.nextInt();
			if(getAccount(input) == null)
			{
				System.out.println("Account does not exist");
				return false;
			}
			else
			{
				if(getAccount(input).deposit(console))
				{
					CallableStatement cs = null;
					try(Connection conn = ConnectionFactory.getInstance().getConnection())
					{
						String sql = "call deposit(?,?)";
						cs = conn.prepareCall(sql);
						cs.setInt(1, input);
						cs.setDouble(2, getAccount(input).getMoney());
						cs.executeUpdate();
						conn.commit();

						return true;
					} catch (SQLException e)
					{
						System.out.println("Deposit failed");
						return false;
					}
				}
				else
					return false;
			}
			
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid input");
			return false;
		}
	}
	public BankAccount getAccount(int accID)
	{
		for(int i = 0; i < accounts.size(); i++)
			if(accounts.get(i).getAccountNumber() == accID)
				return accounts.get(i);
		return null;
	}
	
	public void printAccounts()
	{
    	for(int i = 0; i < accounts.size(); i++)
    		System.out.println(accounts.get(i).toString());
	}
}
