package challenge.one;

public class ArraySum {
public boolean doesArraySum(int[] a,int target){
	int sum=0;
	
	for(int i=0;i<a.length-1;i++){
		for(int j=0;j<=i;j++){
		int s=a[i]+a[j+1];
		if(s==target){
			return true;
		}
	}
}
	return false;
}
public static void main(String[] args) {
	ArraySum sum=new ArraySum();
	int[] a={1,2,3,3,5,8};
	
	System.out.println(sum.doesArraySum(a, 1));
}
}
