package question_1;

public class BubbleSort {

	/*
	 * Fairly straight-forward; just sort adjacent indices and making n-1 pass throughs 
	 */
	
	
	static void sort(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			for(int j=i; j<arr.length; j++) {
				if( arr[j-1] > arr[j] ) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		sort(arr);
		for(int n : arr) System.out.print(n + " ");
	}
	
}
