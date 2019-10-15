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

}
