package com.revature.Q15;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MathClassTest {
	MathClass m;
	@Before
	public void setUp() throws Exception {
		m = new MathClass();
	}

	@After
	public void tearDown() throws Exception {
		m = null;
	}

	@Test
	public void testAddition() {
		assertTrue(m.Addition(50, 5) == 55);
		assertFalse(m.Addition(50, 5) == 36);
	}

	@Test
	public void testSubtraction() {
		assertTrue(m.Subtraction(50, 5) == 45);
		assertFalse(m.Subtraction(50, 5) == 36);
	}

	@Test
	public void testMultiplication() {
		assertTrue(m.Multiplication(50, 5) == 250);
		assertFalse(m.Multiplication(50, 5) == 36);
	}

	@Test(expected = Exception.class)
	public void testDivision() throws Exception {
		try {
			assertTrue(m.Division(50, 5) == 10);
			assertFalse(m.Division(50, 5) == 36);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.Division(50, 0);
	}

}
