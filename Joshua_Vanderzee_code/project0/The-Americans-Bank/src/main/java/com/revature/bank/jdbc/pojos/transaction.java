package com.revature.bank.jdbc.pojos;

public class transaction {
    private int TransactionID;
    private int AccountId;
    private int TransactionTypeID;
    private int Amount;
    private String TransactionDate;
    private String Memo;
    private int RunningBalance;
    public transaction() {
    	super();
    }
	public transaction(int transactionID, int accountId, int transactionTypeID, int amount, String transactionDate,
			String memo, int runningBalance) {
		super();
		TransactionID = transactionID;
		AccountId = accountId;
		TransactionTypeID = transactionTypeID;
		Amount = amount;
		TransactionDate = transactionDate;
		Memo = memo;
		RunningBalance = runningBalance;
	}
	public int getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}
	public int getAccountId() {
		return AccountId;
	}
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	public int getTransactionTypeID() {
		return TransactionTypeID;
	}
	public void setTransactionTypeID(int transactionTypeID) {
		TransactionTypeID = transactionTypeID;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		TransactionDate = transactionDate;
	}
	public String getMemo() {
		return Memo;
	}
	public void setMemo(String memo) {
		Memo = memo;
	}
	public int getRunningBalance() {
		return RunningBalance;
	}
	public void setRunningBalance(int runningBalance) {
		RunningBalance = runningBalance;
	}
}
