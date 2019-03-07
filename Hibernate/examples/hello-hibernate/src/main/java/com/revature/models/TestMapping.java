package com.revature.models;

public class TestMapping {
	/*
	 * As we know, for most configuration details, we 
	 * can handle it in multiple ways. 
	 * We have seen configuring classes as entities with
	 * annotations, but we must also explore 
	 * configuring classes as entities with XML
	 * We do this via a hibernate mapping file 
	 * The mapping files must be named
	 * ClassName.hbm.xml
	 */
	
	private int id;
	private String data;
	
	public TestMapping() {	}

	public TestMapping(String data) {
		this.data = data;
	}
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
		return "TestMapping [id=" + id + ", data=" + data + "]";
	}
	
	

}
