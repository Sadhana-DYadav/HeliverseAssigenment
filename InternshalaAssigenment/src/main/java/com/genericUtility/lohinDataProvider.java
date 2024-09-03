package com.genericUtility;

import org.testng.annotations.DataProvider;

public class lohinDataProvider 
{
	@DataProvider
public Object[][] data1()
{
	Object[][] obj=new Object[2][2];
	obj[0][0]="unguardable";
	obj[0][1]="admin";
	
	
	obj[1][0]="unguardable";
	obj[1][1]="python";
	
	
	return obj;
	}

}
