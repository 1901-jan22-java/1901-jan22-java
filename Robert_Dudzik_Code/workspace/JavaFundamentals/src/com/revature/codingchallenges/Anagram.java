package com.revature.codingchallenges;

public class Anagram {


	public static boolean anagram(String first, String second)
	{
		boolean results = false;
		//Check if its even the same length
		if(first.length() != second.length())
			return results;
		else
		{
			//Get the length to iterate through the first word
			int lengthStr = first.length();
			while(lengthStr > 0)
			{
				//Get an original length to see if it changes
				int origin = lengthStr;
				//Checks all the letters in the second string to see 
				//if any match the last letter in the first string
				for(int i = 0; i < second.length(); i++)
				{
					//If you find it break the loop and reduce the length
					if(first.charAt(lengthStr - 1) == second.charAt(i))
					{
						lengthStr--;
						break;
					}
				}
				//Is the origin the same if so false
				if(origin == lengthStr)
					return false;
			}
			results = true;
		}
		return results;
	}
	
	public static void main(String[] args)
	{
		System.out.println(anagram("cat", "tc"));
		
	}
}
