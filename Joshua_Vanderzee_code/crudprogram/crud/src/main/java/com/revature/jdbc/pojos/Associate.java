package com.revature.jdbc.pojos;

public class Associate {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String a_password;
    private String grade;
	@Override
	public String toString() {
		return super.toString();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return a_password;
	}
	public void setPassword(String a_password) {
		this.a_password = a_password;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Associate(long id, String firstname, String lastname, String email, String a_password, String grade) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.a_password = a_password;
		this.grade = grade;
	}
    
	public Associate() {}
}
