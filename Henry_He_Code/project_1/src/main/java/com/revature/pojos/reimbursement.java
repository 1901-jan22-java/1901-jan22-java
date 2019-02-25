package com.revature.pojos;

public class reimbursement {

	private int rid;
	private String rtype;
	private int ramount;
	private String desc;
	private String rstatus;
	private String requester;
	private String submitted;
	private String granter;
	private String resolved;
	
	private String[] rtype_arr = {"PLACEHOLDER","LODGING","TRAVELING","FOOD","OTHER"};
	private String[] rstatus_arr = {"PENDING","APPROVED","DENIED"};
	
	public reimbursement(int rid, int rtype, int ramount, String desc, int rstatus, String requester,
			String submitted, String granter, String resolved) {
		super();
		this.rid = rid;
		this.rtype = rtype_arr[rtype];
		this.ramount = ramount;
		this.desc = desc;
		this.rstatus = rstatus_arr[rstatus];
		this.requester = requester;
		this.submitted = submitted;
		this.granter = granter;
		this.resolved = resolved;
	}
	
	
	
	public int getRid() {
		return rid;
	}
	
	
	
	public void setRid(int rid) {
		this.rid = rid;
	}



	public String getRtype() {
		return rtype;
	}



	public void setRtype(String rtype) {
		this.rtype = rtype;
	}



	public int getRamount() {
		return ramount;
	}



	public void setRamount(int ramount) {
		this.ramount = ramount;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public String getRstatus() {
		return rstatus;
	}



	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}



	public String getRequester() {
		return requester;
	}



	public void setRequester(String requester) {
		this.requester = requester;
	}



	public String getSubmitted() {
		return submitted;
	}



	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}



	public String getGranter() {
		return granter;
	}



	public void setGranter(String granter) {
		this.granter = granter;
	}



	public String getResolved() {
		return resolved;
	}



	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	

	@Override
	public String toString() {
		return "reimbursement [rid=" + rid + ", rtype=" + rtype + ", ramount=" + ramount + ", desc=" + desc
				+ ", rstatus=" + rstatus + ", requester=" + requester + ", submitted=" + submitted + ", granter="
				+ granter + ", resolved=" + resolved + "]";
	}
	
}
