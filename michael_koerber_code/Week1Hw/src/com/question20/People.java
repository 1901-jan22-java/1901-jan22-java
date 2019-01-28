package com.question20;



public class People {

	private String fName;
	private String lName;
	private String age;
	private String state;
	
	public People(){
		
	}
	
	public People(String fName, String lName, String age, String state){
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.state = state;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (fName + ":" + lName + ":" + age + ":" + state); 
	}
	
	
	
}
