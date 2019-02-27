package com.ex.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MethodsToTestTest {

	MethodsToTest m;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@Before
	public void setUp() throws Exception {
		m = new MethodsToTest();
		System.out.println("Before");
	}

	@After
	public void tearDown() throws Exception {
		m = null;
		System.out.println("After");
	}

	@Test
	public void testAnagram() {
		//test if 'hello' and 'lol' are anagrams
		boolean expected = true;
		boolean actual = m.anagram("hello", "lolhe");
		assertEquals(expected, actual);
		assertTrue(m.anagram("hello", "lolhe"));
		assertFalse(m.anagram("123", "111"));
	}

}
