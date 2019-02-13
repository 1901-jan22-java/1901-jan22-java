package com.revature.collections;

public class MyLinkedList {
	
	/*
	 * A LinkedList is an orderedset of 
	 * data elements 
	 * When using an object of this type, we only 
	 * have access to the first element, and 
	 * the last element (tail) points to null
	 */
	
	private Node head;
	
	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}

	@Override
	public String toString() {
		String str = "{ ";
		Node current = this.head;
		while(current!=null) {
			str += current.toString()+ ", ";
			current = current.getNextNode();
		}
		str += "}";
		
		return "MyLinkedList [head=" + head + "]";
	}
	public Node deleteNode(Node head, int d) {
		Node prev = head;
		Node next = head.getNextNode();
		while(next!=null) {
			if(next.getData()==d) {
				prev.setNextNode(next.getNextNode());
				return next;
			}
			else {
				prev = next;
				next = next.getNextNode();
			}
		}
		return null;
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
		return  "" + data ;
	}
}
