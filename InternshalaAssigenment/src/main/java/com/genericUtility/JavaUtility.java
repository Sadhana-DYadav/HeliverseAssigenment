package com.genericUtility;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	/**
	 * This method return Random number
	 * @return
	 */
	public int getRandomNo()
	{
		Random ran=new Random();
		int random=ran.nextInt(500);
		return random;
		
	}
	
	/**
	 * This method return System date 
	 * @return
	 */
	public String getSystemDate()
	{
		Date dt=new Date();
		String date=dt.toString();
		return date;
	}
	
	/**
	 * This method return System Date and time in the format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date dt=new Date();
		String sysDateInFormat=dateformat.format(dt);
		return sysDateInFormat;
	}
	
	/**
	 * This method return system date and time
	 * @return
	 */
	public String getSystemDateAndTime()
	{
		String timeStamp=LocalDateTime.now().toString().replace(':', '-');
		return timeStamp;
	}
	
	
	
	
}
