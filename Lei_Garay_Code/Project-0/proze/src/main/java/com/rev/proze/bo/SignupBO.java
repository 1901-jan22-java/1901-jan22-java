package com.rev.proze.bo;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import com.rev.proze.app.MainMenu;
import com.rev.proze.dao.LoginDAO;
import com.rev.proze.dao.UserDAO;
import com.rev.proze.exceptions.Custom;
import com.rev.proze.exceptions.ValidEmail;
import com.rev.proze.exceptions.ValidName;
import com.rev.proze.exceptions.ValidPassword;
import com.rev.proze.exceptions.ValidUsername;
import com.rev.proze.pojos.Login;
import com.rev.proze.pojos.User;
import com.rev.proze.util.Definitions;
import com.rev.proze.util.InputCollector;

public class SignupBO 
{
	public SignupBO() throws Custom
	{
		Properties prop = new Properties(); 
		prop.setProperty("log4j.rootLogger", "WARN");
		PropertyConfigurator.configure(prop);
		
		User user = null;
		Login login = null;
		String fn, ln, em, un, pw;
		fn = ""; ln = ""; em = ""; un = ""; pw = "";
		System.out.println(new Definitions().signUpHead);
		System.out.println(new Definitions().signInMid);
		try 						{	fn = new InputCollector().getName("first name");	} 
		catch (ValidName e) 		{	e.printStackTrace();								}
		System.out.println(new Definitions().signInMid);
		try 						{	ln = new InputCollector().getName("last name");		} 
		catch (ValidName e) 		{	e.printStackTrace();								}
		System.out.println(new Definitions().signInMid);
		try 						{	em = new InputCollector().getEmail("email");		} 
		catch (ValidEmail e) 		{	e.printStackTrace();								}
		System.out.println(new Definitions().signInMid);
		try 						{	un = new InputCollector().getUsername("username");	} 
		catch (ValidUsername e) 	{	e.printStackTrace();								}
		System.out.println(new Definitions().signInMid);
		try 						{	pw = new InputCollector().getPassword("password");	} 
		catch (ValidPassword e) 	{	e.printStackTrace();								}
		user = new UserDAO().save(fn, ln, em);
		login = new LoginDAO().save(un, pw, user.getId());
		login = new LoginDAO().getById(user.getId());
		System.out.println("user_id:"+user.getId()+" login_id:"+login.getId());
		try
		{
			
			if(user.getId()!=null && login.getId()!=null)
			{
				System.out.println(new Definitions().success);
			}
			else
			{
				user = null;
				
				new MainMenu();
			}
		}
		catch (NullPointerException e) { 	new MainMenu();}
	}
}
