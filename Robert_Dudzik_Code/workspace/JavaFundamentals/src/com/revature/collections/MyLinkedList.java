package com.revature.collections;

public class MyLinkedList 
{
	/*
	 * A linkedlist is an orderedset of data elements
	 * When using an object of this type, we only have
	 * access to the first element, and the last element
	 * (tail) points to null
	 */
	private Node head;
	
	public void insertAtHead(int data)
	{
		Node temp = new Node(data);
		temp.setNext(this.head);
		this.head = temp;
	}

	@Override
	public String toString() 
	{
		String str = "{ ";
		Node current = this.head;
		while (current != null)
		{
			str += current.toString();
			current = current.getNext();
		}
		str += " }";
		return str;
	}
	
	
}

//Representation of object data
class Node
{
	private int data;
	private Node next;//References next node
	
	public Node(int data)
	{
		this.data = data;
	}

	public int getData() 
	{
		return data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	public Node getNext() 
	{
		return next;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	@Override
	public String toString() 
	{
		return "" + data;
	}
	
}
