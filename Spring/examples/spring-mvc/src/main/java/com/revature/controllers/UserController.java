package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

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


/*
 * Now, we take a look at @RestController
 * Which, as does @Controller, registers a class
 * as a controller (can handle HTTP requests)
 * One difference is that because @Controller can 
 * return view names, we must annotate every 
 * method that returns an actual HTTP response 
 * (and not a view name to then be resolved) 
 * with @ResponseBody, whereas, with @RestController
 * we do not
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;
	
	//GET /users 
	@RequestMapping(method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getall(){
		return service.getAll();
	}
	
	//GET /users/{id}
	@RequestMapping(value="/{id}",
			method=RequestMethod.GET,
		produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findById(@PathVariable int id) {
		User u = service.getById(id);
		if(u==null) {
			//user is null, return null/no resp body with a Http status of no content
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		else {
			//all good, return user w status of ok
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}	
	}
	
	@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE, 
					produces=MediaType.APPLICATION_JSON_VALUE,
					method=RequestMethod.POST)
	public ResponseEntity<User> add(@RequestBody @Valid User u) {
		User user = service.save(u);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User u) {
		User user = service.update(u);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE, 
			method=RequestMethod.DELETE)
	public ResponseEntity<User> delete(@RequestBody User u) {
		User user = service.delete(u.getId());
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.I_AM_A_TEAPOT);
		}
	}

}
