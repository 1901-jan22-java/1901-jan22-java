package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import oracle.jdbc.driver.OracleDriver;

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
		try {
			// Interesting tidbit from Java Doc:
			// Applications no longer need to explictly load JDBC drivers using Class.forName(). 
			// Existing programs which currently load JDBC drivers using Class.forName() 
			// will continue to work without modification.
			conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@demo1901jan22rds.ctcx38zwi7iv.us-east-1.rds.amazonaws.com:1521:ORCL",
						"demo1901jan22rds",
						"X7B9GXr#uPn%siF*qrVR5NqJRBBvIy"
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getInstance().getConnection();
	}
	
}
