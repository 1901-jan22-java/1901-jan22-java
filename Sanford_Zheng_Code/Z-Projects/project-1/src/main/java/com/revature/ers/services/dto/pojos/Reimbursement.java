package com.revature.ers.services.dto.pojos;

import java.sql.Date;

import com.revature.ers.services.Receipt;

public class Reimbursement {

	private Integer amount;
	private Date submitted;
	private Date resolved;
	private String description;
	private Receipt receipt;
	private User author;
	private User resovler;
	private String status;
	private String type;
	
	public Reimbursement() {
		super();
	}
	public Reimbursement(Integer amount, Date submitted, Date resolved, String description, Receipt receipt,
			User author, User resovler, String status, String type) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resovler = resovler;
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
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public User getResovler() {
		return resovler;
	}
	public void setResovler(User resovler) {
		this.resovler = resovler;
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
				+ ", description=" + description + ", receipt=" + receipt + ", author=" + author + ", resovler="
				+ resovler + ", status=" + status + ", type=" + type + "]";
	}
	
	public Reimbursement clone() {
		return new Reimbursement(this.amount, this.submitted, 
				this.resolved, this.description, this.receipt.clone(), 
				this.author.clone(), this.resovler.clone(), this.status, this.type);
	}
}
