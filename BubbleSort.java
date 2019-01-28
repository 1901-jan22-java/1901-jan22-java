package hw1.q1;

public class BubbleSort  {
	
public void bubbleSort() {
	int[] bub= new int[]{1,0,5,6,3,2,3,7,9,8,4};
	for(int i=0;i<bub.length-1;i++) {
		for(int j=0;j<bub.length-i-1;j++) {
			if(bub[j]>bub[j+1]) {
				int temp=bub[j];
				bub[j]=bub[j+1];
				bub[j+1]=temp;
			}
		}
	}
	for(int i=0;i<bub.length;i++){
		System.out.print(bub[i]);
	}
}
public static void main(String[] args) {
	BubbleSort bub=new BubbleSort();
	bub.bubbleSort();


}
}
