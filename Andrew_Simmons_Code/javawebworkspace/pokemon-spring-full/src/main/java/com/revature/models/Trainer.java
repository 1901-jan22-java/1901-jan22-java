package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@Entity
@Table(name="pokemon_trainers")
public class Trainer {
	
	@Id
	@Column(name="TRAINER_ID")
	@SequenceGenerator(name="PT_SEQ_GEN", sequenceName="PT_SEQ", allocationSize=1)
	@GeneratedValue(generator="PT_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;

	public Trainer() {}
	
	public Trainer(int id, String username, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}