package com.revature.collections;

public class Node<E> {
	
	protected E data;
	
	public Node() {
		data = null;
	}
	
	public Node(E data){
		this.data = data;
	}
	
	public E getData() {
		return data;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
}
