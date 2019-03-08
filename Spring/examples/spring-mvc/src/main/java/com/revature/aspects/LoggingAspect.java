package com.revature.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

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
	
	private final Log logger = LogFactory.getLog(this.getClass());
	
	/*
	 * ADVICE
	 * Each type of advice(Before, After, AfterThrowing, 
	 * AfterReturning, Around) is the annotation itself, 
	 * NOT @Advice. S
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
	
	/*
	 * Join point - point in the application where the code
	 * (advice) will be injected. This usually happens at 
	 * method execution 
	 * 
	 * Advice - the code to be injected at the join point 
	 * 
	 * Point cut - element that deefines where advice will be 
	 * applied. 
	 * 	- execution - most common AOP pointcut, where it will 
	 * be applied at method execution 
	 * 	- within - limits method execution within data types
	 * 	- this - limits matching to joinpoints where 
	 * reference is of a given type
	 * 	- target - limits matching to JPs where the target object
	 * is of the given type 
	 * - args - limitsmatching to JPs where the arguments are
	 * instances of the given type 
	 * 
	 * Target object - the object being advised. 
	 * 
	 */
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
	public Object doThings(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("method started");
		Object o = pjp.proceed();
		logger.info("method completed");
		return o;
	}
	
	@Pointcut("execution(* com.revature.*.*.*(..))")
	public void everywhere() {}
	
}
