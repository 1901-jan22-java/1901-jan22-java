package com.revature.oop;

public class MyObject {
	
	static int count = 0;
	private int id = 5;
	private String name;
	private String description;
	
	public MyObject(){
		count++;
		id+= count*5; //Auto-increment ID by 5 for each instance. 
	}
	
	public MyObject(String name, String des) {
		this();
		this.name = name;
		this.description = des;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
