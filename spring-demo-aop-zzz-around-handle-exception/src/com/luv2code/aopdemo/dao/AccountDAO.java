package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;

	// add anew method : findAccounts()
	public List<Account> findAccounts(boolean tripwire) {

		// for academic purpose ... simulate an exception
		if (tripwire == true) {

			throw new RuntimeException("No Soup for you!!!");
		}
		List<Account> myAccounts = new ArrayList<Account>();
		// create sample accounts
		Account temp1 = new Account("john", "silver");
		Account temp2 = new Account("madhu", "platinum");
		Account temp3 = new Account("luca", "gold");
		// add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		return myAccounts;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}


	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my DB work: Adding an account");
// getClass() gives us the class name for display
}

	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}
}
