package com.revature.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Trainer;


@Repository("trainerRepository")
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

//	Trainer findByUsernameIgnoreCase(String username);
	

	
	
}