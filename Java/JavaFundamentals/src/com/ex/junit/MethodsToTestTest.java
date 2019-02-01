package com.ex.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit test example...
 * 
 * @author Sanford
 *
 */

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
	public void setUp() {
		m = new MethodsToTest();
		System.out.println("Before Method Test");
	}
	
	@After
	public void tearDown() {
		m = null;
		System.out.println("After Method Test");
	}
	
	/**
	 * Test method for {@link com.ex.junit.MethodsToTest#anagram(String, String)}
	 */
	
	@Test
	public void testAnagram() {
		// test if "hello" and "lolhe" are anagrams
		assertTrue(m.anagram("hello", "lolhe"));
		assertFalse(m.anagram("hello", "lolie"));
	}

}
