package com.revature.protect_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main implements BankingMethods{

    static List<Person> accounts = new ArrayList<>();
    static Scanner scanner  = new Scanner(System.in);
    private static Person bankRecord;
    private static Person currentRecord;

    public static void main (String[] args) {

            System.out.println("Welcome to Bank Inc");
            menu();

            boolean exit = false;
            while (exit == false) {

                String input = scanner.next();
                if (input.equals("m")) {
                    menu();
                } else if (input.equals("a")) {
                    newAccount();
                    System.out.println("Account Name: " + bankRecord.getFirstName() + " " + bankRecord.getLastName());
                    System.out.println("Account Balance: $" + bankRecord.getAccountBalance());
                    System.out.println(accounts.toString());
                    menu();
                } else if (input.equals("w")) {
                    withdraw(bankRecord);
                    menu();
                } else if (input.equals("d")) {
                    deposit(bankRecord);
                    menu();
                } else if (input.equals("q")) {
                    System.out.println("Thank you for choosing Bank Inc");
                    break;
                } else if (input.equals("c")) {
                    changeAccount();
                    menu();
                } else if (input.equals("r")){
                    removeAccount();
                    menu();
                } else if(input.equals("s")) {
                    showAll();
                    menu();
                }
                else {
                    System.out.println("Incorrect input. Please try again");
                    menu();
                }
            }
     }
     public static void menu() {
        System.out.println("Please choose an option from the menu: ");
        System.out.println("Please type 'a' if you would like to add a new account");
        System.out.println("Please type 'r' if you would like to remove an account");
        System.out.println("Please type 'w' if you would like to make a withdrawal");
        System.out.println("Please type 'd' if you would like to make a deposit");
        System.out.println("Please type 'c' if you would like to change your account");
        System.out.println("Please type 's' if you would like to show all your accounts");
        System.out.println("Please type 'm' if you would like to see the menu");
        System.out.println("Please type 'q' if you would like to quit");
    }
    public static void newAccount() {
        System.out.println("Please enter your first name:");
        String firstName = scanner.next();
        System.out.println("Please enter your last name:");
        String lastName = scanner.next();
        System.out.println("Please enter your initial bank balance:");
        int accountBalance = scanner.nextInt();


        bankRecord = new Person(firstName, lastName, accountBalance);
        accounts.add(bankRecord);

    }

    public static void withdraw(Person bankRecord) {
        if(!accounts.isEmpty()) {
            int newBalance;
            System.out.println("How much money would you like to withdraw?");
            int withrawalAmount = scanner.nextInt();

            if (withrawalAmount > bankRecord.getAccountBalance()) {
                System.out.println("You do not have enough money to withdraw");
            } else if (withrawalAmount < bankRecord.getAccountBalance()) {
                newBalance = bankRecord.getAccountBalance() - withrawalAmount;
                bankRecord.setAccountBalance(newBalance);
                System.out.println("Your new balance is $" + bankRecord.getAccountBalance());
            } else if (withrawalAmount == bankRecord.getAccountBalance()) {
                newBalance = bankRecord.getAccountBalance() - withrawalAmount;
                bankRecord.setAccountBalance(newBalance);
                System.out.println("Your new balance is $" + bankRecord.getAccountBalance());
            }
        } else {
            System.out.println("No accounts available. Please create account.");
        }

    }

    public static void deposit(Person bankRecord) {
        if(!accounts.isEmpty()) {
            int newBalance;
            System.out.println("How much money would you like to deposit?");
            int depositAmount = scanner.nextInt();

            newBalance = depositAmount + bankRecord.getAccountBalance();
            bankRecord.setAccountBalance(newBalance);
            System.out.println("Your new balance is $" + bankRecord.getAccountBalance());
        } else {
            System.out.println("No accounts available. Please create account.");
        }
    }

    public static void changeAccount() {
        if(!accounts.isEmpty()) {
            showAll();
            System.out.println("Please enter the index of the account that you would like to change to: Example[ index 1, index 2,...]");
            int index = scanner.nextInt();
            currentRecord = accounts.get(index - 1);
            //currentRecord = accounts.get(0);
            System.out.println("Your current account is " + currentRecord.toString());
            bankRecord = currentRecord;
        } else {
            System.out.println("No accounts available. Please create account.");
        }

    }
    //will remove account of user desired index
    public static void removeAccount() {
        if(!accounts.isEmpty()) {
            showAll();
            System.out.println("Please enter the index of the account that you would like to remove: Example[ index 1, index 2,...]");
            int index = scanner.nextInt();
            accounts.remove(index - 1);
        } else {
            System.out.println("No accounts available. Please create account.");
        }
    }

    public static void showAll() {
        if(!accounts.isEmpty()) {
            for(int i = 0; i < accounts.size(); i++) {
                System.out.println("Account " + (i + 1) +": " + accounts.get(i) + " ");
            }
        }
        else {
            System.out.println("No accounts available. Please create account.");;
        }
    }


}
