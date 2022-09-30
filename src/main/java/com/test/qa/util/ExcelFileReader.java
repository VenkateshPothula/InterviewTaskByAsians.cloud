package com.test.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	
	public static String GetTestData(String SheetName,int RowNum,int CellNum) throws IOException {

		//Path of the excel file
		FileInputStream fs = new FileInputStream("D:\\Venkat\\New Framwork for Harish N\\PageObjectModel-master (2)\\PageObjectModel-master\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx");
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(RowNum);
		Cell cell = row.getCell(CellNum);
		String ExcelData=cell.getStringCellValue();
		//String =cell.getStringCellValue().getRow(0).getCell(0);
	//	System.out.println("ExcelData ::- "+ExcelData);
		return ExcelData;
		
	}
	/*
	 * public static void main(String[] args) throws IOException { String Values=
	 * GetTestData("CreateDomainData", 1, 0);
	 * System.out.println("Values::- "+Values);
	 * 
	 * }
	 */
}