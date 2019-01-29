package com.revature.hw1.Q8;

import java.util.ArrayList;

public class Q8 {
	public static void Palindrones(ArrayList<String> reg, ArrayList<String> pal) {
		for(int i=0; i< reg.size(); i++) {
			char c[] = reg.get(i).toCharArray();
			String temp ="";
			for(int j=c.length-1;j>=0;j--) {
				temp+= c[j];
			}
			pal.add(temp);
		}
	}

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("karan"); strings.add("madam"); strings.add("tom");
		strings.add("civic"); strings.add("radar"); strings.add("sexes");
		strings.add("jimmy"); strings.add("kayak"); strings.add("refer");
		strings.add("billy"); strings.add("did");
		
		ArrayList<String> Palindrones = new ArrayList<String>();
		Palindrones(strings,Palindrones);
		System.out.println("Here are the Palindrones");
		for(int i=0; i<Palindrones.size();i++) {
			System.out.println(Palindrones.get(i));
		}
		
		
	}
}
