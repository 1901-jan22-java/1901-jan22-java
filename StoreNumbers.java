package hw1.q9;

import java.util.ArrayList;

public class StoreNumbers {
public void printPrime() {
	int[] list=new int[99];
	ArrayList<Integer> newList= new ArrayList<Integer>();
	for(int i=1;i<=100;i++) {
		newList.add(i);
	}
	for(int i=0;i<newList.size();i++) {
		if(newList.get(i)%2!=0) {
			System.out.print(i);
		}
	}
}
}
