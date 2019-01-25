package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;

import com.revature.pojos.Person;

public class ExploringComparisons {
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(new Person("Gen", "123"));
		people.add(new Person("g", "!241"));
		people.add(new Person("8917qiorfjandafiuehyufhdfj", "afa"));
		people.add(new Person("asfahs", "af"));
		System.out.println(people);
		Collections.sort(people,new ComparingObjects());
		System.out.println(people);
		
	
	}

}
