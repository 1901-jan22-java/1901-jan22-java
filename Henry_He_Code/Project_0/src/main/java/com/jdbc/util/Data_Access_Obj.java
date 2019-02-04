package com.jdbc.util;

import java.sql.Connection;

public class Data_Access_Obj {
	
	Connection conn = ConnectionFactory.getInstance().getConnection();
	
	public void login() {}
	
	public boolean doesUserExist(){
		return false;
	}
	
	public void createAccount() {}
	
	public void updateAccount() {}
	
}
