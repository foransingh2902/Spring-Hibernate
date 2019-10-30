package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container. the default name is decapitalized version
		// of the original class. We can give our own name.
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("\n Main program: AroundDemoApp");
		System.out.println("calling getFortune");
		String data = theFortuneService.getFortune();
		System.out.println("\nMy fortune is :" + data);
		System.out.println("finished");
		// close the context
		context.close();

	}

}
