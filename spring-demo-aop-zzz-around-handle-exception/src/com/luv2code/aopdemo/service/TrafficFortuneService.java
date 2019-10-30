package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			// simulate a delay. Will sleep for 5 seconds
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return a fortune
		return "expect heavy traffic today";
	}

	public String getFortune(boolean tripWire) {
		// TODO Auto-generated method stub
		if (tripWire) {
			throw new RuntimeException("Major accident! Highway is closed!\n\n");
		}
		// reusing the code from above
		return getFortune();
	}
}
