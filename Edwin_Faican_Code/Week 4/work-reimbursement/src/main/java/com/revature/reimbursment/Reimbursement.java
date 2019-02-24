package com.revature.reimbursment;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {
	private int reimbId;
	private BigDecimal reimbAmount;
	private long submitted;
	private long resolved;
	private String desc;
	//private Blob reciept;
	private int statusid;
	private String status;
	private String type;
	private int author;
	private int resolver;
	private String author_firstname;
	private String author_lastname;
	private String resolver_firstname;
	private String resolver_lastname;
	
	public Reimbursement() {};
	
	public Reimbursement(int reimbId, BigDecimal reimbAmount, Date submitted,  String desc, String status, int statusid, int author, int resolver, String type) {
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.submitted = submitted.getTime();
		this.desc = desc;
		//this.reciept = reciept;
		this.status = status;
		this.statusid = statusid;
		this.type = type;
		this.author = author;
		this.resolver = resolver;
	}
	
	public String getAuthor_firstname() {
		return author_firstname;
	}

	public void setAuthor_firstname(String author_firstname) {
		this.author_firstname = author_firstname;
	}

	public String getAuthor_lastname() {
		return author_lastname;
	}

	public void setAuthor_lastname(String author_lastname) {
		this.author_lastname = author_lastname;
	}

	public String getResolver_firstname() {
		return resolver_firstname;
	}

	public void setResolver_firstname(String resolver_firstname) {
		if(resolver_firstname == null) {
			this.resolver_firstname = "---";
		} else {
			this.resolver_firstname = resolver_firstname;
		}
		
	}

	public String getResolver_lastname() {
		return resolver_lastname;
	}

	public void setResolver_lastname(String resolver_lastname) {
		if(resolver_lastname == null) {
			this.resolver_lastname = "---";
		} else {
			this.resolver_lastname = resolver_lastname;
		}
		
	}

	public void setSubmitted(long submitted) {
		this.submitted = submitted;
	}

	public void setResolved(long resolved) {
		this.resolved = resolved;
	}

	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public BigDecimal getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(BigDecimal reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public long getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Date submitted) {
		this.submitted = submitted.getTime();
	}
	public long getResolved() {
		return resolved;
	}
	public void setResolved(Date resolved) {
		if(resolved == null) {
			this.resolved = 0;
		} else {
			this.resolved = resolved.getTime();
		}
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
//	public Blob getReciept() {
//		return reciept;
//	}
//	public void setReciept(Blob reciept) {
//		this.reciept = reciept;
//	}
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public String getType() {
		return type.toUpperCase();
	}
	public void setType(String type) {
		this.type = type;
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

	public String toString() {
		return "$" + this.reimbAmount + ", " + this.desc + ", " + this.reimbId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
