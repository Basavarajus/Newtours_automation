package com.newtours.demoaut.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.newtours.demoaut.base.TestBase;

public class Utility extends TestBase {
	
	
	
	public static String getDataFromXL(String path,String sheet,int row,int col)
	{
	String value="";
	try
	{
	Workbook w = WorkbookFactory.create(new FileInputStream(path));
	value = w.getSheet(sheet).getRow(row).getCell(col).toString();
	} catch (Exception e)
	{
	e.printStackTrace();
	}
	return value ;
	}
	
	public static void main(String args[]) {
		getDataFromXL(TestDataExcelFileName, "TestData", 1, 1);
	}

}
