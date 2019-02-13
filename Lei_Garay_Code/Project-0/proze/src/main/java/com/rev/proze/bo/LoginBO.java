package com.rev.proze.bo;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.rev.proze.app.MainMenu;
import com.rev.proze.dao.LoginDAO;
import com.rev.proze.dao.UserDAO;
import com.rev.proze.exceptions.Custom;
import com.rev.proze.exceptions.SelectionInput;
import com.rev.proze.pojos.Login;
import com.rev.proze.pojos.User;
import com.rev.proze.util.Definitions;
import com.rev.proze.util.InputCollector;

public class LoginBO 
{
	public LoginBO()
	{
		
	}
	
	public LoginBO(User user) throws Custom
	{
		Properties prop = new Properties(); 
		prop.setProperty("log4j.rootLogger", "WARN");
		PropertyConfigurator.configure(prop);
		int option = 0;
		user = null;
		System.out.println(new Definitions().signInHead);
		String username = new InputCollector().getAnyString("username");
		String password = new InputCollector().getAnyString("password");
		System.out.println(new Definitions().signInMid);
		Login login = new Login();
		login = new LoginDAO().getByUsername(username);
		user = new UserDAO().getById(login.getId());
		if(login.getPw().equals(password))
		{
			System.out.println(new Definitions().success);
			new AccountBO(user);
		}
		else
		{
			System.out.println(new Definitions().signInFail);
			
			try 						{	option = new InputCollector().getUserCustomRange(1, 3);	} 
			catch (SelectionInput e) 	{	e.printStackTrace();									}
			
			switch(option)
			{
			case 1: user = null; login = null;
					new LoginBO(user); break;
					
			case 2: new MainMenu(); break;
			
			case 3: System.out.println(new Definitions().farewell);
					System.exit(0);
			}
		}
	}
}
