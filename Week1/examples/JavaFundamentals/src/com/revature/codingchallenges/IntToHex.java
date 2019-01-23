package com.revature.codingchallenges;

public class IntToHex {
	
	public String convert(int num) {
		char[] vals = {'a', 'b', 'c', 'd', 'e', 'f'};
		String hex ="";
		while(num>0)
		{
			int curr = num%16;
			if(curr<10)
				hex = "" + curr + hex;
			else
				hex = "" + vals[curr-10] + hex;
		
			num/=16;
		}
		
		return hex;
	}

}