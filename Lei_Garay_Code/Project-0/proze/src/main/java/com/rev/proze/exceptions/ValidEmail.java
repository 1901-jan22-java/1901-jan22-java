package com.rev.proze.exceptions;

public class ValidEmail extends Exception
{
	private static final long serialVersionUID = 1L;

	public ValidEmail()
	{
		System.out.println("\t--Not a valid e-mail.");
	}
}
