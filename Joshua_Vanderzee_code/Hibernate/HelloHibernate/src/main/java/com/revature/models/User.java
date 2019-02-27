package com.revature.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//mapping class with annotations
@Entity
@Table(name="Blog_Users")
public class User {
	
	@Id
	@Column(name="User_ID")
	@SequenceGenerator(name="U_SEQ_GEN", sequenceName="U_SEQ")
	@GeneratedValue(generator="U_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="following",
	joinColumns=@JoinColumn(name="USER_ID"),
	inverseJoinColumns=@JoinColumn(name="FOLLOWING_ID"))
	private Set<User> following = new HashSet<User>();
	
	@Column(nullable=false, unique=true)
	private String username;
	@Column(nullable=false)
	private String password;
	public User() { }
	public User(String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
