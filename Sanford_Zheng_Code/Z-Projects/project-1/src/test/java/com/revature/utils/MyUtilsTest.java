package com.revature.utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class MyUtilsTest {

	private static final String[] NAME_FORMAT_TEST = {
			"SaNfoRd           zHeNg",
			"        CASEY NEISTAT            ", 
			"PHILLY D DeFRaNco            ",
			"         FORMATTING   QUICK!"
			};
	private static final String NAME_FORMAT_EXPECTED = 
			"Sanford Zheng Casey Neistat Philly D Defranco Formatting Quick!";
	
	private static final String[] obfuscateExpected = {
			"S**************************************************************",
			"Sa*************************************************************",
			"San************************************************************",
			"Sanf***********************************************************"
			};
	
	@Test
	public void test() {
		String nameFormatActual = MyUtils.nameFormat(NAME_FORMAT_TEST);
		String[] obfuscateActual = {
				MyUtils.obfuscate(nameFormatActual, 1), 
				MyUtils.obfuscate(nameFormatActual, 2), 
				MyUtils.obfuscate(nameFormatActual, 3),
				MyUtils.obfuscate(nameFormatActual, 4)
		};

		assertEquals(NAME_FORMAT_EXPECTED, nameFormatActual);
		assertArrayEquals(obfuscateExpected, obfuscateActual);
		fail("This test case kinda sucks");
	}

}
