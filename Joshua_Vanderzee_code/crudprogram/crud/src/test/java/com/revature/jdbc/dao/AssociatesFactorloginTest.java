package com.revature.jdbc.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssociatesFactorloginTest {

	@Test
	public void test() {
		assertTrue(AssociatesFactory.Login("malik1@gmail.com", "123") > 0);
	}

}
