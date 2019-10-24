package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
// 1. create pointcut declaration
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}
	// name of pointcut declaration is 'forDaoPackage', can have any name.

	// 2. apply pointcut declaration to advice
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======>>>>> execution @Before advice on addAccount");
		// run this code BEFORE-target object method: "public void addAccount()"
	}

	// Add another advice... reuse point declaration
	// using the pointcut declaration and applying to another advice
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n=======>>>>> Performing API analytics");
	}
}
