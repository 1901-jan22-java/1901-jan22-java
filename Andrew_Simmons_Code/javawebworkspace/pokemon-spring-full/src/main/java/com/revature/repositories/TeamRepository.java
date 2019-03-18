package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Team;
import com.revature.models.Trainer;

@Repository //("teamRepository")
public interface TeamRepository extends JpaRepository<Team, Integer> {
	
	Team findBytrainer(Trainer t);
	
}