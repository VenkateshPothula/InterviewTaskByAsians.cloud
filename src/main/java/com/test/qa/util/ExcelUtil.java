package com.test.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Index;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtil {
	
	static String testingExcelValue;
	static String testingExcelValue2;
	
	static String SheetName;
	//static List<HashMap<String, String>> excelData = new ArrayList<HashMap<String, String>>();
	public static HashMap<String, String> excelData = new HashMap<String, String>();

	public static  void readWriteExcel(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	    File file = new File(sheetName);
	    FileInputStream inputStream = new FileInputStream( file );
	    Workbook workbook = WorkbookFactory.create( inputStream );

	    Sheet sheet = workbook.getSheet(SheetName);
	    Row row = sheet.getRow(0);
	    int rowCount = sheet.getLastRowNum(); 
	    
	    for(int i=0;i<=rowCount;i++){
	    	
	     //  Map<String,String> GetData = new HashMap<>();
	    	String CellHeader;
	    	 String Cellvalue;
	        for(int j=0;j<row.getLastCellNum();j++) {
	        	CellHeader=row.getCell(j).getStringCellValue();
	        	Cellvalue= sheet.getRow(i).getCell(j).getStringCellValue();
	            excelData.put(CellHeader, Cellvalue);
	           
	        	
	        }
	        
	    }	
		

	}
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		SheetName="CreateDomainData";
		
		ExcelUtil.readWriteExcel("D:\\Venkat\\New Framwork for Harish N\\PageObjectModel-master (2)\\PageObjectModel-master\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx");
		
	
		 testingExcelValue=	ExcelUtil.excelData.get("Domain_Name");
    	 testingExcelValue2=	ExcelUtil.excelData.get("Description");

	System.out.println("testingExcelValue::- "+testingExcelValue);
	
	System.out.println("testingExcelValue2::- "+testingExcelValue2);
	
	
		
		
	}
}

	


