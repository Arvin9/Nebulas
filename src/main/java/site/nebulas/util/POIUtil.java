package site.nebulas.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POIUtil {
	
	public static void main(String[] args) {
		readExcel();
	}
	
	public static void readExcel(){
		InputStream inp;
		HSSFWorkbook wb = null;
		try {
			inp = new FileInputStream("E://workbook.xls");
			//inp = new FileInputStream("workbook.xlsx");
			wb = new HSSFWorkbook(inp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    //获取第一张表
		HSSFSheet sheet =  wb.getSheetAt(0);
		//获取表的总行数
		int rowNum = sheet.getLastRowNum();
		System.out.println(rowNum);
		//获取表的第一行
		HSSFRow row = sheet.getRow(0);
		//获取表第一行的
	    HSSFCell cell = row.getCell(0);
	    getCellValue(cell);
	    
	}
	
	public static String getCellValue(HSSFCell cell){
		switch(cell.getCellType()){
			case HSSFCell.CELL_TYPE_BLANK: 
				System.out.println("HSSFCell.CELL_TYPE_BLANK" + HSSFCell.CELL_TYPE_BLANK);
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN: 
				System.out.println("HSSFCell.CELL_TYPE_BOOLEAN" + HSSFCell.CELL_TYPE_BOOLEAN);
				break;
			case HSSFCell.CELL_TYPE_ERROR: 
				System.out.println("HSSFCell.CELL_TYPE_ERROR" + HSSFCell.CELL_TYPE_ERROR);
				break;
			case HSSFCell.CELL_TYPE_FORMULA: 
				System.out.println("HSSFCell.CELL_TYPE_FORMULA" + HSSFCell.CELL_TYPE_FORMULA);
				break;
			case HSSFCell.CELL_TYPE_NUMERIC: 
				System.out.println("HSSFCell.CELL_TYPE_NUMERIC" + HSSFCell.CELL_TYPE_NUMERIC);
				break;
			case HSSFCell.CELL_TYPE_STRING: 
				System.out.println("HSSFCell.CELL_TYPE_STRING" + HSSFCell.CELL_TYPE_STRING);
				break;
			default: 
				System.out.println("");
		}
		return "";
	}
	
	public static void createExcel(){
		HSSFWorkbook wb = new HSSFWorkbook();
		//Workbook wb = new XSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("Sheet1");
	    FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("E://workbook.xls");
			//fileOut = new FileOutputStream("E://workbook.xlsx");
			wb.write(fileOut);
		    fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeExcel(){
		InputStream inp;
		HSSFWorkbook wb = null;
		try {
			inp = new FileInputStream("E://workbook.xls");
			//inp = new FileInputStream("workbook.xlsx");
			wb = new HSSFWorkbook(inp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    //获取第一张表
		HSSFSheet sheet =  wb.getSheetAt(0);
		//获取表的总行数
		int rowNum = sheet.getLastRowNum();
		System.out.println(rowNum);
		//获取表的第一行
		HSSFRow row = sheet.getRow(0);
		//获取表第一行的
	    HSSFCell cell = row.getCell(0);
	    //if (cell == null)
	    //    cell = row.createCell(0);
	    //cell.setCellValue("a test");
	    FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("E://workbook.xls");
			wb.write(fileOut);
		    fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
