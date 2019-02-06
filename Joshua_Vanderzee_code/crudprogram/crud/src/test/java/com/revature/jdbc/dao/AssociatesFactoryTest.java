package com.revature.jdbc.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.jdbc.pojos.Associate;

public class AssociatesFactoryTest {

	@Test
	public void testCreateAccount() {
		Associate a = new Associate();
		a.setFirstname("Malik");
		a.setLastname("White");
		a.setEmail("Malik1@gmail.com");
		a.setPassword("123");
		a.setGrade("80");
		if (AssociatesFactory.CreateAccount(a) > 0)
		{
			assertTrue(true);
		}
		else if (AssociatesFactory.CreateAccount(a) == 0)
		{
			assertFalse(false);
		}
	}

}
