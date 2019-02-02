package com.revature.bank.jdbc.pojos;

public class transactiontype {
    private int transactionTypeID;
    private String transactionTypeState;
	public transactiontype(int transactionTypeID, String transactionTypeState) {
		super();
		this.transactionTypeID = transactionTypeID;
		this.transactionTypeState = transactionTypeState;
	}
	public int getTransactionTypeID() {
		return transactionTypeID;
	}
	public void setTransactionTypeID(int transactionTypeID) {
		this.transactionTypeID = transactionTypeID;
	}
	public String getTransactionTypeState() {
		return transactionTypeState;
	}
	public void setTransactionTypeState(String transactionTypeState) {
		this.transactionTypeState = transactionTypeState;
	}

}