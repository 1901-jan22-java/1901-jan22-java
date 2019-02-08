package com.revature.pojo;

public class Associate {
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private double grade;
	
	public Associate(){};
	
	
	public Associate(String firstname, String lastname, String email,
			String password, double grade) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.grade = grade;
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
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String toString() {
		return "Associate [firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", password=" + password + ", grade="
				+ grade + "]";
	}
	
	
}
