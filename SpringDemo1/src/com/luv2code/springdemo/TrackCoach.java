package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;

	
	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}
	 
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it :" + fortuneService.getFortune();
	}

	// add an init method
	public void doMyStartupStuff() {
		// any method name
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}

	// add a destroy method
	public void doMyCleanupStuff() {
		// any method name
		System.out.println("TrachCoach: inside method doMyCleanupStuff");
	}

}
