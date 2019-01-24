package question_12;

public class Fancy_100_Print {
	public static void main(String[] args) {
		int[] num = new int[100];
		for(int i=0; i<num.length; i++) 
			num[i] = i;
		for(int n : num)
			System.out.println(n);
	}
}
