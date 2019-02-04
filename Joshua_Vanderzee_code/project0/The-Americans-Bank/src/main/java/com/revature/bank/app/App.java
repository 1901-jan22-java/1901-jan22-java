package com.revature.bank.app;

import com.revature.bank.jdbc.dao.UserAccountControler;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to American's Bank. \nChoose an option below.");
		UserAccountControler.Login("bob", "grgsdg");

	}

}
