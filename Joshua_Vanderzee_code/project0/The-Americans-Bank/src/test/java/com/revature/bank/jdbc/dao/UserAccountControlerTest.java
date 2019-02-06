package com.revature.bank.jdbc.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.revature.bank.jdbc.pojos.User;

public class UserAccountControlerTest {

	@Test
	public void testLogin() {
		assertFalse(UserAccountControler.Login("szig", "1392") > 0);
		assertFalse(UserAccountControler.Login("szig", "139g") > 0);
		assertFalse(UserAccountControler.Login("szig", "132g") > 0);
		assertFalse(UserAccountControler.Login("szig", "192g") > 0);
		assertFalse(UserAccountControler.Login("szig", "392g") > 0);
		assertTrue(UserAccountControler.Login("szig", "1392g") > 0);
	}

	@Test
	public void testCreateAccount() {
		boolean temp = false;
		if (temp) {
			try {
				User user = new User(-1, "szig", "1392g", "Sue", "Zig", 
						"What is your friend's name?", "Greg", "What is your pet's name?", "Rover", "What is your spouse's name", "Bob", 
						"576 Plesent Avenue", "", "Danville", "FL", "USA", 19478, 
						1843466786l, 4843577168l, 0, "szig@gmail.com", 187826625, Date.valueOf("1980-7-11"), "Married");
				assertTrue(UserAccountControler.CreateUser(user));
				System.out.println(user.getUserId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
