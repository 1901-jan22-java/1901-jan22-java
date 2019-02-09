package com.revature.bank.app;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.bank.main.BankingInterface;
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
                    "\t(2) Login into User account.\n" +
                    "\t(*) Exit\n\n" +
            "Selection: ";

    // CREATE USERNAME
    public static final String CREATE_USERNAME_PROMPT =
            "Username Criteria:\n" +
                    "\t-Valid E-mail.\n" +
            "Username: ";

    // CREATE PASSWORD
    public static final String CREATE_PASSWORD_PROMPT =
            "Password Criteria:\n" +
                    "\t-At least 8 characters.\n" +
                    "\t-Contains at least one digit\n" +
                    "\t-Contains at least one lower alphabetical character\n" +
                    "\t-Contains at least one upper alphabetical character\n" +
                    "\t-Contains at least one special character (@#%$^ etc.)\n" +
                    "\t-Does not contain space, tab, etc.\n\n" +
            "Password: ";

    // USER CREATED
    public static final String CREATE_USER_SUCCESS =
            "A user account has been created for you...\n" +
                    "\tEnjoy using the Bank App!";
    // USER FAILED TO CREATE
    private static final String CREATE_USER_FAILURE =
            "Your user account failed to create! :(\n" +
                    "\tUNABLE TO CREATE USER WITH USERNAME:%s\n" +
                    "\tUNABLE TO CREATE USER WITH PASSWORD:%s\n" +
            "Please try again...";

    public static String createUserFailure(String username, String password){
        return String.format(CREATE_USER_FAILURE, username, password);
    }

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
            "Could not log you in! Username or password is incorrect.\n" +
                    "\tPlease try again! :D";

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


        if(as.isEmpty()){
            sb.append("\tYou have no accounts under this user. :(");
        }else {
            for(int i = 0; i < as.size(); i++)
                sb.append("\t(" + (i+3) + ")" + as.get(i).toString() + "\n");
        }
        sb.append("Selection: ");

        return sb.substring(0, sb.length()-1);
    }
    public static final String SESSION_INVALID_ACCOUNT_INDEX =
            "Invalid Account Index...\n" +
                    "\tPlease try again! :)";
    
    public static final String SESSION_CREATE_ACCOUNT_TYPE_PROMPT =
    		"Please select an Account Type:\n";
    public static String sessionAccountTypePrompt() {
    	StringBuilder sb = new StringBuilder(SESSION_CREATE_ACCOUNT_TYPE_PROMPT);
    	int i = 1;
    	for(AccountType at: BankingInterface.ACCOUNT_TYPES) {
    		sb.append("\t("+i+")"+at.getType());
    		i++;
    	}
    	return sb.toString();
    }
    public static final String SESSION_CREATE_ACCOUNT_TYPE_INVALID =
            "Invalid account type selection. Exit? Type \"exit\"";

    private static final String SESSION_ACCOUNT_MENU_HEADER =
            "Account Details\n" +
            "********************************************\n";

    public static String sessionAccountPrompt(BankingInterface bi, int select) {
    	Account acc = bi.getAccounts().get(select);
    	StringBuilder sb = new StringBuilder(SESSION_ACCOUNT_MENU_HEADER);

    	String accType = ""+acc.getTypeID();
    	for(AccountType at: BankingInterface.ACCOUNT_TYPES) {
    		if( at.getTypeID() == acc.getTypeID() ){
    		    accType = at.getType();
            }
    	}
    		
    	sb.append("\tAccount ID: "+acc.getAccountID() +
                "\tUser: "+bi.getUser().getUsername() +
                "\tAccount Type: " + accType +
                "\tBalance: $" + acc.getBalance());

    	sb.append(SESSION_ACCOUNT_MENU);
    	return sb.toString();
    }
    private static final String SESSION_ACCOUNT_MENU =
            "Options:\n" +
                    "\t(1) Withdraw\n" +
                    "\t(2) Deposit\n" +
            "Selection: ";


    public static final String SESSION_AMOUNT_PROMPT = "Amount: ";


    public static final String SESSION_LOGOUT =
    		"Logging out of session...";

    public static final String MAIN_MENU_EXIT =
            "Exiting the Banking App...\n" +
                    "\tHave a nice day! :)";

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
