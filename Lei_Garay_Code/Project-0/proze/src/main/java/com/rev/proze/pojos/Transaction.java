package com.rev.proze.pojos;

import java.sql.Date;
import java.sql.Timestamp;

public class Transaction 
{
	public Transaction () {}
	
	private Integer	id;
	private	Integer acc_id;
	private String	type;
	private java.sql.Timestamp	timeStamp;
	private	Double  amt;
	
	public Transaction(Integer id, Integer acc_id, String type, Timestamp timeStamp, Double amt) 
	{
		super();
		this.id = id;
		this.acc_id = acc_id;
		this.type = type;
		this.timeStamp = timeStamp;
		this.amt = amt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Integer acc_id) {
		this.acc_id = acc_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Double getAmt() {
		return amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", acc_id=" + acc_id + ", type=" + type + ", timeStamp=" + timeStamp + ", amt="
				+ amt + "]";
	}
}
