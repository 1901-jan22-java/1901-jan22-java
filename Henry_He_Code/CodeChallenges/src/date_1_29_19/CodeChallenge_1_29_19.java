package date_1_29_19;

public class CodeChallenge_1_29_19 {

	/**
	 * Given an array of ints and a target value, write a method
	 * to determine whether there exists two numbers in the array 
	 * whose sum is the target value.
	 * 
	 * i.e: [1,3,7,2,5,10] , 13
	 */
	
	static boolean checkSumPair(int[] arr, int target) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]+arr[j]==target)
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,3,7,2,5,10};
		int target1 = 13;
		int[] arr2 = {2,4,6,8};
		int target2 = 7;
		System.out.println(checkSumPair(arr1,target1));
		System.out.println(checkSumPair(arr2,target2));
	}
	
}
