package com.revature.bank.jdbc.dao;

public class BackgroundNotifier implements Runnable {

	@Override
	public void run() {
		boolean alert = false;
		while (true)
		{
			if (UserAccountControler.getLoginAtempt() >= 5)
			{
				if (!alert)
				{
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
