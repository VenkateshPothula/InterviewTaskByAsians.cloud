package com.test.qa.util;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtil_old {

    private FileInputStream fis;
    private FileOutputStream fileOut;
    private Workbook wb;
    private Sheet sh;
    private Cell cell;
    private Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
    private Map<String, Integer> columns = new HashMap<String, Integer>();

    public void setExcelFile(String ExcelPath, String SheetName) throws Exception {
        try {
            File f = new File(ExcelPath);

            if (!f.exists()) {
                f.createNewFile();
                System.out.println("File doesn't exist, so created!");
            }

            fis = new FileInputStream(ExcelPath);
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet(SheetName);
            //sh = wb.getSheetAt(0); //0 - index of 1st sheet
            if (sh == null) {
                sh = wb.createSheet(SheetName);
            }

            this.excelFilePath = ExcelPath;

            //adding all the column header names to the map 'columns'
            sh.getRow(0).forEach(new Consumer<Cell>() {
				@Override
				public void accept(Cell cell) {
				    columns.put(cell.getStringCellValue(), cell.getColumnIndex());
				}
			});

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String getCellData(int rownum, int colnum) throws Exception{
        try{
            cell = sh.getRow(rownum).getCell(colnum);
            String CellData = null;
           
                    CellData = cell.getStringCellValue();
                   
            return CellData;
        }catch (Exception e){
            return"";
        }
    }

    public String getCellData(String columnName, int rownum) throws Exception {
        return getCellData(rownum, columns.get(columnName));
    }

    public static void main(String []args) throws Exception {
        ExcelUtil_old excel = new ExcelUtil_old();
        
        String path="D:\\Venkat\\New Framwork for Harish N\\PageObjectModel-master (2)\\PageObjectModel-master\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";
        excel.setExcelFile(path, "CreateDomainData");
        
        System.out.println(excel.getCellData("Domain_Name", 2));
		/*
		 * System.out.println(excel.getCellData("DOB", 1));
		 * System.out.println(excel.getCellData("Address", 1));
		 */
    }

}