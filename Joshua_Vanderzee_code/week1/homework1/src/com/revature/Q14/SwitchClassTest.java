package com.revature.Q14;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwitchClassTest {

	@Test
	public void testStartSwitchStates() throws Exception {
		SwitchClass.start(SwitchStates.DateToday);
		String[] actual = SwitchClass.start(SwitchStates.SplitString);
		String[] expected = {"I", "am", "learning", "Core", "Java"};
		for (int i = 0; i < expected.length; i++) {
			assertTrue(actual[i].equals(expected[i]));
		}
	}

	@Test()
	public void testStartSwitchStatesDouble() {
		SwitchClass.start(SwitchStates.sqrt, 2);
		SwitchClass.start(SwitchStates.sqrt, -5);
	}

}
