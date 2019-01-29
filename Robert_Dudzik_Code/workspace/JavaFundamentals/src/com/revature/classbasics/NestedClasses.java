package com.revature.classbasics;

public class NestedClasses 
{
	/*
	 * IN Java, not only can we have more than one class inside
	 * a .java file, but we can also have a class within a class.
	 * These are known as nested classes. They enable you to logically
	 * group classes that are only used in one place, thus increasing the use of encapsulation,
	 * and creating more readable and maintainable code.
	 */

	class Instance
	{
		void message()
		{
			System.out.println("Instance scoped nested class");
		}
	}
	
	static class StaticClass
	{
		void message()
		{
			System.out.println("Static scoped nested class");
		}
	}
	
	public static void main(String[] args) 
	{
		class LocalClass
		{
			void message()
			{
				System.out.println("In local scoped nested class");
			}
		}
		
		LocalClass anon = new LocalClass()
		{
			void message()
			{
				System.out.println("In anon class, this is an extension of local class");
				super.message();
				System.out.println(super.getClass());
			}
		};
		anon.message();
	}
}
