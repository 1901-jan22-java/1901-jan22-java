package com.revature.collections;

import java.util.LinkedList;
import java.util.List;

public class MyLikedList {
	private Node head;
	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}

	@Override
	public String toString() {
		String str = "{";
		Node current = this.head;
		while(current != null)
		{
			str += current.toString() + ", ";
			current = current.getNextNode();
		}
		str += "}";
		return "MyLinkedList [head=" + head + "]"; 
	}
}


class Node{
	private int data;
	private Node nextNode;
	
	public Node(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "" + data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
}