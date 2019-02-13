package com.rev.proze.pojos;

public class Login 
{
	public Login() {}
	
	private String un;
	private String pw;
	private Integer id;
	
	public Login(String un, String pw, Integer id) 
	{
		super();
		this.un = un;
		this.pw = pw;
		this.id = id;
	}

	public String getUn() {
		return un;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Login [un=" + un + ", pw=" + pw + ", id=" + id + "]";
	}
	
	
	
	
}
