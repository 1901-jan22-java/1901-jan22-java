package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * Welcome to Spring AOP!
 * 
 * Most enterprise applications have some common 
 * cross-cutting concerns (functionality needed
 * across layers of your app). 
 * 
 */

@Aspect
@Component
public class LoggingAspect {
	
	final static Logger logger =
			Logger.getLogger(LoggingAspect.class);
	
	/*
	 * ADVICE
	 * Each type of advice(Before, After, AfterThrowing, 
	 * AfterReturning, Around) is the annotation itself, 
	 * NOT @Advice. 
	 * Following the advice annotation, comes our POINTCUT
	 * The pointcut is the set of points in execution of your 
	 * code at which you want your advice to be applied 
	 * "Where do i want this advice to happen"
	 * meanwhile the type of advice shows us "when" we 
	 * want it to happen
	 * In spring, our pointcuts represent method executions
	 * based on method names and locations
	 * below, we see that we will execute this method
	 * BEFORE the EXECUTION of methods with any(*) return
	 * type, in the com.revature base package. in any sub-package
	 * of that base package, in any class in any of those 
	 * packages, and finally, in any method in any of those
	 * classes, with any parameter list (..)
	 * 
	 */
	@Before("execution(* com.revature.*.*.*(..))")
	public void testAdvice(JoinPoint jp) {
		/*
		 * Inside of your Aspect class, you have a series 
		 * of methods which will serve as your Advice
		 * These methods will contain functionality
		 * that you wish to apply to your application 
		 * at runtime 
		 */
		System.out.println("Executing method: "+ 
				jp.getSignature());
	}
}
