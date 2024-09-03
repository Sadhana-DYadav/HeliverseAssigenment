package com.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


import com.genericUtility.IpathConstant;



public class genericDataProvider
{
	@DataProvider(name = "Data")
	public Object[][] orgdata() throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fs=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fs);
		Sheet sh=wb.getSheet("Generate_invoice05");
		int rowCount=sh.getLastRowNum()+1;
		int cellcount=sh.getRow(0).getLastCellNum();
		
		
		Object[][] obj=new Object[rowCount][cellcount];
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
}
