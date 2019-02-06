package com.revature.protect_0;

public class Person {

    String firstName;
    String lastName;
    int accountBalance;

    public Person(String firstName, String lastName, int accountBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountBalance = accountBalance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return firstName + " " + lastName + " " + accountBalance;
    }


}