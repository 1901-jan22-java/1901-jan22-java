package com.revature.reimbursement;

public class ReimbursementStatus {
	private int reimbStatusId;
	private String reimbStatus;
	
	public ReimbursementStatus(int reimbStatusId, String reimbStatus) {
		this.reimbStatusId = reimbStatusId;
		this.reimbStatus = reimbStatus;
	}
	public int getReimbStatusId() {
		return reimbStatusId;
	}
	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}
	public String getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
}
