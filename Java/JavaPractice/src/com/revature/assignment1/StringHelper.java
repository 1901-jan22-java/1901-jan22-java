package com.revature.assignment1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Question 18
 * Question 21
 * Question 23
 * 
 * @author Sanford
 *
 */

public class StringHelper extends StringBase {
	
	public StringHelper(String s) {
		super.s = s;
	}

	public LocalDate toLocalDate() {
		LocalDate ld = toLocalDate(s);
		s = ld.toString();
		return ld;
	}
	
	public static LocalDate toLocalDate(String str) {
		ArrayList<String> formats = new ArrayList<>(Arrays.asList(
				"yyyy-MM-dd", "yyyy/MM/dd",
				"MM-dd-yyyy", "MM/dd/yyyy", 
				"LLL-dd-yyyy", "LLL/dd/yyyy"));
		
		for(String s: formats) {
			DateTimeFormatter f = DateTimeFormatter.ofPattern(s);
			try {
				return LocalDate.parse(str, f);
			} catch(DateTimeParseException e) {
//				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public String removeRepeats() {
		return s = removeRepeats(s);
	}
	
	public static String removeRepeats(String str) {
		HashSet<Character> hs = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		for(Character c: str.toCharArray()) {
			if(!hs.contains(c)) {
				hs.add(c);
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	@Override
	public boolean hasUpper() {
		for(Character c: s.toCharArray())
			if(c >= 'A' && c <= 'Z')
				return true;
		return false;
	}

	@Override
	public String toUpper() {
		StringBuilder sb = new StringBuilder();
		for(Character c: s.toCharArray()) {
			if(c >= 'a' && c <= 'z')
				c = (char) (c - 'a' + 'A');
			sb.append(c);
		}
		return s = sb.toString();
	}

	@Override
	public String addTen() {
		try {
			s = "" + Integer.parseInt(s) + 10;
		} catch(NumberFormatException e) {
		}
		
		return s;
	}
	
	@Override
	public String toString() {
		return this.s;
	}
	
}

abstract class StringBase {
	protected String s;
	public abstract boolean hasUpper();
	public abstract String toUpper();
	public abstract String addTen();
}

class StringHelperTest {
	
	// Test Case Strings
	private static final String[] testCases = {"01/27/2019", "21", "0", "-20",
			"lowerUPPER", "mix123ER", "mix123eRxxxxx", "noupper"};
	
	// Question 18 Expected Strings
	private static final boolean[] hasUpper = { false, false, false, false,
			true, true, true, false};
	private static final String[] toUpper = {"01/27/2019", "21", "0", "-10", 
			"LOWERUPPER", "MIX123ER", "MIX123ERXXXXX", "NOUPPER"};
	private static final String[] addTen = {"01/27/2019", "31", "10", "-10", 
			"lowerUPPER", "mix123ER", "mix123eRxxxxx", "noupper"};
	
	// Question 21 Expected Strings
	private static final String[] removeRepeats = {"01/279", "21", "0", "-20",
			"lowerUPER", "mix123ER", "mix123eR", "nouper"};
	
	// Question 23 Expected Strings
	private static final String[] toLocalDate = {"2019-01-27", null, null, null,
			null, null, null, null};
	private static final Class<NullPointerException> np = NullPointerException.class;
	private static final Class<?>[] toLocalDateException = { null, np, np, np,
			np, np, np, np};
	
	
	private static final ArrayList<StringHelper> shs = new ArrayList<>();
	
	@BeforeClass
	public static void setUpBeforeClass() {
		for(String str: testCases)
			shs.add(new StringHelper(str));
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		shs.clear();
		for(StringHelper sh: shs)
			System.out.println(sh);
	}
	
	@Test
	public static void q18test() {
		for(int i = 0; i < shs.size(); i++) {
			StringHelper sh = shs.get(i);
			Assert.assertEquals(hasUpper[i], sh.hasUpper());
			Assert.assertEquals(toUpper[i], sh.toUpper());
			Assert.assertEquals(addTen[i], sh.addTen());
		}
	}
	
	@Test
	public static void q21test() {
		for(int i = 0; i < shs.size(); i++) {
			StringHelper sh = shs.get(i);
			Assert.assertEquals(removeRepeats[i], sh.removeRepeats());
		}
	}
	
	@Test
	public static void q23test() {
		for(int i = 0; i < shs.size(); i++) {
			StringHelper sh = shs.get(i);
			try {
				Assert.assertEquals(toLocalDate[i], sh.toLocalDate().toString());
			} catch(Exception npe) {
				Assert.assertEquals(toLocalDateException[i], npe.getClass());
			}
		}
	}
	
}
