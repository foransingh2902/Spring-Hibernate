package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my DB work: Adding an account");
// getClass() gives us the class name for display
}

	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
}
