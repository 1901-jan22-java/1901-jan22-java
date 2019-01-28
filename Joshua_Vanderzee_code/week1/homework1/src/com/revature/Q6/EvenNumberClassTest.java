package com.revature.Q6;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvenNumberClassTest {

	@Test
	public void testIfEven() {
		for (long i = -2000000000; i < -2000000000; i+=2) {
			assertTrue(EvenNumberClass.IfEven(i));	
		}
		
		for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE - 1; i+=2) {
			assertTrue(EvenNumberClass.IfEven(i));	
		}
		
		for (int i = -10000000; i < 10000000; i+=2) {
			assertTrue(EvenNumberClass.IfEven(i));	
		}
		
		for (short i = Short.MIN_VALUE; i < Short.MAX_VALUE - 1; i+=2) {
			assertTrue(EvenNumberClass.IfEven(i));	
		}
	}
}
