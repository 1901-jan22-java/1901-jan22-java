package com.revature.ers.dao.pojos;

import java.io.Serializable;
import java.sql.Date;

import com.revature.ers.services.blob.Receipt;

public class ReimbursementData implements Serializable {

	private static final long serialVersionUID = 3307178767541629256L;

	private Integer reimb_id;
	private Double amount;
	private Date submitted;
	private Date resolved;
	private String reimb_description;
	private Receipt receipt;
	private Integer author_id;
	private Integer resolver_id;
	private Integer reimb_status_id;
	private Integer reimb_type_id;

	public ReimbursementData() {
		super();
	}

	public ReimbursementData(Double amount, Date submitted, Date resolved, String reimb_description,
			Receipt receipt, Integer author_id, Integer resolver_id, Integer reimb_status_id, Integer reimb_type_id) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.reimb_description = reimb_description;
		this.receipt = receipt;
		this.author_id = author_id;
		this.resolver_id = resolver_id;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}
	
	public ReimbursementData(Integer reimb_id, Double amount, Date submitted, Date resolved, String reimb_description,
			Receipt receipt, Integer author_id, Integer resolver_id, Integer reimb_status_id, Integer reimb_type_id) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.reimb_description = reimb_description;
		this.receipt = receipt;
		this.author_id = author_id;
		this.resolver_id = resolver_id;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}

	public Integer getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(Integer reimb_id) {
		this.reimb_id = reimb_id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
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

	public Integer getResolver_id() {
		return resolver_id;
	}

	public void setResolver_id(Integer resolver_id) {
		this.resolver_id = resolver_id;
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

	@Override
	public String toString() {
		return "ReimbursementData [reimb_id=" + reimb_id + ", amount=" + amount + ", submitted=" + submitted
				+ ", resolved=" + resolved + ", reimb_description=" + reimb_description + ", receipt=" + receipt
				+ ", author_id=" + author_id + ", resolver_id=" + resolver_id + ", reimb_status_id=" + reimb_status_id
				+ ", reimb_type_id=" + reimb_type_id + "]";
	}

}
