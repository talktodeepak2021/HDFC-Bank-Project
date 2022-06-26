package com.inetBanking.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static FileInputStream inputstream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String  getcellvalue(String fileName,String sheetName,int rowno,int cellno) throws IOException
	{
		try {
			inputstream= new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputstream);
			excelsheet=  workbook.getSheet(sheetName);
			cell = workbook.getSheet(sheetName).getRow(rowno).getCell(cellno);
			workbook.close();
			return  cell.getStringCellValue();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
		
	}
	
	public static  int getrowCount(String fileName,String sheetName) throws IOException
	{
		inputstream= new FileInputStream(fileName);
		workbook = new XSSFWorkbook(inputstream);
		excelsheet=  workbook.getSheet(sheetName);
		
		int totalrow=excelsheet.getLastRowNum();
		workbook.close();
		return totalrow;
	}
	
	public static int getcolCOunt(String fileName,String sheetName, int i) throws IOException
	{
		inputstream= new FileInputStream(fileName);
		workbook = new XSSFWorkbook(inputstream);
		excelsheet=  workbook.getSheet(sheetName);
		
		int totalcol=excelsheet.getRow(0).getLastCellNum();
		workbook.close();
		return totalcol;
	}
	
	
	

}
