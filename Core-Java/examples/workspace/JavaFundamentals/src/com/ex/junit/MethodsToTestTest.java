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
 * @author Genesis
 *
 */
public class MethodsToTestTest {
	
	MethodsToTest m;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		m = new MethodsToTest();
		System.out.println("before method test");
	}

	@After
	public void tearDown() throws Exception {
		m = null;
		System.out.println("after method test");
	}

	@Test
	public void testAnagram() {
		//test if "hello" and "lolhe" are anagrams
		boolean expected = true;
		boolean actual = m.anagram("hello", "lolhe");
		assertEquals(expected, actual);
		assertTrue(m.anagram("hello", "lolhe"));
		assertFalse(m.anagram("123", "111"));
		assertFalse(m.anagram("aasd", "asde"));
	}
	
	@Test
	public void test2() {
		assertFalse("this test passed", m.anagram("car", "arc"));
	}

}
