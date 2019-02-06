package com.revature.bank.app;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.bank.dao.AccountRepository;
import com.revature.bank.dao.AccountTypeRepository;
import com.revature.bank.dao.UserRepository;
import com.revature.bank.exceptions.NoSuchBankUserException;
import com.revature.bank.pojos.Account;
import com.revature.bank.pojos.AccountType;
import com.revature.bank.pojos.User;

public class BankingInterface {

	private static final Logger logger = Logger.getLogger(BankingInterface.class);
	
    private User user;
    private ArrayList<Account> accounts;

    public BankingInterface(User user) throws NoSuchBankUserException {
        signIn(user);
        setUp();
    }
    
    public boolean signIn(User user) throws NoSuchBankUserException {
        return signIn(user.getUsername(), user.getPassword());
    }

    public boolean signIn(String username, String password) throws
    	NoSuchBankUserException
    {
    	try {
    		user = UserRepository.getUser(username);
    		if(user.getPassword().equals(password))
    			return true;
    	} catch (NoSuchBankUserException e) {
    		logger.error("NoSuchBankUserException from signing in!", e);
    		throw new NoSuchBankUserException();
    	}
    	return false;
    }

    public boolean setUp(){
        if(user == null || user.getUsername() == null || user.getUserID() == null) return false;
        this.accounts = AccountRepository.getAccounts(user.getUserID());
        return true;
    }

    // Get safe clone
    public User getUser() {
        return new User(user.getUsername(), user.getPassword());
    }

    // Get deep clone
    public ArrayList<Account> getAccounts() {
        ArrayList<Account> dc = new ArrayList<>();
        for(Account acc: accounts)
            dc.add(new Account(
                    acc.getAccountID(),
                    acc.getUserID(),
                    acc.getTypeID(),
                    acc.getBalance()
            ));
        return dc;
    }

    /**
     * TO-DO:
     *  How to handle this? Not sure... maybe not at all...
     *  just use AccountTypeRepository every time and deprecate
     *  this instead?
     */
    private static final ArrayList<AccountType> accountTypes = AccountTypeRepository.getAccountTypes();

    /**
     * Probably should be deprecate... we don't want users to add their own accounts list
     *
     * @deprecated
     *
     * @param user
     * @param accounts
     */
    public BankingInterface(User user, ArrayList<Account> accounts) {
        this.user = user;
        this.accounts = accounts;
    }
}
