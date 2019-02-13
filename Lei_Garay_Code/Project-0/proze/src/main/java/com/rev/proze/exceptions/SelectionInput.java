package com.rev.proze.exceptions;

public class SelectionInput extends Exception
{
	private static final long serialVersionUID = 1L;

	public SelectionInput()
	{
		System.out.println("\t--Not a valid selection.");
	}
}
