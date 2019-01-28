/**
 * 
 */
package com.ex.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author edwin
 *
 */
public class MethodsToTestTest {
	
	MethodsToTest m;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BEFORE CLASS");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("AFTER CLASS");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		m = new MethodsToTest();
		System.out.println("BEFORE METHOD TEST");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		m = null;
		System.out.println("AFTER METHOD TEST");
	}

	/**
	 * Test method for {@link com.ex.junit.MethodsToTest#anagram(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAnagram() {
		//test if "hello" and "lolhe" are anagrams
		boolean expected = true;
		boolean actual = m.anagram("l", "l");
		
		assertEquals(expected, actual);
		
		assertTrue(m.anagram("hello",  "lolhe"));
		assertFalse(m.anagram("123", "456"));
	}

}
