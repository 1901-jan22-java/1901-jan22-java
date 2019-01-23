package com.revature.classbasics;

public class Constructors {
	public static void main(String[] args) {
		A c = new C();
		System.out.println(c.name);
		System.out.println(c.test());
	}
}

class A {
	String name; 
	
	public A() {
		this.name = "A";
		System.out.println("CONTRUCTING A");
	}
	
	String test() {
		return "IN CLASS A. VALUE: " + name;
	}
}

class B extends A {
	String name; 
	
	public B() {
		this.name = "B";
		System.out.println("CONTRUCTING B");
	}
	
	String test() {
		return "IN CLASS B. VALUE: " + name;
	}
}

class C extends B {
	String name; 
	
	public C() {
		this.name = "C";
		System.out.println("CONTRUCTING C");
	}
	
	String test() {
		return "IN CLASS C. VALUE: " + name;
	}
}