package com.revature.hello;

import org.apache.log4j.Logger;

public class HelloLogger {

	private static final Logger logger = Logger.getLogger(HelloLogger.class);

	public static void main(String[] args) {

		logger.trace("this is trace");
		logger.debug("This is debug");
		logger.info("This is info");
		logger.warn("This is warn");
		logger.error("this is an error");
		logger.fatal("This is fatal");

	}

}
