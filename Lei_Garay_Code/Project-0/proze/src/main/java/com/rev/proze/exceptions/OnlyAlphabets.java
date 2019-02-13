package com.rev.proze.exceptions;

public class OnlyAlphabets extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public OnlyAlphabets()
	{
		super("\t--Only alphabets are allowed.");
	}

}
