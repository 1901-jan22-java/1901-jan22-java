package hw1.q12;

public class StoreArray {
public void printEven() {
	int[] num= new int[99];
	for(int i=1;i<=100;i++) {
		num[i]=i;
	}
	for(int nums:num)
		System.out.print(nums);
}
}
