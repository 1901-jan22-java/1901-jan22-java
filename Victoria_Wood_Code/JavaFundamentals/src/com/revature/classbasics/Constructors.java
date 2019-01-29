package com.revature.classbasics;

public class Constructors {
	
	public static void main(String[] args) {
		A c = new C();
		System.out.println(c.name); //references name from Class A
		System.out.println(c.test()); // still uses Class C's overridden method
		
	}

}
class A {
	String name;
	public A() {
		this.name = "A";
		System.out.println("CONSTRUCTING A");
	}
	String test () {
		return ("IN CLASS A. VALUE:" + name);
	}
}

class B extends A {
	String name;
	
	public B() {
		this.name = "B";
		System.out.println("CONSTRUCTING B");
	}
	String test () {
		return ("IN CLASS B. VALUE:" + name);
	}
}

class C extends B {
	String name;
	public C() {
		this.name = "C";
		System.out.println("CONSTRUCTING C");
	}
	String test () {
		return ("IN CLASS C. VALUE:" + name);
	}
}