package hw1.q17;

import java.util.Scanner;

public class Interest {
public double calculateInterest(double p, double rate, int time){
	double interest;
	interest=p*rate*time;
	return interest;
}
public static void main(String[] args) {
	System.out.println("Please enter the principle,rate, and time in that order");
	Scanner sc= new Scanner(System.in);
	double principle=(double) Integer.parseInt(sc.nextLine());
	double rate=(double) Integer.parseInt(sc.nextLine());
	int time= Integer.parseInt(sc.nextLine());
	Interest money=new Interest();
	double interestRate=money.calculateInterest(principle, rate, time);
	System.out.print("The interest rate is:"+" "+interestRate);
	
}
}
