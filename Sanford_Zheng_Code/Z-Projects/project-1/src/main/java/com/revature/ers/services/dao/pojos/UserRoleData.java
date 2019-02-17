package com.revature.ers.services.dao.pojos;

import java.io.Serializable;

public class UserRoleData implements Serializable {
	
	private static final long serialVersionUID = 6108176418976538722L;
	
	private Integer role_id;
	private String	user_role;
	
	public UserRoleData() {
		super();
	}
	
	public UserRoleData(Integer role_id, String user_role) {
		super();
		this.role_id = role_id;
		this.user_role = user_role;
	}
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	} 
	
}
