package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoreMethodsTest {
	
	MoreMethods m = new MoreMethods();

	@Test
	public void testAdd() {
		assertEquals(10, m.add(1, 4, 5));
	}

}
