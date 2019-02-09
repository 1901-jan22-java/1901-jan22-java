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
	
	private final static Logger logger = Logger.getLogger(ConnectionFactory.class);
	private static ConnectionFactory cf = null;
	
	private ConnectionFactory() {
		logger.info("INITIATED CONNECTIONFACTORY");
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(cf == null) {
			cf = new ConnectionFactory();
		}
		logger.info("RETURNING CONNECTIONFACTORY INSTANCE " + cf.getClass());
		return cf;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		
		Properties prop = new Properties();
		String filepath = "src/main/resources/db.properties";
		
		try {
			prop.load( new FileReader(filepath) );
			Class.forName( prop.getProperty("driver") );
			
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("pwd")
					);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public Logger getLogger() {
		return logger;
	}
	
}
