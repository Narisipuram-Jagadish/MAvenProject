package Org.readExcel;

import Org.test.util.Xls_Reader;

public class ExcelUtilityTest {

	public static void main(String[] args) {

		Xls_Reader reader = new Xls_Reader("./src/main/java/Org/testdata/TestData.xlsx");
		
		String sheetName = "login";
		
		//Remove sheet if already exists
		System.out.println("Sheet Removed :"+reader.removeSheet(sheetName));
		
		//Add Sheetname
		
		if(! reader.isSheetExist(sheetName)){
			reader.addSheet(sheetName);
			System.out.println("Sheet "+sheetName+" created" );
		}
		

		//Get No of rows:  1 means no rows (generally added just bcause first will not have any data column names)
		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows: "+ rowCount);
		
		//Add Column
		
		reader.addColumn(sheetName, "Username");
		reader.addColumn(sheetName, "Password");

		//get Column Count
		System.out.println("No of columns : " +reader.getColumnCount(sheetName));
		
		rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows: "+ rowCount);
		
		
		//Add data 
		reader.setCellData(sheetName, "Username", rowCount+1, "Rupesh-villuri");
		reader.setCellData(sheetName, "Password", rowCount+1, "NTR@1");

		 
		rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows: "+ rowCount);
		
		//Add data 
		reader.setCellData(sheetName, "Username", rowCount+1, "Rupesh-Baahubali");
		reader.setCellData(sheetName, "Password", rowCount+1, "Prabhas@123");

		rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows: "+ rowCount);
		
		//Reading cell data
		

		//printing 1nd set
		System.out.println("printing 1st set");
		System.out.println(reader.getCellData(sheetName, "Username", 2));
		System.out.println(reader.getCellData(sheetName, "Password", 2) +"\n");

		//printing 2nd set using column name
		System.out.println("printing 2nd set using column name");
		System.out.println(reader.getCellData(sheetName, "Username", 3));
		System.out.println(reader.getCellData(sheetName, "Password", 3));
	
		
		//reader.removeColumn("Regsitration", 0);

	}

}
