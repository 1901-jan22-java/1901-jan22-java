package com.revature.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UnderstandingCollections {

	/*
	 * In Java, a Collection is a group of individual 
	 * objects represented as a single unit. 
	 * We use them to store and organize our groups of
	 * objects. 
	 * Java's Collection interface is extended by 3 major
	 * interfaces: List, Set, and Queue. 
	 * Also associated with Collections are Maps, which 
	 * hold Key, Value pairs 
	 */
	
	public static void main(String[] args) {
		listExample();
	}
	
	public static void listExample() {
		/*
		 * A list is an ordered collection of elements in
		 * which duplicate values can be stored. Since 
		 * List preserves the insertion order, it allows 
		 * positional access (by index) and insertion of elements 
		 * 
		 * Classes that extend list include ArrayList, LinkedList, 
		 * Vector, and Stack
		 */
		
		
		//the following is bad! only use collections with Generic types
		List a = new ArrayList();
		a.add("hello this is a string");
		a.add(5);
		a.add(7.9);
		a.add(false);
		a.add(new Object());
		
		List<String> strings = new ArrayList<String>();
		//strings.add(2); //cannot add elements that arent strings!
		strings.add("hello");
		strings.add("world");
		strings.add(1, "middle");
		//strings.add(10, "testing");
		System.out.println(strings);
	
		/*
		 * LinkedLists are linear data structures where 
		 * elements are not stored in contiguous locations 
		 * and every element is a separate object with a 
		 * link to its successor 
		 * Each element is known as a node. 
		 * The first element is referred to as the head
		 */
		
		LinkedList<String> linked = new LinkedList<String>();
		linked.add("123");
		linked.add("234");
		linked.add("10");
		for(String s : linked) {
			System.out.println(s);
		}
		System.out.println(linked.get(2));
		System.out.println(linked.removeFirstOccurrence("10"));
		System.out.println(linked);
		
	}
}
