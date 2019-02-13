package com.rev.proze.app;

import com.rev.proze.bo.LoginBO;
import com.rev.proze.bo.SignupBO;
import com.rev.proze.exceptions.Custom;
import com.rev.proze.exceptions.SelectionInput;
import com.rev.proze.pojos.User;
import com.rev.proze.util.Definitions;
import com.rev.proze.util.InputCollector;

public class MainMenu 
{
	public MainMenu() throws Custom
	{
		User user = null;
		System.out.println(new Definitions().mainMenu);
		int option = 0;
		try 						{	option = new InputCollector().getUserCustomRange(1, 3);	} 
		catch (SelectionInput e) 	{	e.printStackTrace();									}
		
		switch(option)
		{
		case 1:		new LoginBO(user);
			break;
		case 2:		new SignupBO();
			break;
		case 3:		System.out.println(new Definitions().farewell);
					System.exit(0); break;
		}
	}
	
	public static void main(String[] args) throws Custom 
	{
		new MainMenu();
	}
}
