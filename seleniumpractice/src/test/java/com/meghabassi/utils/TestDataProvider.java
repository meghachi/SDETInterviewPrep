package com.meghabassi.utils;

import org.testng.annotations.DataProvider;

import com.meghabassi.commonLibs.utils.ExcelDriver;
public class TestDataProvider {
	
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data =new Object[3][2];
		data[0][0]="mngr546444";
		data[0][1]="umujUtu";
		
		data[1][0]="mngr54645";
		data[1][1]="umujUtu";
		data[2][0]="mngr54664";
		data[2][1]="umujUtu";
		return data;
		
	}

	@DataProvider
	public Object[][] getDataFromExcel()throws Exception{
		String excelFileName=System.getProperty("user.dir")+"/testDataInputFiles/TestData.xlsx";
		ExcelDriver excelDriver= new ExcelDriver();
		excelDriver.openWorkBook(excelFileName);
		Object[][] data;
		String sheetName="TestData";
		int rowCount=excelDriver.getRowCount(sheetName);
		int cellCount=excelDriver.getCellCountFromARow(sheetName,1);
		data=new Object[rowCount+1][cellCount];
		for(int row=0;row<rowCount;row++) {
			for(int cell=0;cell<cellCount;cell++) {
				data[row][cell]=excelDriver.getCellData(sheetName, row, cell);
			}
		}
		return data;
		
	}
}
