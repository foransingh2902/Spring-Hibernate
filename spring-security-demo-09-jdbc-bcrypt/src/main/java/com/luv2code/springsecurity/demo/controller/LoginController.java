package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	// same name as given in DemoSecurityConfig.java
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		// will be appended with prefix and suffix depending upon our mapping
		return "fancy-login";
	}

	// add request mapping for /access-denied
	// can also place this one in DemoController instead of here.
	// just placing it here considering it related to security
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		// will be appended with prefix and suffix depending upon our mapping
		return "access-denied";// can have any other name also
	}
}
