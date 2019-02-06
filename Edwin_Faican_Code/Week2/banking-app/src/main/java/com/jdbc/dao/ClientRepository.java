package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.app.App;
import com.revature.client.Client;
import com.jdbc.util.ConnectionFactory;

public class ClientRepository {
	final static Logger logger = Logger.getLogger(ClientRepository.class);
	//Select client matching the candidate key provided.
	//Note that although user name is unique and therefore a candidate key, the reasoning behind it not being
	//A primary key is that the client has the ability to change the user name. It would be strange if the client could change 
	//The manner in which the database uniquely stores data. 
	public Client findClient(String username) {
		username = username.toUpperCase();
		Client client = new Client();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "SELECT * FROM Client WHERE UPPER(username) = ?";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"client_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			ps.setString(1, username);
					
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				logger.debug(rs.getString("firstname"));
				client.setClientId(rs.getInt("client_id"));
				client.setFirstname(rs.getString("firstname"));
				client.setLastname(rs.getString("lastname"));
				client.setUsername(rs.getString("username"));
				client.setPassword(rs.getInt("pass"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}
	
	//Insert data with prepared statement 
	public Client newClient(String firstname,  String lastname, String username, int password) {
		Client client = new Client();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO Client(firstname, lastname, username, pass) VALUES(?,?,?,?)";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"client_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setInt(4, password);
			
			
			int numRows = ps.executeUpdate();
			
			if(numRows > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				pk.next();
				client.setClientId(pk.getInt(1));
				client.setFirstname(firstname);
				client.setLastname(lastname);
				client.setUsername(username);
				client.setPassword(password);
				conn.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}
	
	//Update client information (user name or password)
	//With the use of a Prepared Statement
	//Important to note that both values are being updated here even if only one is changed. 
	//The reasoning is to limit redundancy and have the same section of code run for multiple cases. 
	public Client updateUser(Client client) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE Client SET username = ?, pass = ? WHERE client_id = ?";
			//Create String array holding names of columns that are auto-generated
			String[] keys = {"client_id"};
			PreparedStatement ps = conn.prepareStatement(sql,keys);
			
			ps.setString(1, client.getUsername());
			ps.setInt(2, client.getPassword());
			ps.setInt(3,  client.getClientId());
						
			int numRows = ps.executeUpdate();
			
			if(numRows > 0) {
				conn.commit();
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return client;
	}
	
	//Delete client information with the use of a Prepared Statement. 
	//This is essentially if a client decides to close all accounts and leave permanently. 
	//Note that although clients are referenced in Accounts, by leaving the bank, all accounts will close 
	//So there is an integrity  constraint set to cascade the deletion. 
	public Client closeAccount(Client client) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "DELETE FROM Client WHERE client_id = ?";
			//Create String array holding names of columns that are auto-generated
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, client.getClientId());
						
			int numRows = ps.executeUpdate();
			
			if(numRows > 0) {
				conn.commit();
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return client;
	}
}
