package com.revature.ers.dao.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import com.revature.ers.services.Receipt;

public class Reimbursement implements Serializable {
	
	private Integer reimb_id;
	private Integer amount;
	private Date submitted;
	private Date resolved;
	private String reimb_description;
	private Receipt receipt;
	private Integer author_id;
	private Integer resovler_id;
	private Integer reimb_status_id;
	private Integer reimb_type_id;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(Integer reimb_id, Integer amount, Date submitted, Date resolved,
			String reimb_description, Receipt receipt, Integer author_id, Integer resovler_id, Integer reimb_status_id,
			Integer reimb_type_id) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.reimb_description = reimb_description;
		this.receipt = receipt;
		this.author_id = author_id;
		this.resovler_id = resovler_id;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}

	public Integer getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(Integer reimb_id) {
		this.reimb_id = reimb_id;
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

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Integer getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
	}

	public Integer getResovler_id() {
		return resovler_id;
	}

	public void setResovler_id(Integer resovler_id) {
		this.resovler_id = resovler_id;
	}

	public Integer getReimb_status_id() {
		return reimb_status_id;
	}

	public void setReimb_status_id(Integer reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}

	public Integer getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(Integer reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}
	
	
}
