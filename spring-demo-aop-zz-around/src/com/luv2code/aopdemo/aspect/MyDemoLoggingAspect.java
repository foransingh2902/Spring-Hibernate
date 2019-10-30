package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

// add a new advice for @AfterReturning on the findAccounts

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @Around on method :" + method);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// now, let's execute the method
		Object result = theProceedingJoinPoint.proceed();

		// get end timestamp
		long end = System.currentTimeMillis();

		// compute duration and display it
		long duration = end - begin;
		// convert milliseconds to seconds
		System.out.println("\nDuration :" + duration / 1000 + " seconds");
		// return result to the calling program
		return result;
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @After (finally) on method :" + method);

	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @AfterThrowing on method :" + method);
		// log the exception
		System.out.println("\n=======>>> the exception is  :" + theExc);
	}

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFingAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {// 'result' same as used
																								// above
// print out which method we are advising on. toShortString() will be giving the method name
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @AfterReturning on method :" + method);
// print out the results of the method call
		System.out.println("\n=======>>> result is :" + result);

		// let's post-process the data... let's modify it.
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result); // created below

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		for (Account tempAccount : result) {
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			// update the name on the account
			tempAccount.setName(theUpperName);
		}
		// get uppercase version of name
		// update the name on the account

	}
// must use fully qualified name to access the utility class containing Pointcut declarations
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=======>>>>> execution @Before advice on addAccount");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		// this will call toString() for the methodSignature
		System.out.println("Method Signature : " + methodSignature);

		// display method arguments
		// get args
		Object[] args = theJoinPoint.getArgs();
		// loop through args
		for (Object tempArg : args) {
			System.out.println(tempArg);
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				System.out.println("account name : " + theAccount.getName());
				System.out.println("account level : " + theAccount.getLevel());
			}
		}
	}

}
