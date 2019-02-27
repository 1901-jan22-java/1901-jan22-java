package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*
 * mapping classes with annotations 
 */

@Entity //registers a class as an entity(table) in DB
@Table(name="BLOG_USERS")
public class User {
	
	@Id //necessary for Hibernate to identify objects uniquely
	@Column(name="USER_ID")
	//More on @SequenceGenerator at: https://docs.oracle.com/javaee/5/api/javax/persistence/SequenceGenerator.html
	//name(required), optional: allocationSize, initialValue, sequenceName
	@SequenceGenerator(name="U_SEQ_GEN", sequenceName="U_SEQ", allocationSize=1)
	//more on @GeneratedValue at https://www.objectdb.com/java/jpa/entity/generated
	@GeneratedValue(generator="U_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	//change name of col and apply constraints
	//@Column attributes can be found at https://docs.jboss.org/hibernate/jpa/2.1/api/javax/persistence/Column.html
	@Column(nullable=false, unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	public User() {}
	
	public User(String username, String password) {
		super();
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
