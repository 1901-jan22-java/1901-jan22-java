package com.revature.ers.dao.pojos;

import java.io.Serializable;

public class ReimbursementStatus implements Serializable {
	
	private Integer status_id;
	private String reimb_status;
	
	public ReimbursementStatus() {
		super();
	}
	
	public ReimbursementStatus(Integer status_id, String reimb_status) {
		super();
		this.status_id = status_id;
		this.reimb_status = reimb_status;
	}
	
	public Integer getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Integer status_id) {
		this.status_id = status_id;
	}
	public String getReimb_status() {
		return reimb_status;
	}
	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}
	
}
