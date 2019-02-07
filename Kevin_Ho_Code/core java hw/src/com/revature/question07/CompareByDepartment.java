package com.revature.question07;

import java.util.Comparator;

public class CompareByDepartment implements Comparator<Employee>
{
	@Override
	public int compare(Employee guy1, Employee guy2) 
	{
		//if they're the same name, just return 0
		if(guy1.getDepartment().equals(guy2.getDepartment()))
			return 0;
		else
		{
			int i = 0;
			//runs and compares all the characters
			while(i < guy1.getDepartment().length() && i < guy2.getDepartment().length())
			{
				//if the character is the same, continue
				if((int)guy1.getDepartment().charAt(i) == (int)guy2.getDepartment().charAt(i))
					i++;
				else
				{
					//if the character is smaller at index, return -1
					if((int)guy1.getDepartment().charAt(i) < (int)guy2.getDepartment().charAt(i))
						return -1;
				
					//if the character is larger at index, return 1
					if((int)guy1.getDepartment().charAt(i) > (int)guy2.getDepartment().charAt(i))
						return 1;
					i++;
				}
			}
		
			//if this name is shorter, return -1. otherwise return 1
			if(guy1.getDepartment().length() < guy2.getDepartment().length())
				return -1;
			else
				return 1;
		}
	}
}
