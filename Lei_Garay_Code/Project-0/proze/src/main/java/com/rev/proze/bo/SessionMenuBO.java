package com.rev.proze.bo;

import java.sql.SQLException;
import java.util.List;

import com.rev.proze.dao.AccountDAO;
import com.rev.proze.exceptions.Custom;
import com.rev.proze.exceptions.SelectionInput;
import com.rev.proze.pojos.Account;
import com.rev.proze.pojos.User;
import com.rev.proze.util.Definitions;
import com.rev.proze.util.InputCollector;

public class SessionMenuBO 
{
	
	public SessionMenuBO() {}
	
	public SessionMenuBO(Integer numAccounts, User user) throws Custom
	{
		List<Account> accounts = null;
		
		try 					{	accounts = new AccountDAO().getListOfAccountsById(user);	} 
		catch (SQLException e) 	{	e.printStackTrace();										}
		int option = 0;
		if(numAccounts==0)
		{
			try 					{	accounts = new AccountDAO().getListOfAccountsById(user);} 
			catch (SQLException e) 	{	e.printStackTrace();										 }
			new Definitions().showUserHP0(user);
			
			try 						{	option = new InputCollector().getUserCustomRange(1, 3);	} 
			catch (SelectionInput e) 	{	e.printStackTrace();									}
			
			switch(option)
			{
			case 1:		new Definitions().showUserInfo(user);
			try 						{	option = new InputCollector().getUserCustomRange(1, 2);	} 
			catch (SelectionInput e) 	{	e.printStackTrace();									}	
			
				switch(option)
				{
				case 1: new SessionMenuBO(numAccounts, user); break;
				case 2: System.out.println(new Definitions().farewell);
						System.exit(0); break;
				}

				break;
			case 2:		new BARegistrationBO(user);//register
				break;
			case 3:		System.out.println(new Definitions().farewell);
						System.exit(0); break;
			}
			
		}
		else if(numAccounts>0 && numAccounts<3)
		{
			try 					{	accounts = new AccountDAO().getListOfAccountsById(user);	} 
			catch (SQLException e) 	{	e.printStackTrace();										}
			
			new Definitions().showUserHP1(user);
			
			try 						{	option = new InputCollector().getUserCustomRange(1, 6);	} 
			catch (SelectionInput e) 	{	e.printStackTrace();									}
			
			switch(option)
			{
			case 1:		new Definitions().showUserInfo(user);
						try 						{	option = new InputCollector().getUserCustomRange(1, 2);	} 
						catch (SelectionInput e) 	{	e.printStackTrace();									}	
			
						switch(option)
						{
						case 1: new SessionMenuBO(numAccounts, user); break;
						case 2: System.out.println(new Definitions().farewell);
								System.exit(0); break;
						}
						break;
			case 2:		//show accounts
						try 					{	accounts = new AccountDAO().getListOfAccountsById(user);	} 
						catch (SQLException e) 	{	e.printStackTrace();										}
						for (Account account : accounts) 
						{
							System.out.println("\t\t"+account.getId()+"\t"+account.getTp().substring(0,6)+"\t"+account.getBl());
						}
						new Definitions().showUserInfo(user);
						try 						{	option = new InputCollector().getUserCustomRange(1, 2);	} 
						catch (SelectionInput e) 	{	e.printStackTrace();									}
						switch(option)
						{
						case 1: new SessionMenuBO(numAccounts, user); break;
						case 2: System.out.println(new Definitions().farewell);
								System.exit(0); break;
						}
						
						break;
			case 3:		new TransactionBO(user, "deposit");
						break;
			case 4:		new TransactionBO(user, "withdraw");
						break;
			case 5:		new BARegistrationBO(user);
						break;
			case 6:		System.out.println(new Definitions().farewell);
						System.exit(0); break;
			}
			
			
		}
		else if(numAccounts>2)
		{
			new Definitions().showUserHP2(user);
			
			try 					{	accounts = new AccountDAO().getListOfAccountsById(user);	} 
			catch (SQLException e) 	{	e.printStackTrace();										}
			
			new Definitions().showUserHP1(user);
			
			try 						{	option = new InputCollector().getUserCustomRange(1, 6);	} 
			catch (SelectionInput e) 	{	e.printStackTrace();									}
			
			switch(option)
			{
			case 1:		new Definitions().showUserInfo(user);
						try 						{	option = new InputCollector().getUserCustomRange(1, 2);	} 
						catch (SelectionInput e) 	{	e.printStackTrace();									}	
			
						switch(option)
						{
						case 1: new SessionMenuBO(numAccounts, user); break;
						case 2: System.out.println(new Definitions().farewell);
								System.exit(0); break;
						}
						break;
			case 2:		new BARegistrationBO(user);
						break;
			case 3:		new TransactionBO(user, "deposit");
						break;
			case 4:		new TransactionBO(user, "withdraw");
	
			case 6:		System.out.println(new Definitions().farewell);
						System.exit(0); break;
			}
			
			
		}
	}
}
