package com.cagen.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 10;
	
	static String currentDirectory = System.getProperty("user.dir");
	public static String EXCEL_SHEET_PATH = currentDirectory + "\\src\\main\\java\\com\\cagen\\qa\\testdata\\SampleModel_TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
// Static Wait Time for some Objects	
	public static void  waitForPageToLoad(long milliSec) {
		   try {
				Thread.sleep(milliSec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
// Utility for Data Provider	
	public static Object[][] getTestData(String sheetName){
		FileInputStream excelFile = null;
		
		try {
			excelFile = new FileInputStream(EXCEL_SHEET_PATH);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(excelFile);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i=1; i < sheet.getLastRowNum(); i++) {
			for (int j=0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}

}
