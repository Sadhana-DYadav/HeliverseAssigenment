package com.genericUtility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;
public class DatabaseUtility 
{
	Connection conn=null;
	public void connectDB() throws SQLException 
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection(IpathConstant.DBUrl, IpathConstant.DBUsername, IpathConstant.DBPassword );
	}
	public void executeAndgetData( String query, int colIndex, String expdata) throws SQLException
	{
		Statement state = conn.createStatement();
		ResultSet res = state.executeQuery(query);
		boolean flag=false;
		while(res.next())
		{
			String actual=res.getString(colIndex);
			if(actual.contains(expdata))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("---Data ia Valid---");
		}
		else
		{
			System.out.println("---Data ia InValid---");
		}
	}
	public void closeDB() throws SQLException
	{
		conn.close();
	}
}

