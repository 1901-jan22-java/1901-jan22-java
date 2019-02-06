package com.revature.bank.main;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAppHelper {

    private BigInteger random;

    public BankAppHelper(){
        Integer limit = Integer.MAX_VALUE;
        Integer randsrc;
        do {
            randsrc = Integer.valueOf((int)(Math.random()*Integer.MAX_VALUE));
            random = new BigInteger(random.toString()+randsrc);
        } while (random.bitCount().compareTo( Integer.MAX_VALUE ) >= 0);
    }

    /* MENU STRINGS! SO MANY! */
    // CREATE/LOGIN MENU
    public static final String CREATE_LOGIN_MENU =
            "Welcome to the Console Banking App!\n" +
                    "What would you like to do?\n\n" +
                    "\t(1) Create an User account.\n" +
                    "\t(2) Login into User account.\n\n" +
                    "Selection: ";

    // CREATE USERNAME
    public static final String PROMPT_USERNAME_MENU =
            "Username Criteria:\n" +
                    "\t- Is a valid email.\n\n" +
                    "Username: ";
    public static final String USERNAME_INVALID = "UNABLE TO CREATE USER WITH USERNAME: ";

    // CREATE PASSWORD
    public static final String CREATE_PASSWORD_MENU =
            "Password Criteria:\n\n" +
                    "\t-At least 8 characters.\n" +
                    "\t-Contains at least one digit\n" +
                    "\t-Contains at least one lower alphabetical character\n" +
                    "\t-Contains at least one upper alphabetical character\n" +
                    "\t-Contains at least one special character (@#%$^ etc.)\n" +
                    "\t-Does not contain space, tab, etc.\n\n" +
                    "Password: ";
    public static final String PASSWORD_INVALID = "UNABLE TO CREATE USER WITH PASSWORD: ";

    // USER CREATED
    public static final String USER_CREATED =
            "A user account has been created for you...\n\n" +
                    "\tWelcome to the Bank App!";


    /* SESSION MENU */
    public static final String SESSION_MENU =
            "\n";

    // Validators copied from online
    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
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
        return matcher.find();
    }

    public static boolean isValidPassword(String pwd) {
        if(pwd == null) return false;
        return pwd.matches(PASSWORD_REGEX);
    }

    public static String obfuscate(String str, int show) {
        StringBuilder sb = new StringBuilder(str.substring(0, show));
        for(int i = show; i < str.length(); i++){
            sb.append('*');
        }
        return sb.toString();
    }

}
