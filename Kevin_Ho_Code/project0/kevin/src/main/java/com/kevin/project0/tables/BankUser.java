package com.kevin.project0.tables;

public class BankUser {
	private String username;	//primary key unique
	private String password;
	private String first_name;
	private String last_name;
    private String birthdate;
    private String phone;
    private String email;
	
	public BankUser(String username, String password, String first_name, 
				String last_name, String birthdate, String phone, String email)
	{
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birthdate = birthdate;
		this.phone = phone;
		this.email = email;
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
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [username= " + username + " password= " + password 
				+ " first name= " + first_name + " last name= " + last_name
				+ " birthdate= " + birthdate + " phone= " + phone + " email= " + email;
	}
}
