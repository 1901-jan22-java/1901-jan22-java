package com.revature.bank.jdbc.pojos;

import java.sql.Date;

public class User {
	
	public User() {
		super();
	}
	
	public User(long UserId, String UserName, String Password, String FirstName, String LastName,
			String SecurityQuestion1, String SecurityAnswer1, String SecurityQuestion2, String SecurityAnswer2,
			String SecurityQuestion3, String SecurityAnswer3, String Addressline1, String Addressline2, String City,
			String States, String Country, long PostalCode, long HomePhone, long CellPhone, long Fax, String Email,
			long SSN, Date BirthDate, String Maritalstatus) {
		this.UserId = UserId;
		this.UserName = UserName; 
		this.Password = Password;
		this.FirstName = FirstName; 
		this.LastName = LastName;
		this.SecurityQuestion1 = SecurityQuestion1;
		this.SecurityAnswer1 = SecurityAnswer1;
		this.SecurityQuestion2 = SecurityQuestion2;
		this.SecurityAnswer2 = SecurityAnswer2;
		this.SecurityQuestion3 = SecurityQuestion3;
		this.SecurityAnswer3 = SecurityAnswer3;
		this.Addressline1 = Addressline1;
		this.Addressline2 = Addressline2;
		this.City = City;
		this.States = States;
		this.Country = Country;
		this.PostalCode = PostalCode;
		this.HomePhone = HomePhone;
		this.CellPhone = CellPhone;
		this.Fax = Fax;
		this.Email = Email;
		this.SSN = SSN;
		this.BirthDate = BirthDate;
		this.Maritalstatus = Maritalstatus; 
	}
	
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getSecurityQuestion1() {
		return SecurityQuestion1;
	}
	public void setSecurityQuestion1(String securityQuestion1) {
		SecurityQuestion1 = securityQuestion1;
	}
	public String getSecurityAnswer1() {
		return SecurityAnswer1;
	}
	public void setSecurityAnswer1(String securityAnswer1) {
		SecurityAnswer1 = securityAnswer1;
	}
	public String getSecurityQuestion2() {
		return SecurityQuestion2;
	}
	public void setSecurityQuestion2(String securityQuestion2) {
		SecurityQuestion2 = securityQuestion2;
	}
	public String getSecurityAnswer2() {
		return SecurityAnswer2;
	}
	public void setSecurityAnswer2(String securityAnswer2) {
		SecurityAnswer2 = securityAnswer2;
	}
	public String getSecurityQuestion3() {
		return SecurityQuestion3;
	}
	public void setSecurityQuestion3(String securityQuestion3) {
		SecurityQuestion3 = securityQuestion3;
	}
	public String getSecurityAnswer3() {
		return SecurityAnswer3;
	}
	public void setSecurityAnswer3(String securityAnswer3) {
		SecurityAnswer3 = securityAnswer3;
	}
	public String getAddressline1() {
		return Addressline1;
	}
	public void setAddressline1(String addressline1) {
		Addressline1 = addressline1;
	}
	public String getAddressline2() {
		return Addressline2;
	}
	public void setAddressline2(String addressline2) {
		Addressline2 = addressline2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStates() {
		return States;
	}
	public void setStates(String states) {
		States = states;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public long getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(long postalCode) {
		PostalCode = postalCode;
	}
	public long getHomePhone() {
		return HomePhone;
	}
	public void setHomePhone(long homePhone) {
		HomePhone = homePhone;
	}
	public long getCellPhone() {
		return CellPhone;
	}
	public void setCellPhone(long cellPhone) {
		CellPhone = cellPhone;
	}
	public long getFax() {
		return Fax;
	}
	public void setFax(long fax) {
		Fax = fax;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getSSN() {
		return SSN;
	}
	public void setSSN(long sSN) {
		SSN = sSN;
	}
	public Date getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	public String getMaritalstatus() {
		return Maritalstatus;
	}
	public void setMaritalstatus(String maritalstatus) {
		Maritalstatus = maritalstatus;
	}

	private long UserId;
	private String UserName; 
	private String Password;
	private String FirstName; 
	private String LastName;
	private String SecurityQuestion1;
	private String SecurityAnswer1;
	private String SecurityQuestion2;
	private String SecurityAnswer2;
	private String SecurityQuestion3;
	private String SecurityAnswer3;
	private String Addressline1;
	private String Addressline2;
	private String City;
	private String States;
	private String Country;
	private long PostalCode;
	private long HomePhone;
	private long CellPhone;
	private long Fax;
	private String Email;
	private long SSN;
	private Date BirthDate;
	private String Maritalstatus; 
}
