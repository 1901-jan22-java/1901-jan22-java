package com.revature.question7;

import java.util.Comparator;

public class CompareByName implements Comparator<Employee>  {
	@Override
	public int compare(Employee guy1, Employee guy2) 
	{
		//if they're the same name, just return 0
		if(guy1.getName().equals(guy2.getName()))
			return 0;
		else
		{
			int i = 0;
			//runs and compares all the characters
			while(i < guy1.getName().length() && i < guy2.getName().length())
			{
				//if the character is the same, continue
				if((int)guy1.getName().charAt(i) == (int)guy2.getName().charAt(i))
					i++;
				else
				{
					//if the character is smaller at index, return -1
					if((int)guy1.getName().charAt(i) < (int)guy2.getName().charAt(i))
						return -1;
				
					//if the character is larger at index, return 1
					if((int)guy1.getName().charAt(i) > (int)guy2.getName().charAt(i))
						return 1;
					i++;
				}
			}
		
			//if this name is shorter, return -1. otherwise return 1
			if(guy1.getName().length() < guy2.getName().length())
				return -1;
			else
				return 1;
		
		}
	
	}
}
