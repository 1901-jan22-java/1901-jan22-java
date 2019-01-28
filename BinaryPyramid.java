package hw1.q13;

public class BinaryPyramid {
public static void makePyramid() {
	int[] bin= new int[4];
	bin[0]=0;bin[1]=1;bin[2]=0;bin[3]=1;
	for(int i=0;i<4;i++) {
		for(int j=0;j<=i;j++) {
			
			System.out.print(bin[j]+" ");
		}
		System.out.println(" ");
	}
}
public static void main(String[] args) {
	makePyramid();
}
}
