package com.revature.bank.jdbc.dao;

import org.apache.log4j.Logger;

public class BackgroundNotifier implements Runnable {

	final static Logger logger = Logger.getLogger(BackgroundNotifier.class);
	
	@Override
	public void run() {
		boolean alert = false;
		logger.info("Started: " + BackgroundNotifier.class);
		while (true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			if (UserAccountControler.getLoginAtempt() >= 5)
			{
				if (!alert)
				{
					logger.info("Invalid Login Atempts detected. Contacting " + UserAccountControler.getEmailAlert());
					System.out.println("Some email implementation code would be run");
					while (UserAccountControler.getEmailAlert().equals("")) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					System.out.println(UserAccountControler.getEmailAlert());
					System.out.println("ALERT, Someone has used 5 or more incorrect password Atempts. \nIf this was you, please use forgot password. \n"
							+ "If not, we strongly urge you to check your account activity immediately. ");
					alert = true;
				}
			}
		}
	}

}
