package com.revature.models;

public class TestMapping {
	private int id;
	private String data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "testMapping [id=" + id + ", data=" + data + "]";
	}
	public TestMapping(String data) {
		super();
		this.id = id;
		this.data = data;
	}
	public TestMapping() { }
	
	
}
