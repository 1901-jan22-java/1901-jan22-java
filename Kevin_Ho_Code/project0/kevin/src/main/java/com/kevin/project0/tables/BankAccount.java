package com.kevin.project0.tables;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kevin.project0.exception.BadMoneyException;

public class BankAccount {
	private int accountNumber;	//primary key
	private double money;		//how much money in account
	private String type;		//checking or saving
	private String owner;		//who owns the account
	
	public BankAccount(int accountNumber, double money, String type, String owner)
	{
		super();
		this.accountNumber = accountNumber;
		this.money = money;
		this.type = type;
		this.owner = owner;
	}
	public BankAccount() {
		
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public boolean deposit(Scanner console)
	{
		System.out.println("Enter the amount you want to deposit");
		try{
			double x = console.nextDouble();
			if(x < 0)
			{
				System.out.println("Cannot deposit negative numbers");
				return false;
			}
			else
				money -= x;
			System.out.println("Deposit success");
			return true;
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid input");
			return false;
		}
	}
	public boolean withdraw(Scanner console) throws BadMoneyException
	{
		System.out.println("Enter the amount you want to withdraw");
		try{
			double amount = console.nextDouble();
			if(amount < 0)
			{
				System.out.println("Cannot withdraw a negative amount");
				return false;
			}
			else
				if(money - amount < 0)
					throw new BadMoneyException("Not enough money");
			
			money -= amount;
			System.out.println("Withdraw success");
			return true;
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid input.");
			return false;
		}
	}
	@Override
	public String toString()
	{
		return 	"Account Number= " + accountNumber + "	" + 
				"Account Owner= " + owner + "	" +
				"Money= " + money + "	" +
				"Account Type= " + type;
	}
}
