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
	/*
	 * This class is used to establish connections with the database
	 * Uses lazy singleton design pattern to return
	 * the same single connection factory each time 
	 * 
	 * In order to establish a connection, we need 4 things:
	 * Driver(ojdbc), Location of url (AWS endpoint or locolhost)
	 * username, password
	 * */
	
	final static Logger logger = Logger.getLogger(ConnectionFactory.class);
	
	private static ConnectionFactory cf = null;
	
	private ConnectionFactory() {
		logger.info("INSTANTIATED CONNECTION FACTORY");
	}
	
	public static synchronized ConnectionFactory getInstance(){
		if(cf == null)
		{
			cf = new ConnectionFactory();
		}
		logger.info("RETURNING CF INSTANCE " + cf.getClass());
		return cf;
	}
	
	/*
	 * Connection (1/5 key interfaces of the JPBC API)
	 * -manages our connection to (session with) the db
	 * -allows us to execute SQL queries and return results
	 * -allows us to update the DB via DML commands
	 * -has information about the DB tables, stored procedures, and other details. Use the getMetaData() method
	 * */
	
	public Connection getConnection()
	{
		Connection conn = null;
		Properties prop = new Properties();
		String filepath = "src/main/resources/db.properties";
		try {
			prop.load(new FileReader(filepath));
			Class.forName(prop.getProperty("driver"));
			//the prop.getproperty is returning our driver class
			/*
			 * the drivermanager provides a basic service for managing a set of JDBC drivers.
			 * */
			conn= DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("pwd"));
					
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
