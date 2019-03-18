package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Team;
import com.revature.models.Trainer;
import com.revature.service.TeamService;
import com.revature.service.TrainerService;

@RestController
@CrossOrigin
public class TrainerController {

	@Autowired
	private TrainerService service;
	
	@RequestMapping(value="/trainers", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainer> add(@RequestBody Trainer user){
		Trainer u = service.add(user);
		if(u == null) return new ResponseEntity<Trainer>(HttpStatus.CONFLICT);
		return new ResponseEntity<Trainer>(u, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/trainers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainer>> findAll(){
		return new ResponseEntity<List<Trainer>>(service.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/trainers/username={name}", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trainer> findByUsername(@PathVariable String name){
		Trainer u = service.findByUsername(name);
		return new ResponseEntity<Trainer>(u, HttpStatus.OK);
	}
	
}