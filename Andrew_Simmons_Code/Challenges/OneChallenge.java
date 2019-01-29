package challengeOne;

public class OneChallenge {

	public static void main(String[] args) {
		int points[]; // declaring an array with the INT type
		points = new int[] {1,3,7,2,5,10,11}; // setting values in the array. Size of this array is 7.
		int sumTarget = 13;
	    getPairsCount(points, sumTarget);
		
		
	}
	
    // Prints number of pairs in points[0..n-1] with sum equal 
    // to 'sumTarget' 
    public static void getPairsCount(int[] points, int sumTarget) 
    { 
  
        int count = 0;// Initialize result 
  
        // Consider all possible pairs and check their sums 
        for (int i = 0; i < points.length; i++) 
            for (int j = i + 1; j < points.length; j++) 
                if ((points[i] + points[j]) == sumTarget) 
                    count++; 
  
        System.out.printf("Count of pairs is %d",count); 
        //The program should count that there is two pair of numbers that can equal to that sum target 13 in this case
    } 

}
