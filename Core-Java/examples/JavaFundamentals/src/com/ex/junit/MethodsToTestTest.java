/**
 * 
 */
package com.ex.junit;

//import static is like using namespace std
//now all the properties in the system class do not need system to be written out
//System.out.println becomes out.println()
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Kevin's MemeMachine
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
		System.out.println("before method test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		m = null;
		System.out.println("after method test");
	}

	/**
	 * Test method for {@link com.ex.junit.MethodsToTest#anagram(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAnagram() {
		//test if "hello" and lolhe" are anagrams
		boolean expected = true;
		boolean actual = m.anagram("hello", "lolhe");
		assertEquals(expected, actual);
		
		assertTrue(m.anagram("hello", "lolhe"));
		assertFalse(m.anagram("123", "111"));
		
	}

}
