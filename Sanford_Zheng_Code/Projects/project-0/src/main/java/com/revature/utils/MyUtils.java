package zheng.sanford.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {

	private static final String EMAIL_REGEX =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
	private static final String PASSWORD_REGEX =
			"^(?=.*[0-9])" +                // at least 1 digit
					"(?=.*[a-z])" +         // at least 1 lower
					"(?=.*[A-Z])" +         // at least 1 upper
					"(?=.*[@#$%^&+=])" +    // at least 1 special
					"(?=\\S+$)" +           // no spaces
					".{8,}$";               // at least 8


	/* Helper Methods */
	public static String obfuscate(String str, int show) {
		StringBuilder sb = new StringBuilder(str.substring(0, show));
		for(int i = show; i < str.length(); i++){
			sb.append('*');
		}
		return sb.toString();
	}

	/**
	 * This function formats any amount of strings to a normal name format;
	 *
	 * Regex would probably be better
	 * @param strArr
	 * @return
	 */
	public static String nameFormat(String...strArr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < strArr.length; i++) {
			String[] str = strArr[i].split(" ");
			for(int j = 0 ; j < str.length; j++) {
				String s2 = str[j];
				if(!s2.isEmpty()) {
					sb.append(Character.toUpperCase(s2.charAt(0)) + s2.substring(1).toLowerCase() + " ");
				}
			}
		}
		return sb.substring(0, sb.length()-1);
	}
	
	public static Double toMoney(Double dbl) {
		return ((double) ((long) (dbl*100))) / 100.0;
	}

    public static boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
    public static boolean isValidPassword(String pwd) {
        if(pwd == null) return false;
        return pwd.matches(PASSWORD_REGEX);
    }
	
	public static void main(String[] args) {
		System.out.println(obfuscate(nameFormat("SaNfoRd zHeNg",
				"CASEY NEISTAT", "PHILLY D DeFRaNco", "FORMATTING QUICK!"), 0));
	}
}
