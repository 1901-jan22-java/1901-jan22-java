package com.revature.aspects;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LoggingAspect {
	
	final static Logger logger = Logger.getLogger(LoggingAspect.class);
	
	@Before("everywhere()")
	public void testAdvice(JoinPoint jp) {
		/*
		 * Inside of your Aspect class, you have a series 
		 * of methods which will serve as your Advice
		 * These methods will contain functionality
		 * that you wish to apply to your application 
		 * at runtime 
		 */
		
		logger.info("EXECUTING METHOD: " + jp.getSignature()
		+"\nTarget Object: " + jp.getTarget()
		+ "\nKind: " + jp.getKind());
	}
	
	@After("execution(* com.revature.controllers.*.*(..))")
	public void sentResponse(JoinPoint jp) {
		logger.info("Handled Request to method " + jp.getArgs());
	}
	
	@Around("everywhere()")
	public Object timer(ProceedingJoinPoint pjp) throws Throwable {
		
		logger.info("method started");
		Object o = pjp.proceed();
		
		logger.info("method completed");
		return o;
	}
	
	@Pointcut("execution(* com.revature.*.*.*(..))")
	public void everywhere() {}
	
	
	
	
		
	}


