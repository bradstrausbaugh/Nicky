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
}
