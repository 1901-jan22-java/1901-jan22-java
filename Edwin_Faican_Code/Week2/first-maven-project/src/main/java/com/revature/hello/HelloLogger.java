package com.revature.hello;

import org.apache.log4j.Logger;

public class HelloLogger {
	final static Logger logger = Logger.getLogger(HelloLogger.class);
	
	public static String method1(String param) {
		return "Method param" + param;
	}
	
	public static void main(String[] args) {
		logger.trace("This is a trace");
		logger.debug("This is debug " + method1(" testing"));
		logger.info(method1("Boop"));
		logger.warn("This is a warning!");
		logger.error("This is an error");
		logger.fatal("This is a fatal message");
	}
}
