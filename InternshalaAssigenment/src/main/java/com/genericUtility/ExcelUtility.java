
package com.genericUtility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{
	/**
	 * This method is used to Write data into the Excel file
	 * @param SheetName
	 * @param RowNo
	 * @param CellNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void writeDataIntoExcel(String SheetName,int RowNo,int CellNo, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(SheetName);
		sh.createRow(RowNo).createCell(CellNo).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IpathConstant.ExcelPath);
		wb.write(fos);
		wb.close();
		
		
	}
	
	/**
	 * This file will read data from the excel file
	 * @param SheetName
	 * @param RowNo
	 * @param CellNo
	 * @param data
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	

	public String readDataFromExcel(String SheetName, int RowNo,int CellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(SheetName);
		String value=sh.getRow(RowNo).getCell(CellNo).getStringCellValue();
		return value;
		
	}
	
	/**
	 * this method return the total no of rows
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getTotalRowCount(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(SheetName);
		int RowCount=sh.getLastRowNum();
		return RowCount;
	}
	
	/**
	 * This method return all values from excel file using map concept
	 * @param SheetName
	 * @param CellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public HashMap<String, String> readMultipleDataFromExcel(String SheetName, int CellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(SheetName);
		int RowCount=sh.getLastRowNum();
	
		HashMap<String, String>map=new HashMap<String, String>();
		for(int i=0; i<=RowCount;i++)
		{
			String Key=sh.getRow(i).getCell(CellNo).getStringCellValue();
			String value=sh.getRow(i).getCell(CellNo+1).getStringCellValue();
			map.put(Key, value);
		}
		return map;
	}
	
	
	public HashMap<String, String> readMultipleDatafromExcelFile(String sheetName, int rowCount, int firstCellNo, int firstRownum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		
				
		HashMap<String, String> map= new HashMap<String, String>();
		for(int i=0;i<=rowCount;i++)
		{
			String key =sh.getRow(firstRownum+i).getCell(firstCellNo).getStringCellValue();
			String value =sh.getRow(firstRownum+i).getCell(firstCellNo+1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
}
