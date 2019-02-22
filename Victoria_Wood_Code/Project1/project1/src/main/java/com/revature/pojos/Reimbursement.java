package com.revature.pojos;

import java.sql.Date;

public class Reimbursement {
	private int id;
	private float amount;
	private Date submitted;
	private Date resolved;
	private String author;
	private String description;
	private String resolver;
	private String status;
	private String type;
	
	
	
	
	public Reimbursement(int id, float amount, Date submitted, Date resolved, String resolver, String description, String status,
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
	public String getResolver() {
		return resolver;
	}
	public void setResolver(String resolver) {
		this.resolver = resolver;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType_id() {
		return type;
	}
	public void setType_id(String type_id) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
