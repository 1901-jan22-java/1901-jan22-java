package com.revature.reimbursement;

public class Reimbursement {
	private int reimbId;
	private int amount;
	private String submitted;
	private String resolved;
	private String description;
	private int author;
	private int resolver;
	private int statusId;
	private int typeId;
	
	public Reimbursement(int reimbId, int amount, String submitted, int author,
			 int statusId, int typeId) {
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.author = author;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	
	public Reimbursement(int reimbId, int amount, String submitted, String resolved, String description, int author,
			int resolver, int statusId, int typeId) {
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
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

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
}