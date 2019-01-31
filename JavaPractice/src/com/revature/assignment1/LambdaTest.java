package com.revature.assignment1;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Question
 * 
 * @author Sanford
 *
 */

public class LambdaTest {
	Functional<?> f;
	FunFunctional<?> ff;
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
		f = null;
	}
	
	@Test
	public void test1() {
		f = () -> Functional.s1 + " " + Functional.s2 + " " + Functional.s3;
	}
	
	@Test
	public void test2() {
		f = () -> 1000;
	}
	@Test
	public void test3() {
		f = () -> {
			tearDown();
			return getClass().getName();
		};
		Runnable r = () -> {
			System.out.println("This anon class tears itself down " + f.action() );
		};
		Thread t = new Thread(r);
		t.start();
	}
	
	@Test
	public void test4() {
		ff = (i) -> {
			if(i <= 0) return i;
			return ff.crazy(--i);
		};
		
		System.out.println( ff.crazy(10) );
	}

	public static void main(String[] args) {
		(new LambdaTest()).test4();
	}
}

@FunctionalInterface
interface Functional<T> {
	String s1 = "Action 1";
	String s2 = "Action 2";
	String s3 = "Action 3";
	
	T action();
}

@FunctionalInterface
interface FunFunctional<T> {
	T crazy(int i);
}

@FunctionalInterface
interface Reflectable<T> {
	T add(T t2);
	public default void addField() {
		@SuppressWarnings("rawtypes")
		Class<? extends Reflectable> c = getClass();
		Field[] fs = c.getDeclaredFields();
		Field.setAccessible(fs, true);;
		for(Field f: fs)
			System.out.println(f.toGenericString());
	}
}

abstract class FunctionalWrapper<T> implements Functional<T>{
	public T wrapperAction() {
		return action();
	}
}
