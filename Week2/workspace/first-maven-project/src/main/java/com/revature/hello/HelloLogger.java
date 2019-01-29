package com.revature.hello;

import org.apache.log4j.Logger;

public class HelloLogger {
	
	final static Logger logger = Logger.getLogger(HelloLogger.class);
	
	public static void main(String[] args)
	{
		logger.debug("This is debug");
		logger.info("This is info");
		logger.warn("This is warn");
		logger.error("This is error");
		logger.fatal("This is fatal");
		logger.trace("This is trace");
	}
	
	static String method1(String param){
		return ("Method param:" + param);
	}
}
