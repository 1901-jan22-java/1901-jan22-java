package com.revature.reimbursement;

public class ReimbursementType {
	private int reimbTypeId;
	private String reimbType;

	public ReimbursementType(int reimbTypeId, String reimbType) {
		this.reimbTypeId = reimbTypeId;
		this.reimbType = reimbType;
	}
	public int getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	public String getReimbType() {
		return reimbType;
	}
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
}
