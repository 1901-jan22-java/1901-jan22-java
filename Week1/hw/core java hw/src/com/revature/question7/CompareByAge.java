package com.revature.question7;

import java.util.Comparator;

public class CompareByAge  implements Comparator<Employee>
{
	@Override
	public int compare(Employee guy1, Employee guy2) 
	{

		if(guy1.getAge() < guy2.getAge())
			return -1;
		if(guy1.getAge() > guy2.getAge())
			return 1;
		return 0;
	}
}