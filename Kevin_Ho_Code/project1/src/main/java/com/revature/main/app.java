package com.revature.main;

import com.revature.user.UserRepo;

public class app {
	public static void main(String[] args) {
		UserRepo userrepo = new UserRepo();
		userrepo.addUser("kevinuser", "kevinpass", "kevin", "ho", "kevho48@gmail.com", 0);
	}
}