/**
 * 
 */
package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author torimadera
 *
 */
public class MethodsToTestTest {
	
	MethodsToTest m;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		m = new MethodsToTest();
		System.out.println("Before method test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		m = null;
		System.out.println("after method test");
	}

	@Test
	public void testAnagram() {
		//test if "hello" and "lolhe" are anagrams;
		boolean expected = true;
		boolean actual = m.anagram("hello", "lolhe");
		assertEquals(expected, actual);
		assertTrue(m.anagram("hello", "lolhe"));
		assertFalse(m.anagram("123", "111"));
	}
	
	@Test
	public void test2() {
		assertFalse("this test failed", m.anagram("111", "111"));
	}

}
