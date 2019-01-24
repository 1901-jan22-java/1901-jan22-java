package com.revature.classBasics;

public class constructors {

	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.test());
	}
}

class A{
	String name;
	public A() {
		this.name = "A";
		System.out.println(this.name);
	}
	
	String test() {
		return "in class A " + this.name;
	}
}

class B extends A {
	String name;
	public B() {
		this.name = "B";
		System.out.println(this.name);
	}	
	
	String test() {
		return "in class B " + this.name;
	}
}

class C extends B {
	String name;
	public C() {
		this.name = "C";
		System.out.println(this.name);
	}
	
	String test() {
		return "in class C " + this.name;
	}
}
