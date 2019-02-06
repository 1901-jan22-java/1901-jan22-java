package com.revature.bank.main;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.bank.app.BankingInterface;
import com.revature.bank.pojos.Account;
import com.revature.bank.pojos.AccountType;

public class BankAppHelper {


    public BankAppHelper(){
    }

    /* MENU STRINGS! SO MANY! */
    // CREATE/LOGIN MENU
    public static final String MAIN_MENU =
            "Welcome to the Console Banking App!\n" +
                    "What would you like to do?\n\n" +
                    "\t(1) Create an User account.\n" +
                    "\t(2) Login into User account.\n\n" +
                    "Selection: ";

    // CREATE USERNAME
    public static final String CREATE_USERNAME_PROMPT =
            "Username Criteria:\n" +
                    "\t- Is a valid email.\n\n" +
                    "Username: ";
    public static final String CREATE_USERNAME_FAIL = "UNABLE TO CREATE USER WITH USERNAME: ";

    // CREATE PASSWORD
    public static final String CREATE_PASSWORD_PROMPT =
            "Password Criteria:\n\n" +
                    "\t-At least 8 characters.\n" +
                    "\t-Contains at least one digit\n" +
                    "\t-Contains at least one lower alphabetical character\n" +
                    "\t-Contains at least one upper alphabetical character\n" +
                    "\t-Contains at least one special character (@#%$^ etc.)\n" +
                    "\t-Does not contain space, tab, etc.\n\n" +
                    "Password: ";
    public static final String CREATE_PASSWORD_FAIL = "UNABLE TO CREATE USER WITH PASSWORD: ";

    // USER CREATED
    public static final String CREATE_USER_SUCCESS =
            "A user account has been created for you...\n" +
                    "\tWelcome to the Bank App!";
    // USER FAILED TO CREATE
    public static final String CREATE_USER_FAILURE =
            "Your user account failed to create! :(\n"
            		+ "\tPlease try again...";
    
    // CREATE USER EXITING
    public static final String CREATE_USER_EXIT =
    		"Exiting create new user...";

    /* LOGIN MENU */
    public static final String LOGIN_USERNAME_PROMPT = "Username: ";
    public static final String USERNAME_INVALID = "Invalid username!";
    public static final String LOGIN_PASSWORD_PROMPT = "Password: ";
    public static final String PASSWORD_INVALID = "Invalid password!";

    public static final String LOGIN_USER_SUCCESS = 
    		"Session has been created for user!\n"
    				+ "\tWelcome to the Bank App Proper!";
    public static final String LOGIN_USER_FAILURE =
            "Either or both your username or password was incorrect.\n"
            + "\tCould not log you in. :(";
    public static final String LOGIN_USER_EXIT = "Exiting login...!";
    
    
    /* SESSION MENU */
    private static final String SESSION_MENU =
            "Session Options:\n" +
                    "\t(1) Create Account\n" +
                    "\t(2) Logout\n" +
            "Accounts:\n";
    public static String sessionMenu(BankingInterface bi){
        ArrayList<Account> as = bi.getAccounts();

        StringBuilder sb = new StringBuilder(SESSION_MENU);
        int i = 3;
        for(Account a: as){
            sb.append("\t("+ i +")" + a.toString()+"\n");
            i++;
        }
        sb.append("Selection: ");

        return sb.toString();
    }
    
    public static final String SESSION_CREATE_ACCOUNT_TYPE_PROMPT =
    		"Create Account of Type:\n";
    public static String sessionAccountTypePrompt() {
    	StringBuilder sb = new StringBuilder(SESSION_CREATE_ACCOUNT_TYPE_PROMPT);
    	int i = 0;
    	for(AccountType at: BankingInterface.ACCOUNT_TYPES) {
    		sb.append("\t("+i+")"+at.getType());
    	}
    	return sb.toString();
    }
    
    private static final String SESSION_ACCOUNT_MENU = 
    		"Options:\n"
    				+ "\t(1) Withdraw\n"
    				+ "\t(2) Deposit";
    
    public static String sessionAccountPrompt(BankingInterface bi, int select) {
    	Account acc = bi.getAccounts().get(select);
    	StringBuilder sb = new StringBuilder("Account Details");
    	String accType = ""+acc.getAccountID();
    	
    	for(AccountType at: BankingInterface.ACCOUNT_TYPES) {
    		accType = at.getType();
    	}
    		
    	sb.append("\tAccount ID: "+acc.getAccountID());
    	sb.append("\tUser: "+bi.getUser().getUsername());
    	sb.append("\tAccount Type: " + accType);
    	sb.append("\tBalance: $"+acc.getBalance());
    	sb.append(SESSION_ACCOUNT_MENU);
    	return sb.toString();
    }
    
    public static final String SESSION_AMOUNT_PROMPT = "Amount: ";
    
    public static final String SESSION_LOGOUT =
    		"Logging out...\n"
    		+ "\tHave a nice day! :)";

    /* Helper Methods */
    public static String obfuscate(String str, int show) {
        StringBuilder sb = new StringBuilder(str.substring(0, show));
        for(int i = show; i < str.length(); i++){
            sb.append('*');
        }
        return sb.toString();
    }
    
    /*
    private BigInteger random;
    public BankAppHelper(BigInteger heyWhatAreYouDoing){
        Integer randsrc;
        do {
            randsrc = Integer.valueOf((int)(Math.random()*Integer.MAX_VALUE));
            random = new BigInteger(random.toString()+randsrc);
        } while (random.bitCount() < Integer.MAX_VALUE);
    }

    public String funPeek() {
        return random.toString();
    }
    */
}
