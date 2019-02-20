package com.revature.ers.dao.dto;

import java.sql.Date;

import com.revature.ers.services.blob.Receipt;

public class Reimbursement {

	private Integer amount;
	private Date submitted;
	private Date resolved;
	private String description;
	private Receipt receipt;
	private String author;
	private String resolver;
	private String status;
	private String type;

	public Reimbursement() {
		super();
	}

	public Reimbursement(Integer amount, Date submitted, Date resolved, String description, Receipt receipt,
			String author, String resolver, String status, String type) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Reimbursement [amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", receipt=" + receipt + ", author=" + author + ", resolver="
				+ resolver + ", status=" + status + ", type=" + type + "]";
	}

	/*
	 * Actually Useless...
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Reimbursement clone() {
		return new Reimbursement(this.amount, this.submitted, this.resolved, this.description, this.receipt,
				this.author, this.resolver, this.status, this.type);
	}
}
