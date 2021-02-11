package com.orangehrm.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This is the generic class for data driven testing 
 * @author jinat
 *
 */

public class FileLib {
	/**
	 * Reading the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getpropertyvalue(String key) throws IOException{
		
		
		FileInputStream fisFileInputStream =new FileInputStream("./data/commondata.property");
		Properties p= new Properties();
		p.load(fisFileInputStream);
		
		return p.getProperty(key);
		
	}
	/**
	 * Reading data from excel file
	 * @param sheetname,int row,int cell 
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String getExcelvalue(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream=new FileInputStream("./data/testscripts.xlsx");
		Workbook wb = WorkbookFactory.create(fileInputStream);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		//System.out.print(value);
				
		
		return  value;
		
	}
	/**
	 * Write data from Excel file
	 * @param value
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setexcelvalue(String value,String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream= new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fileInputStream);
		wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(value);
		FileOutputStream fileOutputStream= new FileOutputStream("./data/testscript.xlsx");
		wb.write(fileOutputStream);
		wb.close();
		
	}

	
}
