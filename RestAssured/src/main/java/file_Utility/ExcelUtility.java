package file_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * read data from excel file
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Ayush Com\\eclipse-workspace\\RestAssured\\Api_testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.getStringCellValue();
		return data;
	}
	
	/**
	 * get the last used row count on the sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Ayush Com\\eclipse-workspace\\RestAssured\\Api_testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}

}
