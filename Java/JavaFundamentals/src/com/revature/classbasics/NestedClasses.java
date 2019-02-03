package com.revature.classbasics;

/*
 * In java, not only can we have more than one class inside of a .java file, but we can also have a class 
 * within a class. These are known as nested classes
 * 
 * They enable you to logically group classes that are only used in one place, thus increasing the use of
 * encapsulation, and creating more readable and maintainable code.
 * 
 */

public class NestedClasses {
	
	public class InstanceClass{
		public InstanceClass() {
			
		}
		
		public void message() {
			System.out.println("Instance scoped nested class!");
		}
	}
	
	public static class StaticClass{
		public void message() {
			System.out.println("Static scoped nested class!");
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		class LocalClass {
			public void message() {
				System.out.println("Local scoped nested class!");
			}
		}
		
		LocalClass lc = new LocalClass() {
			String name = "anon";
			public void message() {
				System.out.println("Name: " + name);
				super.message();
			}
		};
	}
	
}
