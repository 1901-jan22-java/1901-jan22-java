package com.revature.question12;

public class StoreInArray {
	
	static int[] storeInArray(int num){
		int[] newArr = new int[num];
		
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = (i+1);
		}
		
		for (int i : newArr) {
			if(i%2==0)
				System.out.print("i:"+i+"\t");
			if(i%20==0)
				System.out.println();
		}
		
		return newArr;
	}
	
	public static void main(String[] args) {
		storeInArray(100);
	}
}
