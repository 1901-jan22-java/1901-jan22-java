package com.revature.oop;

public class Polymorphism {
	
	public static void main(String[] args) {
		
		A c = new B();
		
		System.out.println( c.name + " " + c.test() );
		
		B cc = (B)c;
		
		System.out.println( cc.name + " " + cc.test() );
		
		cc.doThings("x");
	}
	
}

class A {
	
	String name;
	
	public A() {
		this.name = "A";
		System.out.println("Constructing A");
	}
	
	String test() {
		System.out.println("In Class A: " + name);
		return "In Class A: " + name;
	}
	
//	void doThings(String args) {
//		System.out.println("single");
//	}
}

class B extends A {
	
	String name;
	
	public B() {
		this.name = "B";
		System.out.println("Constructing B");
	}
	
	String test() {
		System.out.println("In Class B: " + name);
		return "In Class B: " + name;
	}
	
	void doThings(String... x) {
		System.out.println("varargs");
	}
}

class C extends B {
	
	String name;
	
	public C() {
		this.name = "C";
		System.out.println("Constructing C");
	}
	
//	@Override 
	String test() {
		System.out.println("In Class C: " + name);
		return "In Class C: " + name;
	}
	
}

