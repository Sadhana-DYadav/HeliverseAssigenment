package com.genericUtility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class RetryImpClass implements IRetryAnalyzer
{
	int lowerCount=0;
	int upperCount=3;
	public boolean retry(ITestResult result)
	{
		if(lowerCount<upperCount)
		{
			lowerCount++;
			return true;
		}
		return false;
	}
}
