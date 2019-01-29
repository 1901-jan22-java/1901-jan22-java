package com.day6;

public class TargetSumInArray {

	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5};
		System.out.println(sumExists(arr, 10));
	}
	
	public static boolean sumExists(int[] arr, int value){
		boolean check = false;
		for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length; j++){
				if(arr[i] + arr[j] == value){
					check = true;
				} 
			}			
		}
		return check;
	}
}






