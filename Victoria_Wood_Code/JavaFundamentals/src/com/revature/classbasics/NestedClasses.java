package com.revature.classbasics;

public class NestedClasses {
	/*
	 * In Java, not only can we have more than one class inside of a
	 * .java file but we can also have a class within a class.
	 * 
	 * These are know as nested classes
	 * They enable you to logically group classes
	 * that are only used in one place, thus
	 * increasing the use of encapsulation, and creating more
	 * readable and maintainable code
	 */
	
	public class InstanceClass {
		public void message() {
			System.out.println("instance scoped nested class!");
		}
	}
	
	public static class StaticClass {
		public static void message() {
			System.out.println("static scoped nested class!");
		}
	}
	
	public static void main(String[] args) {
		
		StaticClass.message();
		
		class LocalClass{
			void message() {
				System.out.println("local scoped nested class!");
			}
		}
		
		LocalClass anon = new LocalClass() {
			void message() {
				System.out.println("in anonymous class! this is an"
						+ "extension of LocalClass!");
					super.message();
					System.out.println(super.getClass());
			}
		};
		
		anon.message();
		
	}

}
