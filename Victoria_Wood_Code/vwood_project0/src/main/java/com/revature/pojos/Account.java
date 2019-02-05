package com.revature.pojos;

public class Account {
	
	private int id;
	private String type;
	private float balance;
	private int uid;
	
	
	public Account(int id, String type, float balance, int uid) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.uid = uid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getuid() {
		return uid;
	}
	public void setuid(int uid) {
		this.uid = uid;
	}
	
	
	

}
