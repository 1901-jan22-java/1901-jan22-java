package com.jdbc.pojos;

public class Associate {
private int aid;
private String firstName;
private String lastName;
private String email;
private String password;
private int grade;

public Associate() {}

public Associate(String firstName, String lastName, String email, String password, int grade) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.grade = grade;
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

public int getGrade() {
	return grade;
}

public void setGrade(int grade) {
	this.grade = grade;
}

@Override
public String toString() {
	return "Associate [aid=" + aid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", password=" + password + ", grade=" + grade + "]";
}





}
