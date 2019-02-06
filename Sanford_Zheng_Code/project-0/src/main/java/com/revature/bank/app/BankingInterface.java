package com.revature.bank.app;

import com.revature.bank.dao.AccountRepository;
import com.revature.bank.pojos.Account;
import com.revature.bank.pojos.User;

import java.util.ArrayList;

public class BankingInterface {

    private User user;
    private ArrayList<Account> user_acc;

    public BankingInterface(User user) {
        this.user = user;
        this.user_acc = new ArrayList<>();
    }

    public BankingInterface(User user, ArrayList<Account> user_acc) {
        this.user = user;
        this.user_acc = user_acc;
    }

    public boolean setUp(){
        this.user_acc = AccountRepository.getAccounts(user.getUserID());
        return true;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Account> getAccounts() {
        return user_acc;
    }

    public void setAccounts(ArrayList<Account> user_acc) {
        this.user_acc = user_acc;
    }
}
