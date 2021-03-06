package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	// same name as given in DemoSecurityConfig.java
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		// will be appended with prefix and suffix depending upon our mapping
		return "plain-login";
	}
}
