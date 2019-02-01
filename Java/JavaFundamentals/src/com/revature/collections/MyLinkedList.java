package com.revature.collections;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
	
	private MyLinkedListNode<E> head;
	
	public void insertAtHead(E data) {
		MyLinkedListNode<E> n = new MyLinkedListNode<>(data, head);
		head = n;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		
		MyLinkedListNode<E> current = this.head;
		
		while(current != null) {
			sb.append(current.toString() + ", ");
			current = current.getNext();
		}
		
		sb.append(" ]");
		
		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class MyLinkedListNode<E> extends Node<E> {
	
	private MyLinkedListNode<E> next;
	
	public MyLinkedListNode(E data) {
		super(data);
	}
	
	public MyLinkedListNode(E data, MyLinkedListNode<E> next) {
		this.data = data;
		this.next = next;
	}
	
	public MyLinkedListNode<E> getNext(){
		return next;
	}
	
	
}
