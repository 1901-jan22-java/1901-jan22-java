package com.revature.oop;

public class MyObject {
	static int count;
	private int id = 5;
	private String name;
	private String desc;
	
	{
		count++;
		id += count * 5;
	}
	public MyObject(){
		
	}
	
	public MyObject(String nm, String des)
	{
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getId() {
		return id;
	}
}
