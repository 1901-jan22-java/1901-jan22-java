package com.revature.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class HomeController {

	@RequestMapping("/")
	public String test() {
		return "Welcome to Flavor Town. I'm Kevin";
	}
	
	@RequestMapping("/test")
	public String test2() {
		return "nani";
	}
	
}
