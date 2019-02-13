package com.rev.proze.exceptions;

public class OnlyYesNo extends Exception
{
	private static final long serialVersionUID = 1L;

	public OnlyYesNo()
	{
		super("Only \'Y\' or \'N\' will do. Please try again.");
	}
	
}