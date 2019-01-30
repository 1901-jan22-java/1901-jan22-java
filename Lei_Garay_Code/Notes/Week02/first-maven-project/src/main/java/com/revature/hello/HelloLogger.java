package com.revature.hello;

import org.apache.log4j.Logger;

public class HelloLogger {
	
	final static Logger logger = Logger.getLogger(HelloLogger.class);

	public static void main(String[] args) {
		
		logger.debug	("this is debug");
		logger.info		("this is info");
		logger.warn		("this is warn");
		logger.error	("this is an error");
		logger.fatal	("this is fatal");
		logger.trace	("this is trace");
	}
	
	static String method01(String param) {
		
		return ("Method01 param: " + param);
	}
}
