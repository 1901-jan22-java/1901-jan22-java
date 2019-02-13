package com.rev.proze.bo;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.rev.proze.dao.AccountDAO;
import com.rev.proze.exceptions.Custom;
import com.rev.proze.pojos.Account;
import com.rev.proze.pojos.User;
import com.rev.proze.util.Definitions;

public class AccountBO
{
	public AccountBO(User user) throws Custom
	{
		Properties prop = new Properties(); 
		prop.setProperty("log4j.rootLogger", "WARN");
		PropertyConfigurator.configure(prop);
		
		List<Account> user_accounts = null;
		try 					{	user_accounts = new AccountDAO().getListOfAccountsById(user);} 
		catch (SQLException e) 	{	e.printStackTrace();										 }
		
		new SessionMenuBO(user_accounts.size(),user);
	}
}
