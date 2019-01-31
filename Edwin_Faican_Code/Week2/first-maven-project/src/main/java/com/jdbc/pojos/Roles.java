package com.jdbc.pojos;

public class Roles {
	private int id;
	private String title;
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Roles [id=" + id + ", title=" + title + "]";
	}

	public Roles() {
		
	}
	
	public Roles(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
