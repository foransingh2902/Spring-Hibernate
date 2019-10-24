package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container. the default name is decapitalized version
		// of the original class. We can give our own name.
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		System.out.println();
		theAccountDAO.doWork();

		// do it again!
		System.out.println("\n calling it for MembershipDAO");
		// call the business method again
		theMembershipDAO.addAccount();
		System.out.println();
		theMembershipDAO.goToSleep();

		// close the context
		context.close();

	}

}
