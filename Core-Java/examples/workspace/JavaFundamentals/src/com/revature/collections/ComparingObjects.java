package com.revature.collections;

import java.util.Comparator;

import com.revature.pojos.Person;

public class ComparingObjects implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getName().length() - o2.getName().length();
	}

}
