package com.jdbc.pojos;

import java.sql.Timestamp;

public class Reimbursement {
	private int reimbId;
	private double amount;
	private String description;
	private int author;
	private int resolver;
	private int typeId;
	private int statusId;
	private Timestamp submitted;
	private Timestamp resolved;
	
	public Reimbursement() {}
	
	public Reimbursement(int reimbId, double amount, String description, int author, int resolver, int typeId,
			int statusId, Timestamp submitted, Timestamp resolved) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.typeId = typeId;
		this.statusId = statusId;
		this.submitted = submitted;
		this.resolved = resolved;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	
	
	
	
}
