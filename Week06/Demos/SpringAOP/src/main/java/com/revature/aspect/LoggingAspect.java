package com.revature.aspect;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.revature.model.SuperPet;

/*
 * This @Aspect denotes that we are using this class as an aspect which handles a cross-cutting
 * concern. In this case, our cross-cutting concern is logging. Note that we must still
 * mark this class as a component using @Component since @Aspect is not a Spring stereotype.
 */
@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGY = LogManager.getLogger(LoggingAspect.class);
	
	/*
	 * Let's define a Pointcut. A Pointcut determines where our advice will be injected.
	 * When using a Pointcut, we use what is called a "Pointcut Expression" to
	 * denote where our advice should be injected.
	 * 
	 * Note that this Pointcut targets all methods. It targets any method that has a
	 * "public" access modifier, any return type, and is located in any package.
	 */
	
	@Pointcut("execution(public * *(..))")
	public void allMethodsPointcut() {}
	
	/*
	 * This PointCut targets all methods in the service package.
	 */
	@Pointcut("within(com.revature.service.*)")
	public void targetServiceLayer() {}
	
	@Pointcut("within(com.revature.web.*)")
	public void targetWebLayer() {}
	
	/*
	 * The value here denotes that we want to inject our Before Advice at the specified
	 * Pointcut (denoted that its method name).
	 */
//	@Before(value="targetServiceLayer()")
//	/*
//	 * Note that we can use our JoinPoint to get information about the method that
//	 * is being executed. You can, for instance, get information about the method's name
//	 * and its signature.
//	 */
//	public void logBefore(JoinPoint jp) {
//		LOGGY.info("The " + jp.getSignature().getName() + " method is going to be called now.");
//	}
	
	/*
	 * After Advice is injected after the method has been executed.
	 */
//	@After(value="targetServiceLayer()")
//	public void logAfter(JoinPoint jp) {
//		LOGGY.info("The " + jp.getSignature().getName() + " method was called.");
//	}
	
	/*
	 * When using AfterReturning, we must specify the name of the object we expect
	 * to be returned (as an attribute). We must then use that name as the name
	 * of our reference when defining parameters.
	 */
	@AfterReturning(pointcut="targetServiceLayer()", returning="returnedSuperPets")
	public void logAfterReturning(JoinPoint jp, List<SuperPet> returnedSuperPets) {
		
		LOGGY.info("The " + jp.getSignature().getName() + " method was called and has returned" + returnedSuperPets + ".");

	}
	
	/*
	 * Must revisit. does not log after throwing my exception.
	 */
	@AfterThrowing(pointcut="targetWebLayer()", throwing="noSuchSuperPet")
	public void logAfterThrowingException(JoinPoint jp, Exception noSuchSuperPet) {
		
		LOGGY.info("The " + jp.getSignature().getName() + " method was called and threw an " + noSuchSuperPet + ".");

	}
	
	/*
	 * Recall that Around Advice has access to a special JoinPoint called a 
	 * ProceedingJoinPoint. It is very powerful as it injects advice both before and after
	 * a method is excecuted. It can also stop the execution of a method.
	 */
	@Around(value="targetServiceLayer()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) {
		
		/*
		 * If you do not proceed to the next method invocation, the next method will
		 * not be invoked. That said, you should use the proceed() method and return
		 * the reference to what the method should actually return.
 		 */
		Object o = null;
		try {
			LOGGY.info("This is Around Advice for the " + pjp.getSignature().getName() + " method.");
			o = pjp.proceed();
			LOGGY.info("This is Around Advice for the " + pjp.getSignature().getName() + " method.");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return o;
	}
	
	
	
}
