package associate_project.Associate;

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
 * this class is used to establish connections with the DB it uses a lazy singleton design pattern to return the same single 
 * connectionfactory each time in order to establish a connection
 * we need:Driver(ojdbc),location of url(AWS endpoint),username,passowrd
 */
	final static Logger logger= Logger.getLogger(ConnectionFactory.class);
	private static ConnectionFactory cf=null;
	private ConnectionFactory(){
		logger.info("Instantiated connection factory");
	}
	public static synchronized ConnectionFactory getInstance(){
		if(cf==null){
			cf=new ConnectionFactory();
		}
		logger.info("Returning connection factory instance"+cf.getClass());
		return cf;
	}
	public Connection getConnection(){
		Connection conn=null;
		Properties prop=new Properties();
		String filePath= "db.properties";
		try{
		prop.load(new FileReader(filePath));
		Class.forName(prop.getProperty("driver"));
		conn=DriverManager.getConnection(
				prop.getProperty("url"),
				prop.getProperty("username"),
				prop.getProperty("pwd"));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
		e.printStackTrace();	
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
		
	}}
