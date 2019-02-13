package com.rev.proze.bo;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.rev.proze.dao.AccountDAO;
import com.rev.proze.exceptions.Custom;
import com.rev.proze.exceptions.SelectionInput;
import com.rev.proze.pojos.Account;
import com.rev.proze.pojos.User;
import com.rev.proze.util.Definitions;
import com.rev.proze.util.InputCollector;

public class BARegistrationBO 
{
	BARegistrationBO(User user) throws Custom
	{
		List<Account> user_accounts = null;
		int option = 0;
		new Definitions().showAccTypeToOpen(user);
		try 					{	user_accounts = new AccountDAO().getListOfAccountsById(user);} 
		catch (SQLException e) 	{	e.printStackTrace();										 }
		
		try 						{	option = new InputCollector().getUserCustomRange(1, 4);	} 
		catch (SelectionInput e) 	{	e.printStackTrace();									}
		
		switch(option)
		{
		case 1:		user_accounts = registerAccount(user,1);
					System.out.println(Arrays.asList(user_accounts));
					new SessionMenuBO(user_accounts.size(),user); break;
		
		case 2:		user_accounts = registerAccount(user,2);
					System.out.println(Arrays.asList(user_accounts));
					new SessionMenuBO(user_accounts.size(),user); break;
					
		case 3:		new SessionMenuBO(user_accounts.size(),user); break;
		
		case 4:		System.out.println(new Definitions().farewell);
					System.exit(0); break;
		}
	}
	
	public List<Account>registerAccount(User user, Integer choice)
	{
		List<Account> accounts = null;
		Account account = new Account();
		String type = "";
		switch(choice)
		{
		case 1: type = "Checking";break;
		case 2: type = "Savings"; break;
		
		}
		account = new AccountDAO().insert(user.getId(), type, 0.0);
		account = new AccountDAO().getAccountwithMaxID(user);
		try 					{	accounts = new AccountDAO().getListOfAccountsById(user);} 
		catch (SQLException e) 	{	e.printStackTrace();										 }
		return accounts;
	}
	
}

