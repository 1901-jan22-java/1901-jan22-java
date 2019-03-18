package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Trainer;
import com.revature.repositories.TrainerRepository;

@Service
@Transactional
public class TrainerService {
	
	@Autowired
	private TrainerRepository trainerRepo;
	
	public Trainer add(Trainer t) {
		return trainerRepo.save(t);
	}
	
	public Trainer findByUsername(String username) {
		System.out.println("in find by username");
		return trainerRepo.findByUsernameIgnoreCase(username);
	}

	public List<Trainer> getAll() {
		return (List<Trainer>) trainerRepo.findAll();
	}
	
	
	
	
	
	
	
	
}