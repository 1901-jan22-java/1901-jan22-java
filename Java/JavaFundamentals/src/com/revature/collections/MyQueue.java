package com.revature.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * MyQueue is a simple generic FIFO queue which is a data structure that follows
 * the first come first serve philosophy.
 * 
 * @author Sanford
 *
 * @param <E>
 */
@SuppressWarnings("rawtypes")
public class MyQueue<E> implements Queue<E> {

	/**
	 * head is the front of the queue and the end is where
	 */
	private QueueNode<E> head;
	private QueueNode<E> end;

	@Override
	public boolean add(E e) {
		QueueNode<E> node = new QueueNode<E>(e);
		if (head == null) {
			head = node;
			end = node;
		} else {
			end.setNext(node);
			end = node;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection c) {
		return false;
	}

	@Override
	public void clear() {
		head = null;
		end = null;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(Object[] a) {
		
		return null;
	}

	@Override
	public E element() {
		return head.getData();
	}

	@Override
	public boolean offer(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E peek() {
		if (isEmpty())
			return null;
		return head.getData();
	}

	@Override
	public E poll() {
		if (isEmpty())
			return null;
		E data = peek();
		head = head.getNext();
		return data;
	}

	@Override
	public E remove() {
		E data = poll();
		if (data == null)
			throw new NoSuchElementException();
		return data;
	}

	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<>();

		q.add(1);
		q.add(2);
		q.add(3);

		System.out.println(q.element());
		System.out.println(q.element());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}
}

class QueueNode<E> extends Node<E> {

	private QueueNode<E> next;

	public QueueNode(E data) {
		super(data);
	}

	public void setNext(QueueNode<E> next) {
		this.next = next;
	}

	public QueueNode<E> getNext() {
		return next;
	}
}
