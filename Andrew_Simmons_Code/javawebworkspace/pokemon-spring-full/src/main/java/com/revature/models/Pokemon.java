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
@Table(name="poke_dex")
public class Pokemon {
	/*
	 * POKE-DEX TABLE  -
	PK - POKEMON_ID not null
	PokemonPicture not null
	PokemonNumber  not null
	PokemonName not null
	PokemonType not null
	PokemonType2  
	Pokemon_Evolution (optional)
	 * */
	
	@Id
	@Column(name="POKEMON_ID")
	@SequenceGenerator(name="P_SEQ_GEN", sequenceName="P_SEQ", allocationSize=1)
	@GeneratedValue(generator="P_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="Pokemon_number", nullable=false)
	private int PokemonNumber;
	
	@Column(name="Pokemon_name", nullable=false)
	private String PokemonName;
	
	@Column(name="Pokemon_picture", nullable=false)
	private String PokemonPicture;
	
	@Column(name="Pokemon_type", nullable=false)
	private String PokemonType;
	
	@Column(name="Pokemon_type2")
	private String PokemonType2;

	public Pokemon() { }
	
	public Pokemon(int id, int pokemonNumber, String pokemonName, String pokemonPicture, String pokemonType,
			String pokemonType2) {
		super();
		this.id = id;
		PokemonNumber = pokemonNumber;
		PokemonName = pokemonName;
		PokemonPicture = pokemonPicture;
		PokemonType = pokemonType;
		PokemonType2 = pokemonType2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPokemonNumber() {
		return PokemonNumber;
	}

	public void setPokemonNumber(int pokemonNumber) {
		PokemonNumber = pokemonNumber;
	}

	public String getPokemonName() {
		return PokemonName;
	}

	public void setPokemonName(String pokemonName) {
		PokemonName = pokemonName;
	}

	public String getPokemonPicture() {
		return PokemonPicture;
	}

	public void setPokemonPicture(String pokemonPicture) {
		PokemonPicture = pokemonPicture;
	}

	public String getPokemonType() {
		return PokemonType;
	}

	public void setPokemonType(String pokemonType) {
		PokemonType = pokemonType;
	}

	public String getPokemonType2() {
		return PokemonType2;
	}

	public void setPokemonType2(String pokemonType2) {
		PokemonType2 = pokemonType2;
	}
}