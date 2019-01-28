package question12;

public class ArrayEvenCounter {
	public static void main(String[] args) {

		int points[]; // declaring an array with the INT type
		points = new int[100]; // set the array size to 100

//here we use a normal for loop to populate the array with data

		for (int i = 0; i < points.length; i++) {
			points[i] = i + 1; // populates the array

		}

//enchance for loop we can use to iterate through the array
		for (int x : points) {

			if (x % 2 == 0) {

				System.out.println(x);

			}
		}

	}
}
