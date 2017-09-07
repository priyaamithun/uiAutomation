package com.test.automation.uiautomation.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_reader {

	public FileOutputStream fos = null;
	public FileInputStream fis ;
	public String path;
	 public XSSFWorkbook wb;
	 public XSSFSheet  sheet;
	 public XSSFRow row;
	 public XSSFCell cell;
	
	 public Excel_reader(String path){
		 this.path=path;
		 try{
			 fis =  new FileInputStream(path);
		     wb = new XSSFWorkbook(fis);
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	 }
		 
		 public String[][] getDataFromSheet (String sheetName, String excelName){
			String dataSets [][] = null;
			try{
				sheet = wb.getSheet(sheetName);
			//count number of active rows
				int totalRow = sheet.getLastRowNum()+1;
				//count number of active columns
				int totalColumn = sheet.getRow(0).getLastCellNum();
				
		
	//create an array of rows and columns
				dataSets = new String[totalRow-1][totalColumn];
				//run loop and store data in 2D array
				//this loop will run on rows
				
				for(int i=1;i<totalRow;i++){
					XSSFRow rows = sheet.getRow(i);
				
				for(int j =0;j<totalColumn;j++){
					//get cell method will get cell
				XSSFCell cell = rows.getCell(j);
				
				if(cell.getCellType()== Cell.CELL_TYPE_STRING){
					dataSets[i-1][j] = cell.getStringCellValue();
				}
				else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					String celltext= String.valueOf( cell.getNumericCellValue());
					dataSets [i-1][j]= celltext; 
				}
				else{
					dataSets[i-1][j] = String.valueOf(cell.getBooleanCellValue());
				}
				
				
				}
				
				
				}
				
				return dataSets;
			}
				catch(Exception e){
			System.out.println(e.getMessage());		
				e.printStackTrace();
				}
			
			return dataSets;
				 }
		 
		 
		 public String getCellData(String sheetname, String colName,int rowNum){
			 try{
				 int col_numbers = 0;
				 int index = wb.getSheetIndex(sheetname);
				 sheet = wb.getSheetAt(index);
				 XSSFRow row = sheet.getRow(0);
			 for(int i=0; i<row.getLastCellNum(); i++){
				 if(row.getCell(i).getStringCellValue().equals(colName))
			 col_numbers= i;
				 break;
			 
			 }
			 
			 row = sheet.getRow(rowNum-1);
		 XSSFCell cell = row.getCell(col_numbers);
		 if(cell.getCellType()==Cell.CELL_TYPE_STRING){
			 return cell.getStringCellValue();
		 }
		 else if(cell.getCellType()== Cell.CELL_TYPE_BLANK){
			 return " ";
		 }
		 
			 }catch(Exception e){
				 e.printStackTrace();
			 }
return null;
		 
		 
		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
}
