package com.revature.bank.jdbc.pojos;

public class Account {
    private String AccountId;
    private String AccountType;
    private String AccountNumber;
    private String RoutingNumber;
    private String Balance;
    
    public Account() {
    	super();
    }
    
	public Account(String accountId, String accountType, String accountNumber, String routingNumber, String balance) {
		super();
		AccountId = accountId;
		AccountType = accountType;
		AccountNumber = accountNumber;
		RoutingNumber = routingNumber;
		Balance = balance;
	}
	
	public String getAccountId() {
		return AccountId;
	}
	public void setAccountId(String accountId) {
		AccountId = accountId;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getRoutingNumber() {
		return RoutingNumber;
	}
	public void setRoutingNumber(String routingNumber) {
		RoutingNumber = routingNumber;
	}
	public String getBalance() {
		return Balance;
	}
	public void setBalance(String balance) {
		Balance = balance;
	}

}
