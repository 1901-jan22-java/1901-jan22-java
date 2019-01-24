package com.revature.map;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
	List<Bucket> buckets;
	
	
	public MyHashMap() {
		this.buckets = new ArrayList<Bucket>(20);
		for(int i=0; i<20; i++) {
			buckets.add(null);
		}
	}
	
	public void add(int key, String val) {
		Bucket newData = new Bucket(val, key);
		int index = hash(key);
		
		//Checking to see if there is a collision. For now, we are overwriting every collision. Sorry Data-San. 
		if(buckets.get(index) != null) {
			buckets.add(index, newData);
		} else {
			buckets.remove(index);
			buckets.add(index, newData);
		}
		
	}
	
	public String remove(int key) {
		int index = hash(key);
		return buckets.remove(index).getData();
	}
	
	//Very simple hash to determine location of data in map
	private int hash(int key) {
		return (5-key)*12%20;
	}
	
	public String toString() {
		String result = "{";
		
		for(int i=0; i<buckets.size(); i++) {
			if(buckets.get(i) != null) {
				result = result + "  " + buckets.get(i).getKey() + ": " + buckets.get(i).toString();
			}
		}
		return result + "  }";
	}
	
}

class Bucket {
	private String data;
	private int key; 
	
	public Bucket(String data, int key) {
		this.data = data;
		this.key = key;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data;
	}

	public int getKey() {
		return key;
	}

	
}


