package com.revature.map;

import java.util.HashMap;
import java.util.Map;

public class FunWithMaps {
	public static void main(String[] args) {
		HashMap<Integer, String> mapsAreFum = new HashMap<Integer, String>();
		
		
		mapsAreFum.put(new Integer(4), "I like 4 donuts");
		mapsAreFum.put(new Integer(10), "Ten is a cool number with a one and a zero.");
		mapsAreFum.put(new Integer(4), "4 is now different");
		mapsAreFum.put(null, "This somehow works!");
		mapsAreFum.put(null, "The null key has been replaced!");
		
		mapsAreFum.replace(new Integer(4), "Wow, 4 is changing a bunch!");
		
		mapsAreFum.remove(new Integer(4));
		
		System.out.println(mapsAreFum);
		
		System.out.println(mapsAreFum.containsValue("Ten is a cool number with a one and a zero."));
		
		
		
		//My Sorry Attempt at a HashMap
		MyHashMap woop = new MyHashMap();
		
		woop.add(1, "Hello!");
		woop.add(2, "Is this the Krusty Krab?");
		woop.add(3,  "No, this is Patrick!");
		
		System.out.println(woop.toString());
		
		woop.remove(1);
		
		System.out.println(woop.toString());
	}
}
