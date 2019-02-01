package com.revature.jdbc.pojos;

public class Roles {
	private int id;
	private String title;
	
	public Roles() {
		
	}
	


	public Roles(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	public int getId() {
		return id;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
