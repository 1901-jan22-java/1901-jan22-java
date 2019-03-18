package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Team;

@Repository("teamRepository")
public interface TeamRepository extends JpaRepository<Team, Integer> {
	
//	Team findBytrainerIdIgnoreCase(String username);
	
}