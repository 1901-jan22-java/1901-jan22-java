package com.revature.ers.services.dao.pojos;

import java.io.Serializable;

public class ReimbursementTypeData implements Serializable {

	private static final long serialVersionUID = 2282033233090845335L;

	private Integer type_id;
	private String reimb_type;

	public ReimbursementTypeData() {
		super();
	}

	public ReimbursementTypeData(Integer type_id, String reimb_type) {
		super();
		this.type_id = type_id;
		this.reimb_type = reimb_type;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getReimb_type() {
		return reimb_type;
	}

	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}

	@Override
	public String toString() {
		return "ReimbursementTypeData [type_id=" + type_id + ", reimb_type=" + reimb_type + "]";
	}

}
