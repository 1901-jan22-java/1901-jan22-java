package com.jdbc.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionFactory {

	//This class is used to establish connections with the database
	//Uses a lazy singleton design pattern to return the same single
	// connection factory each time.
	// In order to establish a connection, we need 4 things
	
	//Driver(ojdbc)
	//Locations of URL(AWS Endpoint or localhost)
	//Username
	//Password
	
	final static Logger logger = Logger.getLogger(ConnectionFactory.class);
	
	private static ConnectionFactory cf = null;
	
	private ConnectionFactory() {
		
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(cf == null){
			cf = new ConnectionFactory();
		}
		logger.info("Returning CF Instance " + cf.getClass());
		return cf;
	}
	
	/*
	 * Connection (1/5 key interfaces of the JDBC API)
	 * Manages our connection to (session) the DB
	 * Allows us to execute SQL queries and return results
	 * Allows us to update the DB via DML commands
	 * has information about the db tables, store procedures
	 * and other details, Use the getMetaData() method
	 */
	
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		String filepath = "src/main/resources/db.properties";
		
		try {
			prop.load(new FileReader(filepath));
			Class.forName(prop.getProperty("driver")); // prop.getProperty is returning the driver class
			// The driver manager provides basic service for managing a set of jdbc drivers 
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("pwd"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
