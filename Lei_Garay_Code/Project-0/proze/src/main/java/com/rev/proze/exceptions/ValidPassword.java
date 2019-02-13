package com.rev.proze.exceptions;

public class ValidPassword extends Exception
{
	private static final long serialVersionUID = 1L;

	public ValidPassword()
	{
		System.out.println("\t--Not a valid password.");
	}
}
