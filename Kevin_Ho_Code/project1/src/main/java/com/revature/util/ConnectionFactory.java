package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	final static Logger logger = Logger.getLogger(ConnectionFactory.class);
	
	private static ConnectionFactory cf = null;
	
	private ConnectionFactory() {
		logger.info("INSTANTIATED CONNECTION FACTORY");
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(cf == null) {
			cf = new ConnectionFactory();
		}
		logger.info("RETURNING CF INSTANCE " + cf.getClass());
		return cf;
	}

	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		String filepath = "C:/Users/Kevin's MemeMachine/Documents/my_git_repos/1901-jan22-java/Kevin_Ho_Code/project1/src/main/resources/db.properties";
		try {
			prop.load(new FileReader(filepath));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
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
			System.err.println("Lost connection");
			e.printStackTrace();
		}
		return conn;
	}
}
