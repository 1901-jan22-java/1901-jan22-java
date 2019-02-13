package com.revature.classbasics;

public class NestedClasses {
	/*
	 * In Java, not only can we have more than one
	 * class inside of a .java file, but we can 
	 * also have a class within a class. These are
	 * known as nested classes 
	 * They enable you to logically group classes 
	 * that are only used in one place, thus increasing
	 * the use of encapsulation, and creating more
	 * readable and maintainable code
	 */
	
	public class InstanceClass{
		public void message() {
			System.out.println("instance scoped nested class!");
		}
	}
	
	public static class StaticClass{
		public static void message() {
			System.out.println("static scoped nested class!");
		}
	}
	
	public static void main(String[] args) {
		
		StaticClass.message();
		
		class LocalClass{
			void message(){
				System.out.println("in local scoped nested class!");
			}
		}
		
		LocalClass instanceOfLocal = new LocalClass();
		
		LocalClass anon = new LocalClass() {
			String name = "anon";
			void message() {
				System.out.println("in " + name + " class! this is"
						+ " an extension of LocalClass!");
				super.message();
				System.out.println(super.getClass());
			}
		};
		/* what the anonymous class is basically doing: 
		 * 
		 * class RandomName extends LocalClass{
		 * 	String name = "anon";
			void message() {
				System.out.println("in " + name + " class! this is"
						+ " an extension of LocalClass!");
				super.message();
				System.out.println(super.getClass());
			}
		 * }
		 */
		
		anon.message();
		
		
	}

}
