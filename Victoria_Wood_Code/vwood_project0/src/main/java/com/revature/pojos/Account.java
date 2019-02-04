package com.revature.pojos;

public class Account {
	
	private int id;
	private String type;
	private float balance;
	private int cid;
	
	
	public Account(int id, String type, float balance, int cid) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.cid = cid;
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
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	

}
