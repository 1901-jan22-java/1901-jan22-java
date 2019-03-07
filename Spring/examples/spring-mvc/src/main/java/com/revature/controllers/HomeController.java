package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String home() {
		return "Welcome to Spring MVC";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{name}")
	@ResponseBody
	public String anotherGetRequest(@PathVariable String name) {
		return "Welcome home, " + name;
	}
}
