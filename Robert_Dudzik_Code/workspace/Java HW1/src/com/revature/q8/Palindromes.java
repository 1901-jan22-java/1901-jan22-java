package com.revature.q8;

import java.util.ArrayList;
import com.revature.q3.*;

public class Palindromes 
{
	public static ArrayList<String> palindrome = new ArrayList<String>();
	public static void main(String[] args)
	{
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("karan"); arr.add("madam"); arr.add("tom"); arr.add("civic");
		arr.add("radar"); arr.add("sexes"); arr.add("jimmy"); arr.add("kayak");
		arr.add("john"); arr.add("refer"); arr.add("billy"); arr.add("did");
		GetPalindromes(arr);
		System.out.println(palindrome);
	}
	
	public static void GetPalindromes(ArrayList<String> arr)
	{
		for(int i = 0; i < arr.size() - 1; i++)
		{
			String test = arr.get(i);
			Reverse rev = new Reverse();
			test = rev.ReverseString(test);
			if(test.equalsIgnoreCase(arr.get(i)))
			{
				palindrome.add(test);
			}
		}
	}
}
