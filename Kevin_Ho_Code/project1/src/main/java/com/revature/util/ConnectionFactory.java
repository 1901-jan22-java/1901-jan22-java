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
		logger.debug("Instantiated Connection Factory");
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(cf == null) {
			cf = new ConnectionFactory();
			
		}
		logger.debug("Returning cf instance " + cf.getClass());
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		String filepath = "../../../../resources/db.properties";
		
		try {
			prop.load(new FileReader(filepath));
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}