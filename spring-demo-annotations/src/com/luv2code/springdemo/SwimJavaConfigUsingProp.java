package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigUsingProp {

	public static void main(String[] args) {
		// read spring java config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);// your
																												// java
																												// configuration
																												// class
		// get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		// the name used above is the name of id given with @Bean
		System.out.println(theCoach.getDailyWorkout());

		// call method to get daily fortune
		// here we used @Autowired to map our dependency, and @Component that matches
		// that provides the implementation will we used.
		System.out.println(theCoach.getDailyFortune());
		// call our new swim coach methods... has the props values injected
		System.out.println("email :" + theCoach.getEmail());
		System.out.println("team :" + theCoach.getTeam());

		// close the context
		context.close();
	}

}
