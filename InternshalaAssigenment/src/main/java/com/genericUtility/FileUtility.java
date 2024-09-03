package com.genericUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class FileUtility
{
	/**
	 * This method is used to read data from the property file
	  * @param Key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String Key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstant.FilePath);
		Properties prob=new Properties();
		prob.load(fis);
		String value=prob.getProperty(Key);
		return value;
	}
	
}
