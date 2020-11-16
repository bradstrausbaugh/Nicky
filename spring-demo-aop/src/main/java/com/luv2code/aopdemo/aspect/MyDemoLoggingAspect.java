package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related sdvices for logging
	
	// let's start with an @Before advice

	// Before any call to a method that matches this signature... 
	// later we'll see variations on these Pointcut Expressions
	// @Before("execution(public void addAccount())")  // any class here - more later
	// now for class-specific ...
	// @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")  // any class here - more later
	@Before("execution(public void add*())")  // any class here - any method starting w 'add'
	public void beforeAddAccountAdvice() {  // this can be named anything
		System.out.println("\n=====>>> Executing @Before advice on add*()");
	}
	
	/*
	 * Additionally, you can match to the number of arguments - shown below but I didn't implement these
	 * 
	 * ()    for no arguments
	 * (*)   for one argument of any type
	 * (..)  for 0 or more arguments of any type
	 * 
	 * ... plus you can variate these ... like this for example ...
	 * 
	 * @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	 *   // here, any return type, any class, any method, any or no parameters
	 *   // - but mb from the com.luv2code.aopdemo.dao package
	 *   
	 *   // - and remember: you use the full-qualified class name for non-primitive types
	 * 
	 */

}
