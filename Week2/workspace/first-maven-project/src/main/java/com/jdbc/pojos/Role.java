package com.jdbc.pojos;

public class Role 
{
	private int id;
	private String title;
	
	public Role(){}
	public Role(int id, String title)
	{
		super();
		this.id = id;
		this.title = title;
	}
	
	public int getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setTitle(String title){
		this.title=title;
	}

	@Override
	public String toString()
	{
		return "Role [id= " + id + ", title= " + title + "]";
	}

}
