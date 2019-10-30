package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	// best practice is to give the class name to the logger to be used as logger
	// name. as the main method is static so we need to make the logger static.
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container. the default name is decapitalized version
		// of the original class. We can give our own name.
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info("\n Main program: AroundDemoApp");
		myLogger.info("calling getFortune");
		boolean tripWire = true;
		// as tripWire=true, this will throw an exception
		String data = theFortuneService.getFortune(tripWire);
		myLogger.info("\nMy fortune is :" + data);
		myLogger.info("finished");
		// close the context
		context.close();

	}

}
