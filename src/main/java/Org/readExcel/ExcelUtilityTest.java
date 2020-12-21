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
		
		/*
		
		System.out.println(reader.getCellData(sheetName, "username", 3));
		String data = reader.getCellData(sheetName, 0, 2);
		System.out.println(data);
		
		
		
		
		
		
		reader.setCellData(sheetName, "status", 2, "PASS");
		
		System.out.println(reader.getColumnCount(sheetName));
		
		//reader.removeColumn("Regsitration", 0);
		
		System.out.println(reader.getCellData("Regsitration", "phonenumber", 2));
		System.out.println(reader.getCellData("Regsitration", "age", 2));

		*/
		
		
	}

}
