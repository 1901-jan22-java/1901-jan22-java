package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/*
	 * With controllers, we can have multiple of the same HTTP
	 * verb methods in the same class, HOWEVER, they cannot be 
	 * addressed to the same exact URL or else there will be 
	 * conflicts. 
	 * Using @RequestMapping with a new value allows us to 
	 * send requests to different methods in a class based 
	 * on a url pattern
	 * ie: /user = GET ALL
	 * 		/user/{id} =  GET BY ID
	 */
	@RequestMapping(method=RequestMethod.GET,
			value="/{name}")
	@ResponseBody
	public String anotherGetRequest(@PathVariable String name) {
		return "Welcome home, " + name;
	}
}
