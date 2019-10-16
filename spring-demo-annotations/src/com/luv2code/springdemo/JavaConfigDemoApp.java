package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring java config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);// your
																												// java
																												// configuration
																												// class
		// get the bean from spring container
		// Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		// the above one uses the default name which is basically the class name with
		// first alphabet in lower case
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call method to get daily fortune
		// here we used @Autowired to map our dependency, and @Component that matches
		// that provides the implementation will we used.
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
	}

}
