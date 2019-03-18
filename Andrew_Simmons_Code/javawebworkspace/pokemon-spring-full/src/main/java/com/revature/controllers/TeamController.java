package com.revature.controllers;


import java.util.List;

import javax.validation.Valid;

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
public class TeamController {

	@Autowired
	private TeamService service;
	@Autowired
	private TrainerService tservice;
	
	@RequestMapping(value="/teams", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> add(@RequestBody Team team){
		Team t = service.add(team);
		if(t == null) return new ResponseEntity<Team>(HttpStatus.CONFLICT);
		return new ResponseEntity<Team>(t, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/teams/id={name}", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> findByUsername(@PathVariable String name){
		Trainer trainer = tservice.findByUsername(name);
		Team t = service.findByUsername(trainer);
		return new ResponseEntity<Team>(t, HttpStatus.OK);
	}
	
	
	
	//PUT
	@RequestMapping(method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> update(@RequestBody Team t){
		Team team = service.update(t);
		if(team == null) {
			return new ResponseEntity<Team>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Team>(t, HttpStatus.ACCEPTED);
	}
	
	//DELETE
	@RequestMapping(method=RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Team> delete(@RequestBody Team u) {
		u = service.delete(u);
		if(u==null) {
			return new ResponseEntity<Team>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Team>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	
	
	
	
}