package com.newtours.demoaut.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.newtours.demoaut.base.TestBase;

public class Utility extends TestBase {
	
	public Utility() {
		super();
	}
	
	static  String TestDataExcelFileName="C:\\Users\\basavaraju.s\\Desktop\\New SauceDemo\\newtours.demoaut_automation\\resource\\Data.xlsx";
	static Workbook book;
	static Sheet sheet;
	public static String getDataFromXL(String sheet,int row,int col)
	{
	String value="";
	try
	{
	Workbook w = WorkbookFactory.create(new FileInputStream(TestDataExcelFileName));
	value = w.getSheet(sheet).getRow(row).getCell(col).toString();
	} catch (Exception e)
	{
	e.printStackTrace();
	}
	return value ;
	}
	
	
	public static Object[][] getTestData(String SheetName){
		
		FileInputStream file=null;
		try {
			file=new FileInputStream(TestDataExcelFileName);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		sheet=(Sheet) book.getSheet(SheetName);
		Object[][] data= new Object[((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum()][((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum()];
		for(int i=0;i<((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum();i++)
			for(int k=0;k<((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum();k++) {
				data[i][k]=((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i+1).getCell(k).toString();
			}
		return data;
		
	}
	
	
	
	public static String ReadCellData(int vRow, int vColumn)  
	{  
	String value=null;          //variable for storing the cell value  
	Workbook wb=null;           //initialize Workbook null  
	try  
	{  
	//reading data from a file in the form of bytes  
	FileInputStream fis=new FileInputStream("C:\\Users\\basavaraju.s\\Desktop\\New SauceDemo\\newtours.demoaut_automation\\resource\\Data.xlsx");  
	//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
	wb=new XSSFWorkbook(fis);  
	}  
	catch(FileNotFoundException e)  
	{  
	e.printStackTrace();  
	}  
	catch(IOException e1)  
	{  
	e1.printStackTrace();  
	}  
	org.apache.poi.ss.usermodel.Sheet sheet=wb.getSheetAt(0);   //getting the XSSFSheet object at given index  
	Row row=sheet.getRow(vRow); //returns the logical row  
	Cell cell=row.getCell(vColumn); //getting the cell representing the given column  
	value=cell.getStringCellValue();    //getting cell value  
	return value;               //returns the cell value  
	}  
 
	
	
	
	
	
	
	
	
	public static void main(String args[]) {
		System.out.println(getDataFromXL("Registration", 1, 2));
//		System.out.println(ReadCellData(0,1));
//		System.out.println(getTestData("TestData"));
//		String vOutput=ReadCellData(0,1);   
//		System.out.println(vOutput); 
	
	}

}
