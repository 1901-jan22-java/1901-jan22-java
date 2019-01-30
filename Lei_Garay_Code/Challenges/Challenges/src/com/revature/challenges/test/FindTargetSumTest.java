package com.revature.challenges.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindTargetSumTest {

	FindTargetSum object;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		boolean expected = true;
		boolean actual = object.findAddends(new int[] {1,2,3,4,5}, 5);
		assertEquals(expected,actual);
		expected = false;
		actual = object.findAddends(new int[] {1,1,2,2,2,2}, 5);
		assertEquals(expected,actual);
	}

}
