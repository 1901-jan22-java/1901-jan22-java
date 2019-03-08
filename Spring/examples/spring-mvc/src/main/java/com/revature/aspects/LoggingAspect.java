package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

public class LoggingAspect {
	final static Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@After("execution(* com.revature.*.*.*(..))")
	public void testAdvice(JoinPoint jp) {
		logger.info("Executing method: " + jp.getSignature());
	}
}
