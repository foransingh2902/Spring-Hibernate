package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from spring container
		// call methods on the bean
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		// call our new methods to get literal values
		System.out.println(theCoach.getTeam());
		System.out.println(theCoach.getEmailAddress());
		// close the context
		context.close();
	}

}
