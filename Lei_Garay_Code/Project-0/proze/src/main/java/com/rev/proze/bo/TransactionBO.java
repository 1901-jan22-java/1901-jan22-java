package com.rev.proze.bo;

import java.sql.SQLException;
import java.util.List;

import com.rev.proze.dao.AccountDAO;
import com.rev.proze.dao.TransactionDAO;
import com.rev.proze.exceptions.Custom;
import com.rev.proze.exceptions.SelectionInput;
import com.rev.proze.pojos.Account;
import com.rev.proze.pojos.User;
import com.rev.proze.util.InputCollector;

public class TransactionBO 
{
	public TransactionBO(User user, String tranxType) throws Custom
	{	
		
		
		int option = 0;
		Double amount = 0.0;
		List<Account> accounts  = null;
		try 					{	accounts = new AccountDAO().getListOfAccountsById(user);} 
		catch (SQLException e) 	{	e.printStackTrace();									}
		System.out.println("Options:");

		for(int i=0; i<accounts.size();i++)
		{
			System.out.println("\t\t0"+(i+1)+". "+accounts.get(i).getId()+"\t"+accounts.get(i).getTp().substring(0,6)+"\t"+accounts.get(i).getBl());
		
		}
		
		try 						{	option = new InputCollector().getUserCustomRange(1, accounts.size());	} 
		catch (SelectionInput e) 	{	e.printStackTrace();									}
	
		try 						{	amount = new InputCollector().getAmount("amount:");	} 
		catch (Custom e) 			{	e.printStackTrace();									}
		if(tranxType.equalsIgnoreCase("deposit"))
		{
			new TransactionDAO().save(accounts.get(option).getId(), "deposit", amount);
		}
		else if(tranxType.equalsIgnoreCase("withdraw"))
		{
			new TransactionDAO().save(accounts.get(option).getId(), "withdrawal", amount);
		}
	}
}
