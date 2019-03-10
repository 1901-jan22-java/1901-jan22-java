package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Subscriber {

	@Id @GeneratedValue
	private long id;
	private String first;
	private String last;
	private String email;
	
	
	public Subscriber(String first, String last, String email) {
		super();
		this.first = first;
		this.last = last;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Subscriber [id=" + id + ", first=" + first + ", last=" + last + ", email=" + email + "]";
	}
}
