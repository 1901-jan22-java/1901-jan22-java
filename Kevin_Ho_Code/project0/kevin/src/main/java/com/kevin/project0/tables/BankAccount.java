package com.kevin.project0.tables;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
	private int accountNumber;	//primary key
	private double money;		//how much money in account
	private String type;		//checking or saving
	private String owner;		//who owns the account
	
	public BankAccount(int accountNumber, double money, String type, String owner)
	{
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
			money += console.nextDouble();
			return true;
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid input");
			return false;
		}
	}
	public double withdraw(Scanner console)
	{
		try{
			double amount = console.nextDouble();
			if(money - amount < 0)
			{
				System.out.println("Not enough balance");
				return 0;
			}
			
			money -= amount;
			return amount;
		} catch(InputMismatchException e)
		{
			System.out.println("Invalid input");
			return 0;
		}
	}
	@Override
	public String toString()
	{
		return 	"Account[ Account Number= " + accountNumber + 
				" Account Owner= " + owner + 
				" Money= " + money +	
				" Account Type= " + type + "]";
	}
}
