package com.revature.pojos;

public class User {
	private int id;
	private String fn;
	private String ln;
	private String username;
	private String pwd;
	
	
	public User(int id, String fn, String ln) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
