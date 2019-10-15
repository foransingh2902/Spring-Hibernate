package com.luv2code.springdemo;

public class MyApp {
// software engineering best practice-> Code to an interface
	// we will design an interface that all coaches will support
	// as every coach will have an method- getDailyWorkout, therefore we will
	// pass it into an interface
	public static void main(String[] args) {
		// create the object using interface reference
		// we are coding to the interface, not to the implementation
		Coach theCoach = new TrackCoach();
		// use the object
		System.out.println(theCoach.getDailyWorkout());

	}

}
