package questionone;

class BubbleSort {
	void bubbleSort(int arr[]) {
		int n = arr.length; // length of our array in this case is 10
		for (int i = 0; i < n - 1; i++) // n-1 because array index starts at 0. Which mean the index will be 0 to 9 not
										// 1 to 10
			for (int j = 0; j < n - i - 1; j++) // 2nd for loop to prepare a way to compare two elements in the array
				if (arr[j] > arr[j + 1]) // swapper
				{
					// swap arr[j+1] and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	/* Prints the array */
	void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " "); // formats a space in between each number instead of combining all intergers
		System.out.println();
	}

	// Here we will test the our class to see if it works

	public static void main(String args[]) {
		BubbleSort ob = new BubbleSort();
		// Store numbers in an array in non organize fashion
		int arr[] = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		ob.bubbleSort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}
}
