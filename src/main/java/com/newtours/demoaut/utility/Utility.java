package com.newtours.demoaut.utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TakesScreenshot;
import com.newtours.demoaut.base.TestBase;

public class Utility extends TestBase {
	
	public Utility() {
		super();
	}
	
	static  String TestDataExcelFileName=System.getProperty("user.dir")+"\\resource\\Data.xlsx";
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
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public static void main(String args[]) {
		System.out.println(TestDataExcelFileName);
	}

}
