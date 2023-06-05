package com.actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {

	public String readdataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./Testdata/CommonData.Property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}


		public String readdataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("./TestData/TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			//Read data from Excel
			String data = wb.getSheet("Excel").getRow(3).getCell(1).getStringCellValue();
			return data;
}


	}


