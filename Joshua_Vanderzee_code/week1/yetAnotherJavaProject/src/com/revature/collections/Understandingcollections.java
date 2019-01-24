package com.revature.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Understandingcollections {

	public static void main(String[] args) {
		listExample();
	}
	
	private static void listExample() {
		//bad
		
		/*
		List a = new ArrayList<>();
		a.add("");
		a.add(5);
		a.add(7.9);
		a.add(false);
		a.add(new Object());
		
		List<String> strings = new ArrayList<String>();
		strings.add("Hello");
		strings.add("Java");
		strings.add("World");
		System.out.println(strings);
		
		LinkedList<String> linked = new LinkedList<String>();
		linked.add("fdghg");
		linked.add("fdvdfsbgfgghg");
		linked.add("fdghmjkgghfg");
		
		for (String i: linked) {
			System.out.println(i);
			
		}
		System.out.println(linked.get(0));
		System.out.println(linked.removeFirstOccurrence(0));
		*/
		
		LinkedList<Integer> l = new LinkedList<Integer>(); 
		l.add(5);
		l.add(545);
		l.add(3584);
		l.add(942);
		l.add(324);
		l.add(1466);
		l.add(9428);
		l.add(0);
		ReadOnlyContainer<Integer> c = new ReadOnlyContainer<Integer>(l);
		System.out.println(c.toString());
	}
}

class ReadOnlyContainer<T> {
	List<T> i;
	public ReadOnlyContainer(List<T> i) {
		this.i = i;
	}
	public T getI(int index) {
		return i.get(index);
	}
	
	@Override
	public String toString() {
		String str = "List of " + "[";
		for (T i : this.i) {
			str += i.toString() + ", ";
		}
		str = str.substring(0, str.length() - 2) + "]";
		return str;
	}
	
}
