package com.rev.proze.util;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rev.proze.pojos.Account;
import com.rev.proze.pojos.Login;
import com.rev.proze.pojos.Transaction;
import com.rev.proze.pojos.User;

public class StringWorks 
{
	public String capString(String inString)
	{
        String outString = inString.substring(0,1).toUpperCase() + inString.substring(1);
        return outString; 
	}
	
	public void displayUserTable(List<User> list)
	{
		System.out.println
		(String.format("%-12s%-12s%-12s%-30s%-30s", "USR_ID", "FIRSTNAME", "LASTNAME", "EMAIL", "TYPE"));
		for (User user : list)
        System.out.println
        (String.format("%-12s%-12s%-12s%-30s%-30s",
        				user.getId(), user.getFn(), user.getLn(), user.getEm(), user.getTp()));
	}
	
	public void displayAccountTable(List<Account> list)
	{
		System.out.println
		(String.format("%-12s%-12s%-12s%-30s", "ACC_ID", "USR_ID", "TYPE", "BALANCE"));
		for (Account acc : list)
		System.out.println
	    (String.format("%-12s%-12s%-12s%-30s",
	        			acc.getId(), acc.getUsr_id(), acc.getTp(), acc.getBl()));
	}

	public void displayLoginTable(List<Login> list)
	{
		System.out.println
		(String.format("%-12s%-12s%-30s", "USR_ID", "USERNAME", "PASSWORD"));
		for (Login log : list)
		System.out.println
	    (String.format("%-12s%-12s%-30s",
	        			log.getId(), log.getUn(), log.getPw()));
	}
	
	public void displayTranxTable(List<Transaction> list)
	{
		System.out.println
		(String.format("%-12s%-12s%-12s%-30s%-30s", "TRX_ID", "ACC_ID", "TYPE", "DATE", "AMOUNT"));
		for (Transaction trx : list)
		System.out.println
	    (String.format("%-12s%-12s%-12s%-30s%-30s",
	    		trx.getId(), trx.getAcc_id(),  trx.getType(), trx.getTimeStamp(), trx.getAmt()));
	}
	
	public String getRangeRegex(int beg, int end)
	{
		String regexRange = "^[" + String.valueOf(beg) + "-" + String.valueOf(end) + "]"; return regexRange;
	}
	
	private static ArrayList<String> getFields(Object someObject) throws IllegalArgumentException, IllegalAccessException 
	{
		ArrayList<String> fields = new ArrayList<String>();
		for (Field field : someObject.getClass().getDeclaredFields()) 
		{
		    field.setAccessible(true); 
		    Object value = field.get(someObject); 
		    fields.add(field.getName());
		}
		return fields;
	}
	
	public String wrapWithSingleQuotes(String s)
	{
		return "'"+s+"'";
	}
}
