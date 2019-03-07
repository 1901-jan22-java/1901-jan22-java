package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //makes this class a controller -- can handle HTTP requests 
@RequestMapping("/home") //all requests starting with /home will come here
public class HomeController {
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody //necessary annotation when using @Controller to indicate that what is returned from this method is the response body and not the name of a resource to be resolve
	public String home() {
		return "Welcome to Spring MVC!";
	}

}
