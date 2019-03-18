package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.User;
import com.revature.models.Team;
import com.revature.models.Trainer;
import com.revature.repositories.TeamRepository;

@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepo;
	
	public Team add(Team t) {
		return teamRepo.save(t);
	}
	
	public Team findByUsername(Trainer trainer) {
		System.out.println("in find by username");
		return teamRepo.findBytrainer(trainer);
	}
	
	public Team remove(remove t) {
		return teamRepo.delete(id);
	}
	
	
	public Team delete(Team t) {
		int id=-1;
		for(Team team : Team) {
			if(team.getId()==u.getId()) {
				id=team.indexOf(team);
			}
		}
		if(id>-1) {
			users.remove(id);
			return null; //this means a user was found and deleted
		}
		else return t;
	}
	
	
	public Team update(Team t) {
		Team removed = getById(u.getId());
		if(removed == null) return null;
		team.remove(removed);
		teams.add(u);
		return t;
	}
	
	public User delete(User u) {
		int id=-1;
		for(User user : users) {
			if(user.getId()==u.getId()) {
				id=users.indexOf(user);
			}
		}
		if(id>-1) {
			users.remove(id);
			return null; //this means a user was found and deleted
		}
		else return u;
	}
	
}