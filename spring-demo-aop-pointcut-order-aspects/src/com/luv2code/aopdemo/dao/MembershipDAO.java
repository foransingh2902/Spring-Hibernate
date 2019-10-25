package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public boolean addAccount() {
		System.out.println(getClass() + " :Doing stuff: Adding a membership account");
		return false;
	}

	public void goToSleep() {
		System.out.println(getClass() + " :In the sleep method of class");
	}
}
