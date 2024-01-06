package com.meghabassi.commonLibs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDriver {

	private InputStream fileReader;
	private Workbook excelWorkBook;

	public void openWorkBook(String excelFileName) throws Exception {

		excelFileName = excelFileName.trim();
		File file = new File(excelFileName);
		if (!file.exists()) {
			throw new Exception("File does not exist");
		}
		fileReader = new FileInputStream(excelFileName);
		excelWorkBook = WorkbookFactory.create(fileReader);

	}

	public int getRowCount(String sheetName) throws Exception {
		sheetName = sheetName.trim();
		Sheet sheet = excelWorkBook.getSheet(sheetName);
		if (sheet == null) {
			throw new Exception("Invalid Sheet Name" + sheetName);

		}
		return sheet.getLastRowNum();

	}

	public int getCellCountFromARow(String sheetName, int rowNumber) throws Exception {
		sheetName = sheetName.trim();
		Sheet sheet = excelWorkBook.getSheet(sheetName);
		if (sheet == null) {
			throw new Exception("Invalid Sheet Name" + sheetName);

		}
		if (rowNumber < 0)
			throw new Exception("Invalid Row Number");

		Row row = sheet.getRow(rowNumber);
		if (row == null)
			return 0;
		else
			return row.getLastCellNum();
		
	}

	public String getCellData(String sheetName, int rowNumber, int cellNumber) throws Exception {
		sheetName = sheetName.trim();
		Sheet sheet = excelWorkBook.getSheet(sheetName);
		if (sheet == null) {
			throw new Exception("Invalid Sheet Name" + sheetName);

		}
		if (rowNumber < 0 || cellNumber <0)
			throw new Exception("Invalid Row Number");

		Row row = sheet.getRow(rowNumber);
		if (row == null)
			return "";
		
		Cell cell=row.getCell(cellNumber);
		
		if(cell==null)
			return "";
		else
		{
			if(cell.getCellType() ==CellType.NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			}
			else
				return cell.getStringCellValue();
		}
	}
}
