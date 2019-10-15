package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	private FortuneService tuuktuuk;
// add new fields for email address and team
	private String emailAddress;
	private String team;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("inside setter for email");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("inside setter for team");
		this.team = team;
	}


	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice fast bowling for 15 minutes";
	}


	public FortuneService getTuuktuuk() {
		return tuuktuuk;
	}

	public void setTuuktuuk(FortuneService tuuktuuk) {
		this.tuuktuuk = tuuktuuk;
	}

	@Override
	public String getDailyFortune() {
		// before the mapping its linking to the prototype inside the interface
		return tuuktuuk.getFortune();
	}

}
