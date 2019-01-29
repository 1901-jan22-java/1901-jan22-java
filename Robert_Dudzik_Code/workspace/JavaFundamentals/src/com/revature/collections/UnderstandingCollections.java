package com.revature.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UnderstandingCollections 
{

	/*
	 * IN Java, a Collection is a group of individual objects
	 * represented as a single unit. We use them to store and organize
	 * our groups of objects. Java's Collections interface is extended by 3
	 * major interfaces: List, Set and Queue. Also associated with Collections
	 * are Maps, which hold Key, and Value pairs
	 * */
	
	public static void main(String[] args)
	{
		listExample();
	}
	
	public static void listExample()
	{
		/*
		 * A list is an ordered collection of elements in which duplicate values can
		 * be stored. Since list preserves the insertion order, it allows positional
		 * access (by index) and insertion of elements
		 * 
		 * Classes that extend list include ArrayList, LinkedList, Vector, and Stack
		 * */
		
		//The following is bad
		List a = new ArrayList();
		a.add("hello tis bad");
		a.add(5);
		a.add(7.9);
		a.add(false);
		
		
		//This is the correct way to use lists
		List<String> strings = new ArrayList<String>();
		strings.add("hello");
		strings.add("world");
		System.out.println(strings);
		
		/*
		 * LinkedLists are linear data structures where elements are not stored
		 * in contiguous locations and every element is a separate object with 
		 * a link to its successor. Each element is known as a node. The first 
		 * element is referred to as the head, the last element is referred to as 
		 * the tail
		 * */
		
		LinkedList<String> linked = new LinkedList<String>();
		linked.add("123");
		linked.add("234");
		linked.add("10");
	}
}
