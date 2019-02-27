package com.revature.homework;

public class RepeatedChar
{
	public static void main(String[] args)
	{
		//hard coded string
		String rS = "maaaakkee";
		String outCome= rS.charAt(0)+"";
		int count =0;
		//converts to array
		char [] cA =rS.toCharArray();
		//repeats for the length of the array
		for(int i =0; i+1<cA.length; ++i)
		{
			//checks to see if a an extra char exsists
			if(rS.charAt(i) != rS.charAt(i+1))
			{
				//remove the char
				outCome += rS.charAt(i+1);
			}
        }
        //print the result
        System.out.println(outCome);
    }
}