package util;



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
	 * This class is used to testablish connections
	 * with the database
	 * Uses Lazy singleton design pattern to return the same single connectionfactory each time
	 * 
	 * In order to establish a connection we need 4 things: Driver(ojdbc), location of url (AWS endpoint or localhost), username,pwd
	 * 
	 * 
	 * 
	 * 
	 */
	
//	final static Logger logger = Logger.getLogger(ConnectionFactory.class);
	
	
	
	
	
	private static ConnectionFactory cf = null;
	
	private ConnectionFactory() {
		
	}
	
	public static synchronized ConnectionFactory getInstance() {
	if(cf == null) {
		
		cf = new ConnectionFactory();
	}
	//logger.info("RETURNING CF INSTANCE " + cf.getClass());
	return cf;
	}
	/*
	 * Connection (1/5 interfaces of the JPBC API
	 * - manages our connection to session with the db 
	 *  allows us to execute sql queries and return results
	 *  allows us to update the db via DML commands
	 *- has information about the db table, stored procedures,
	     and other details. Use getMetaData() method
	*/ 
	
	
	
	
	
	
 public Connection getConnection() {
	 
	 Connection conn = null;
	 Properties prop = new Properties();
	 String filepath = "C:/Users/Hashio/my_git_repos/1901-jan22-java/Andrew_Simmons_Code/javawebworkspace/bankapp2/src/main/resources/db.properties";
	 
	 
	 try {
		 prop.load(new FileReader(filepath));
		 Class.forName(prop.getProperty("driver"));
		 conn = DriverManager.getConnection(
				 
				 prop.getProperty("url"),
				 prop.getProperty("username"),
				 prop.getProperty("pwd"));
				 
				 
	 } catch (FileNotFoundException e)
	 {
		 
		 e.printStackTrace();
	 } catch (IOException e) {
		 e.printStackTrace();
	 }catch (ClassNotFoundException e) {
		 e.printStackTrace();
	 }
	 catch ( SQLException e) {
		 e.printStackTrace();
	 }
	 
	 
	 
	 return conn;
 }
	
	
	
	
	
	
	
	
	
	
	
}
