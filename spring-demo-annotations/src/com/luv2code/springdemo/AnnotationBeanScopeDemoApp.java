package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		// check if they are the same
		boolean result = (theCoach == alphaCoach);
		// printout the results
		System.out.println("pointing to the same location ? :" + result);
		System.out.println("memory location for theCoach :" + theCoach);
		System.out.println("memory location for alphaCoach :" + alphaCoach);
		// close the context
		context.close();
	}

}
