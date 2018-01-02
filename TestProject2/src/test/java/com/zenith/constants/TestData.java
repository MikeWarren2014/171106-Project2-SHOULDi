package com.zenith.constants;

public class TestData {
	public static final String IP = "localhost";
			
	public static final String getBaseUrl()
	{
		return String.format("%s:4200", IP);
	}
	
	public static final String getLoginUrl()
	{
		return String.format("%s/login", getBaseUrl());
	}
	
	public static final String getRegisterUrl()
	{
		return String.format("%s/register", getBaseUrl());
	}
	
	// TODO: implement more methods here...
}
