package com.revature.IO;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class ReadFromConsole {

	public static void main(String[] args) {
		System.out.println("Welcome to hang the man");
		
		Scanner s = new Scanner(System.in);
		System.out.print("Name: ");
		String name = s.nextLine();
		
		int age = Integer.parseInt(s.nextLine());
		
	}

}
