package com.revature.beans;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="pokemon_team")
public class Team {

	/*
	 * POKEMON TEAM BUILDER TABLE-
	PK - PKTeamID not null
	FK - USERID not null
	FK - POKEMON_ID not null
	Pokemon_One not null
	Pokemon_Two
	Pokemon_Third
	Pokemon_Four
	Pokemon_Five 
	 */
	
	@Id
	@Column(name="TEAM_ID")
	@SequenceGenerator(name="T_SEQ_GEN", sequenceName="T_SEQ", allocationSize=1)
	@GeneratedValue(generator="T_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	//@Min(value=0)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="TRAINER_ID", nullable=false)
	private Trainer trainerId;
	
	@OneToOne
	@JoinColumn(name="SLOT_ID1")
	private Pokemon slot1;
	
	@OneToOne
	@JoinColumn(name="SLOT_ID2")
	private Pokemon slot2;
	
	@OneToOne
	@JoinColumn(name="SLOT_ID3")
	private Pokemon slot3;
	
	@OneToOne
	@JoinColumn(name="SLOT_ID4")
	private Pokemon slot4;
	
	@OneToOne
	@JoinColumn(name="SLOT_ID5")
	private Pokemon slot5;
	
	@OneToOne
	@JoinColumn(name="SLOT_ID6")
	private Pokemon slot6;

	public Team() {}
	
	public Team(Trainer trainerId, Pokemon slot1, Pokemon slot2, Pokemon slot3, Pokemon slot4, Pokemon slot5,
			Pokemon slot6) {
		super();
		this.trainerId = trainerId;
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.slot3 = slot3;
		this.slot4 = slot4;
		this.slot5 = slot5;
		this.slot6 = slot6;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Trainer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Trainer trainerId) {
		this.trainerId = trainerId;
	}
	
	public Pokemon getSlot1() {
		return slot1;
	}

	public void setSlot1(Pokemon slot1) {
		this.slot1 = slot1;
	}

	public Pokemon getSlot2() {
		return slot2;
	}

	public void setSlot2(Pokemon slot2) {
		this.slot2 = slot2;
	}

	public Pokemon getSlot3() {
		return slot3;
	}

	public void setSlot3(Pokemon slot3) {
		this.slot3 = slot3;
	}

	public Pokemon getSlot4() {
		return slot4;
	}

	public void setSlot4(Pokemon slot4) {
		this.slot4 = slot4;
	}

	public Pokemon getSlot5() {
		return slot5;
	}

	public void setSlot5(Pokemon slot5) {
		this.slot5 = slot5;
	}

	public Pokemon getSlot6() {
		return slot6;
	}

	public void setSlot6(Pokemon slot6) {
		this.slot6 = slot6;
	}

	@Override
	public String toString() {
		return "Team [userId=" + trainerId + ", slot1=" + slot1 + ", slot2=" + slot2 + ", slot3=" + slot3 + ", slot4="
				+ slot4 + ", slot5=" + slot5 + ", slot6=" + slot6 + "]";
	}
	
	
}