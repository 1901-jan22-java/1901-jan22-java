package com.kevin.project0.tables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kevin.project0.util.ConnectionFactory;

public class Bank {
	//functions like a look up table
	private List<BankUser> users = new ArrayList<BankUser>();
	private List<BankAccount> accounts = new ArrayList<BankAccount>();
	
	public Bank(){}
	
	public List<BankUser> getUsers() {
		/*List<BankUser> users = new ArrayList<BankUser>();
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
		}*/
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
		for(int i = 0; i < users.size(); i++)
			if(users.get(i).getUsername().equals(x))
				return true;
			
		return false;
	}
	
	public boolean createUser(Scanner console)
	{
		System.out.println("Enter your Username");
		String username = console.nextLine();
		if(UserExists(username))
			return false;
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
		
		return true;
	}
	
	public boolean logIn(Scanner console)
	{
		System.out.println("Enter your Username");
		String username = console.nextLine();
		System.out.println("Enter your Password");
		String password = console.nextLine();
		
		for(int i = 0; i < users.size(); i++)
			if(users.get(i).getUsername().equals(username))
				if(users.get(i).getPassword().equals(password))
					return true;
		return false;
	}
}
