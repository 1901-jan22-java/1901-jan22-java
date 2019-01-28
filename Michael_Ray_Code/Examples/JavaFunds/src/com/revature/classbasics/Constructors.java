package com.revature.classbasics;

public class Constructors {
public static void main(String[] args) {
	
	 A c = new C();
}
}
class A{
	String name;
	public A(){
		this.name = "A";
		System.out.println("CONSTRUCING A");
	}
	String Test(){
		return "IN CLASS A. VAULE: " + name;
	}
}
class B extends A{
	public B(){
		this.name = "B";
		System.out.println("CONSTRUCING B");
	}
	String Test(){
		return "IN CLASS B. VAULE: " + name;
	}
}
class C extends B{
	String name;
	public C(){
		this.name = "C";
		System.out.println("CONSTRUCING C");
	}
	String Test(){
		return "IN CLASS C. VAULE: " + name;
	}
}
