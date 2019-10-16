package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//  this is the bean id
//  spring will automatically register the bean
// @Component("thatSillyCoach")
//  this will now use the default bean id---"tennisCoach"
@Component
//@Scope("prototype")  will create a new instance everytime
public class TennisCoach implements Coach {
	// will work even with private fields. this will
	// field injection. first default constructor is called
	// then inject FortuneService implementation directly into the class
	// using a java technology called reflection
	@Autowired
	@Qualifier("randomFortuneService") // specify the class name @Qualifier("happyFortuneService")
	private FortuneService fortuneService;

// create a constructor in your class for injections 
	// Spring will scan for a component that implements FortuneService interface
	// our example: HappyFortuneService meets the requirement
	/*
	 * @Autowired public TennisCoach(FortuneService theFortuneService) {
	 * fortuneService = theFortuneService; }
	 */
	// define a default constructor
	public TennisCoach() {
		System.out.println("TennisCoach default constructor");
	}

	// define a setter method
	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println(">>TennisCoach: inside setFortuneService");
	 * this.fortuneService = fortuneService; }
	 */
	// this will work for every method name
	/*
	 * @Autowired public void doSomeService(FortuneService fortuneService) {
	 * System.out.println(">>TennisCoach: inside doSomeService");
	 * this.fortuneService = fortuneService; }
	 */

	// define my init method
	// code will execute after constructor and after injection of dependencies
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}

	// define my destroy method.
	// code will execute before bean is destroyed
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">>TennisCoach: inside of doMyCleanupStuff");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}


	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
