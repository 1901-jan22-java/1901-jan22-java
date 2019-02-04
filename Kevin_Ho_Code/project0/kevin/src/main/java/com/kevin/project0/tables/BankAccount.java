package com.kevin.project0.tables;

public class BankAccount {
	private int accountNumber;	//primary key
	private double money;		//how much money in account
	private String type;		//checking or saving
	private String owner;		//who owns the account
	private String name;		//optional user generated name
	
	public BankAccount(int accountNumber, double money, String type, String owner, String name)
	{
		this.accountNumber = accountNumber;
		this.money = money;
		this.type = type;
		this.owner = owner;
		this.name = name;		
	}
	public BankAccount() {
		
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString()
	{
		return 	"Account[ Account Number= " + accountNumber + 
				" Account Owner" + owner + 
				" Money= " + money +	
				" Account Type= " + type + 
				" Account Name= " + name + "]";
	}
}
