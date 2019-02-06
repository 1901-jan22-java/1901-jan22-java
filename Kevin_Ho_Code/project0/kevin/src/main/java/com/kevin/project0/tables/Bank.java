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

import com.kevin.project0.exception.BadMoneyException;
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
												rs.getString("First_Name"), rs.getString("Last_Name"));
				users.add(temp);
			}
			statement.close();
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
			ps.close();
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
		
			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				conn.setAutoCommit(false);
				PreparedStatement insertUser = null;
				String query = "INSERT INTO bankuser (username, password, first_name,"
													+ "last_name)"
								+ "VALUES (?,?,?,?)";
					
				insertUser = conn.prepareStatement(query);
				insertUser.setString(1, username);
				insertUser.setString(2, password);
				insertUser.setString(3, first_name);
				insertUser.setString(4, last_name);
				
				insertUser.executeUpdate();
				conn.commit();
				insertUser.close();
				BankUser tmp = new BankUser(username, password, first_name, last_name);
				users.add(tmp);

				return tmp;	
			}
			 catch (SQLException e){
				e.printStackTrace();
			}
		} catch(InputMismatchException e){
		System.out.println("Invalid Input. Try again.");
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
					System.out.println("Logging in. Please wait.");
					accounts = getAccounts(users.get(i));
					return users.get(i);
				}
		
		return null;
	}

	public BankAccount addAccount(Scanner console, BankUser loggedInUser) {
		try{
			int accountnumber=0;
			String owner = loggedInUser.getUsername();
			System.out.println("Enter the amount of money you're adding to the account");
			double money = Double.parseDouble(console.nextLine());
			if(money < 0)
			{
				System.out.println("Cannot have a negative balance.");
				return null;
			}
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
				
				insertUser.close();
				conn.setAutoCommit(true);
				BankAccount tmp = new BankAccount(accountnumber, money, type, owner);
				accounts.add(tmp);
				return tmp;
					
			}
			 catch (SQLException e){
				e.printStackTrace();
			}
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid Inputs. Try again.");
		} catch(NumberFormatException e)
		{
			System.out.println("Invalid inputs. Try again.");
		}
		
		return null;
	}
	
	public boolean withdraw(Scanner console){
		System.out.println("Select the account you want to withdraw from");
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
				try {
					getAccount(input).withdraw(console);
				} catch (BadMoneyException e1) {
					System.out.println("Not enough money");
					return false;
				}
				CallableStatement cs = null;
				try(Connection conn = ConnectionFactory.getInstance().getConnection())
				{
					conn.setAutoCommit(false);
					String sql = "call withdraw(?,?)";
					cs = conn.prepareCall(sql);
					cs.setInt(1, input);
					cs.setDouble(2, getAccount(input).getMoney());
					cs.executeUpdate();
					conn.commit();
					cs.close();
					conn.setAutoCommit(true);
					return true;
					
				} catch (SQLException e)
				{
					System.out.println("Withdraw failed");
					return false;
				}
			}
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid input. Try again");
			return false;
		} catch(NumberFormatException e)
		{
			System.out.println("Invalid Input. Try again.");
			return false;
		}
	}
	
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
						conn.setAutoCommit(false);
						String sql = "call deposit(?,?)";
						cs = conn.prepareCall(sql);
						cs.setInt(1, input);
						cs.setDouble(2, getAccount(input).getMoney());
						cs.executeUpdate();
						conn.commit();
						cs.close();
						conn.setAutoCommit(true);
						return true;
					} catch (SQLException e)
					{
						System.out.println("Deposit failed");
						e.printStackTrace();
						return false;
					}
				}
				else
					return false;
			}
			
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid Input. Try again.");
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
