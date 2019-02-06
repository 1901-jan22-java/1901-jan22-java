package zheng.sanford.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyUtils {
	public static String format(String...str) {
		ArrayList<String> strArr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(String s1: strArr) {
			String[] s1Arr = s1.split(" ");
			for(String s2: s1Arr) {
				if(!s2.isEmpty())
					sb.append(""+Character.toUpperCase(s2.charAt(0)) + s2.substring(1) + " ");
			}
		}
		return sb.toString();
	}
	
	public static Double toMoney(Double dbl) {
		return ((double) ((long) (dbl*100))) / 100.0;
	}

    /* 
     * Found online copy-pasta code
     * MIGRATE TO UTILS! means we delete these but we're short for time...
     * and we haven't even test run...D:
     */
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


    public static boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
    public static boolean isValidPassword(String pwd) {
        if(pwd == null) return false;
        return pwd.matches(PASSWORD_REGEX);
    }
	
	public static void main(String[] args) {
		double d = 12308.24789;
		
		System.out.println(toMoney(d));
		System.out.println(isValidEmail("create@create.com"));
	}
}
