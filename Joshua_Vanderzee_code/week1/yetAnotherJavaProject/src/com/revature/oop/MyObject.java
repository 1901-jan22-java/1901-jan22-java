package com.revature.oop;

public class MyObject {
	private int id;
	private String name;
	private String dest;
	
	
	{
		id += 5;
	}

	public MyObject() {
		
	}
	
	public MyObject (String name, String dest) {
		this();
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}
}
