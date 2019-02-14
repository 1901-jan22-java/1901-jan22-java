package com.jdbc.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	
	private static Logger log = Logger.getLogger(ConnectionFactory.class);
	private static ConnectionFactory cf;
	
	private ConnectionFactory() {
		log.info("INITIATED CONNECTIONFACTORY");
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(cf == null) {
			cf = new ConnectionFactory();
		}
		log.info("RETURNING CONNECTIONFACTORY INSTANCE: " + cf.getClass());
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
			log.error("FileNotFoundException in getConnection()", e);
		} catch(IOException e) {
			log.error("IOException in getConnection()", e);
		} catch(ClassNotFoundException e) {
			log.error("ClassNotFoundException in getConnection()", e);
		}
		
		return conn;
	}
	
}
