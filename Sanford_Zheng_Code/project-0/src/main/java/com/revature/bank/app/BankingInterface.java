package com.revature.bank.app;

import com.revature.bank.dao.AccountRepository;
import com.revature.bank.dao.AccountTypeRepository;
import com.revature.bank.pojos.Account;
import com.revature.bank.pojos.AccountType;
import com.revature.bank.pojos.User;

import java.util.ArrayList;

public class BankingInterface {

    private User user;
    private ArrayList<Account> accounts;

    public BankingInterface(User user) {
        signIn(user);
        setUp();
    }

    public boolean signIn(User user){

        return true;
    }

    public boolean signIn(String username, String password){

        return true;
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
