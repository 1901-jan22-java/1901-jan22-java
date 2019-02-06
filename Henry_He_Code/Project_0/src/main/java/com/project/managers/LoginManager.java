package com.project.managers;

import org.apache.log4j.Logger;

import com.project.managers.AccountManager.InputException;

public class LoginManager extends Manager {

	final static Logger logger = Logger.getLogger(LoginManager.class);
	
	@Override
	public void takeover() {
		String[] data = new String[2];
		String input;
		
		while(true) {
			
			System.out.println("\nPlease enter your username.");
			input = scan.nextLine();
			if(input.toLowerCase().equals("quit")) {
				return;
			} else data[0] = input;
			
			System.out.println("\nHello " + data[0] + ", please enter your password");
			input = scan.nextLine();
			if(input.toLowerCase().equals("quit")) {
				return;
			} else data[1] = input;
			
			logger.info("Data Array: " + data[0] + " : " + data[1] );
			String userid = Manager.dao.login(data[0],data[1]);
			if(userid != null) {
				new AccountManager().takeover(userid);
				break;
			}
		}
		
		return;
	}

	
}
