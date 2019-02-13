package com.rev.proze.exceptions;

public class ValidUsername extends Exception
{
	private static final long serialVersionUID = 1L;

	public ValidUsername()
	{
		System.out.println("\t--Not a valid username.");
	}
}

