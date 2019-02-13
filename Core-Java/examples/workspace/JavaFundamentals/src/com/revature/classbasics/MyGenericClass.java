package com.revature.classbasics;

public class MyGenericClass<T>{
	
	//MyGenericClass<Person> obj = new MyGenericClass<Person>();
	
	
	/*
	 * Generic types allow us to manipulate objects 
	 * in other objects without knowing what kind 
	 * of object will be used at runtime 
	 * 
	 */
	
	public void getClassInfo(T obj) {
		System.out.println(obj.getClass());
	}
	

}
