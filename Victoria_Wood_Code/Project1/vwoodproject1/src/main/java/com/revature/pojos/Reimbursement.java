package com.revature.pojos;

import java.sql.Date;

public class Reimbursement {
	private int id;
	private float amount;
	private Date submitted;
	private Date resolved;
	private String author;
	private String description;
	private int resolver;
	private String status;
	private int status_id;
	private String type;
	private int type_id;
	
	
	public Reimbursement() {}
	
	
	public Reimbursement(float amount, String description, int type_id) {
		super();
		this.amount = amount;
		this.description = description;
		this.type_id = type_id;
	}

	public Reimbursement(int id, float amount, Date submitted, Date resolved, int resolver, String description, String status,
			String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.resolver = resolver;
		this.description = description;
		this.status = status;
		this.type = type;
	}
	public Reimbursement(int id, float amount, Date submitted,  String author, String status) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.author = author;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}
	public Date getResolved() {
		return resolved;
	}
	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public int getType_id() {
		return type_id;
	}


	public void setType_id(int type_id) {
		this.type_id = type_id;
	}


	@Override
	public String toString() {
		return "Reimbursement [amount=" + amount + ", description=" + description + ", status=" + status + ", type="
				+ type + ", type_id=" + type_id + "]";
	}


	public int getStatus_id() {
		return status_id;
	}


	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	
}
