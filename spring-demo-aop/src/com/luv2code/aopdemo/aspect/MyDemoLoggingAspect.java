package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advices for logging
	// let's start with an @Before advice
	// the blue part is pointcut expression
	// @Before("execution(public void addAccount())")
	// will be called before every method name that matches the blueprint
	// @Before("execution(public void addAccount())")
	// using full qualified name to match to a specific class method
	// @Before("execution(public void
	// com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	// any method whose method name starts with 'add'
	// @Before("execution(public void add*())")
	// modifier is optional so we removed 'public'
	// @Before("execution(* add*())")
	// have given the fully qualified name to make an argument of 'Account' type ""
	// @Before("execution(* add*(com.luv2code.aopdemo.Account))")
	// after Account type argument now we can have zero or more argument of any type
	// @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	// match on any parameters
	// @Before("execution(* add*(..))")

	// matches methods in a Package com.luv2code.aopdemo.dao
	// .* for any class and .* for any method
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======>>>>> execution @Before advice on addAccount");
		// run this code BEFORE-target object method: "public void addAccount()"
	}
}
