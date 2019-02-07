package com.revature.oop;

public class UnderstandingInterfaces{
	
	public static void main(String[] args) {

		I i = new I();
		System.out.println(i.getClass());
		i.mustImplement("Hello World");
		i.doMore();
		i.doThings();
		
		Inter l = (a) ->{
			StringBuilder sb = new StringBuilder(a);
			System.out.println(sb.reverse());
		};
		
		l.mustImplement("Hello world");
		
		WithoutLambda w = new WithoutLambda();
		w.mustImplement("Hello World");
		
		//I anon = new SomeClassThatExtendsI();
		I anon = new I() {
			void notAnOverridenMethod() {
				System.out.println("using anonymous classes does not "
						+ "restrict us to only implementing overriden "
						+ "methods HOWEVER because we are creating an "
						+ "instance of a class that we have not named "
						+ "but that we know extends the reference type, "
						+ "we lose ACCESS TO all functionality not originally "
						+ "in the parent class. So basically we can see"
						+ "our overriden methods ");
			}
			
			@Override
			public void mustImplement(String a) {
				super.mustImplement(a);
				notAnOverridenMethod();
				System.out.println(this.getClass());
				System.out.println("this is an anonymous class");
			}
			
			public void mustImplement() {
				System.out.println("this is overloading");
			}
		};
		
	//	anon.notAnOverridenMethods();
		
		anon.mustImplement("testing with anon class");
		//anon.mustImplement();
		
	}
	
}

class WithoutLambda implements Inter{

	@Override
	public void mustImplement(String a) {
		StringBuilder sb = new StringBuilder(a);
		System.out.println(sb.reverse());		
	}
	
}

//interfaces with one and only one ABSTRACT method 
@FunctionalInterface 
interface Inter {
	//implicitly public and abstract
	void mustImplement(String a);
	
	default void doThings() {
		System.out.println("hello world");
	}
	
	default void doMore() {
		System.out.println("pretend this is meaningful method implementatino");
	}
}

class I implements Inter{

	@Override
	public void mustImplement(String a) {
		System.out.println(a.length());
	}
	
}
