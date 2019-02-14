package com.revature.reimbursment;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {
	private int reimbId;
	private BigDecimal reimbAmount;
	private Date submitted;
	private Date resolved;
	private String desc;
	private Blob reciept;
	private int statusid;
	private int type;
	private int author;
	private int resolver;
	
	public Reimbursement() {};
	
	public Reimbursement(int reimbId, BigDecimal reimbAmount, Date submitted, Date resolved, String desc, Blob reciept, int statusid, int type, int author, int resolver) {
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.desc = desc;
		this.reciept = reciept;
		this.statusid = statusid;
		this.type = type;
		this.author = author;
		this.resolver = resolver;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Blob getReciept() {
		return reciept;
	}
	public void setReciept(Blob reciept) {
		this.reciept = reciept;
	}
	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
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
	
}
