package com.revature.hello;

import org.apache.log4j.Logger;

public class helloLogger {

	final static Logger logger = Logger.getLogger(helloLogger.class);
	public static void main(String[] args) {
		logger.info("In hello logger class");
		logger.debug("This is debug");
		logger.warn("This is warn");
		logger.error("This is error");
		logger.fatal("This is fatal");
		logger.trace("This is trace");
	}
	static String method1(String param) {
		return ("Method param: " + param);
	}
}
