package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping(
		method=RequestMethod.GET,
		produces=MediaType.APPLICATION_JSON_VALUE
	)
	public List<User> getall() {
		return service.getAll();
	}
	
	@RequestMapping(
		value="/{id}",
		method=RequestMethod.GET,
		produces=MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<User> getById(@PathVariable int id) {
		User u = service.getById(id);
		if(u==null) {
			return new ResponseEntity<User>(u, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
	
	@RequestMapping(
			consumes=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<User> add(@RequestBody User u) {
		User u1 = service.save(u); // Could add server-side validation 
		if(u1 == null) {
			// pretend there's some sort of validation here
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<User>(u1, HttpStatus.CREATED);
		}
	}
	
}
