package com.revature.assignment1;

public class Lambda implements Functional<Lambda> {
	
	@Override
	public Lambda action() {
		return this;
	}
	
	public static void main(String...args) {
		Functional<String> f1 = () -> {
			return s1;
		};
		Functional<Integer> f2 = () -> {
			return 1000;
		};
		@SuppressWarnings("rawtypes")
		Functional f3 = () -> {
			return s3;
		};

		System.out.println(f1.action());
		System.out.println(f2.action());
		System.out.println(f3.action());
	}
}

@FunctionalInterface
interface Functional<T> {
	String s1 = "Action 1";
	String s2 = "Action 2";
	String s3 = "Action 3";
	
	T action();
}

abstract class FunctionalWrapper<T> implements Functional<T>{
	public T wrapperAction() {
		return action();
	}
}
