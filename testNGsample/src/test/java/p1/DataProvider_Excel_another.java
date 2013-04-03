package p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Excel_another {
	String fileName = "ExcelRepo/Book1.xls";

	@Test(dataProvider = "dp")
	public void testMethod(String value) {
		System.out.println(value);

	}

	@DataProvider(name = "dp")
	public Object[][] getData() throws IOException {
		Workbook workBook = null;
		ArrayList<String> values = new ArrayList<String>();

		InputStream inputStream = getInputFileStream(fileName);
		if (fileName.toLowerCase().endsWith("xlsx") == true) {
			workBook = new XSSFWorkbook(inputStream);
		} else if (fileName.toLowerCase().endsWith("xls") == true) {
			workBook = new HSSFWorkbook(inputStream);
		}
		inputStream.close();
		Sheet sheet = workBook.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		for (int i = 1; i <= rows; i++) {
			Row row = sheet.getRow(i);

			//System.out.println( "****" + row.getCell(0).getStringCellValue());
			//System.out.println( "****" + row.getCell(1).getStringCellValue());
			//System.out.println( "****" + row.getCell(3).getStringCellValue());
			//Numeric values can not be fetched only String values are getting fetched..
			//there should not be any Blank rows in the middle
			
			
			values.add(row.getCell(1).getStringCellValue());
			

			
			
		}
		Object[][] returnValue = new Object[values.size()][1];
		for (int i = 0; i < values.size(); i++) {
			returnValue[i][0] = values.get(i);
		}
		return returnValue;
	}

	private InputStream getInputFileStream(String fileName) throws FileNotFoundException {
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream inputStream = loader.getResourceAsStream(fileName);
		if (inputStream == null) {
			inputStream = new FileInputStream(new File(fileName));
		}
		return inputStream;
	}
}