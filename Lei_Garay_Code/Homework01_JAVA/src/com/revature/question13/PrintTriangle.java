package com.revature.question13;

public class PrintTriangle {

	static void printTriangle(int numLines)
	{
		StringBuilder output = new StringBuilder();
		int count = 0;
		for (int i = 0; i < numLines; i++) {
			if(count==0)
			{
				output = output.append(" 0 ");
			}
			else
			{
				output = output.append(" 1 ");
			}
			System.out.println(output.reverse());
			if (count==2)
					count=0;
			else count++;
		}
	}
	
	public static void main(String[] args) {
		int numLines = 10;
		printTriangle(numLines);
	}
}
