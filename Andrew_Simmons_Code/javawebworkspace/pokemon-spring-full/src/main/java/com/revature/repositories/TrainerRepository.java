package com.revature.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Trainer;

@Repository("trainerRepository")
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

	Trainer findByUsernameIgnoreCase(String username);
	
}