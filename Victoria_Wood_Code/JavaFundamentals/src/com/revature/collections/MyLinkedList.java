package com.revature.collections;

public class MyLinkedList {
	
	/*
	 * A LinkedList is an ordered set of data elements
	 * When using an object of this type, we only have access to the first element
	 * and the last element (tail) points to null
	 */
	
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
		while (current != null) {
			str += current.toString() + ", ";
			current = current.getNextNode();
		}
		str += "}";
		return str;
	}
	
	

}
//Represents object data
class Node{
	private int data;
	private Node nextNode; //reference to next node
	
	public Node(int data) {
		this.data = data;
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

	@Override
	public String toString() {
		return ""+ data;
	}
	
}
