package com.ex.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoreMethodsTest {

	MoreMethods m;
	

	@Before
	public void setUp() throws Exception {
		m = new MoreMethods();
	}

	@After
	public void tearDown() throws Exception {
		m = null;
	}

	@Test
	public void testAdd() {
		assertEquals(10, m.add(1, 4, 5));
	}

}
