package com.revature.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * In Java, a Collection is a group of individual objects represented as a single unit. We use them to store and
 * organize groups of objects. Java's Collection interface is extended by 3 major interfaces: List, Set and Queue.
 * Also associated with Collections are Maps, which hold (Key, Value) pairs.
 * 
 * @author Sanford Zheng
 *
 */

public class UnderstandingCollections {
	
	public void listExample() {
		
		/*
		 * A list is an ordered collection of elements in which duplicate values can be stored. Since List preserves
		 * the insertion order, it allows positional access (by index) and insertion of elements.
		 * 
		 * Class that extend list include ArrayList, LinkedList, Vector and Stack
		 */
		
		List<Object> a = new ArrayList<>();

		a.add("");
		a.add(5);
		a.add(4.2);
		
		List<String> b = new ArrayList<>();
		
		b.addAll( Arrays.asList("hello", "world") );
		
		/*
		 * LinkedLists are linear data structures where elements are not stored in contiguous locations and every element
		 * is a separate object with a link to its successor.
		 * 
		 * Each element is known as a node.
		 * The fist element is referred to as the head.
		 */
		
		LinkedList<String> linked = new LinkedList<String>();
		
		linked.add("123");
		linked.add("234");
		linked.add("10");
		
		
		linked.removeFirstOccurrence("10");
		
	}
	
}
