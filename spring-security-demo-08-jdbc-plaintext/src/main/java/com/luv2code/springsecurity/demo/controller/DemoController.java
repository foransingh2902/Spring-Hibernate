package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
@GetMapping("/")
public String showHome() {
		return "home";
		// it will become /WEB-INF/view/home.jsp
	}
	// add request mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
		// it will become /WEB-INF/view/home.jsp
	}

	// add request mapping for /systems
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
		// it will become /WEB-INF/view/home.jsp
	}
}
