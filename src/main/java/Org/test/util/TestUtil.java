package Org.test.util;

import java.util.ArrayList;

public class TestUtil {
	
	static Xls_Reader reader; 
	static String sheetName = "SearchPage";
	
	public static ArrayList<Object[]> getDataFromExcel() 
	{
				
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader=new Xls_Reader("./src/main/java/Org/testdata/TestDataAdactin.xlsx");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for (int rowNum=2; rowNum<= reader.getRowCount(sheetName); rowNum++) {
			
			String Location= reader.getCellData(sheetName, "Location", rowNum);
			String Hotels= reader.getCellData(sheetName, "Hotels", rowNum);
			String RoomType= reader.getCellData(sheetName, "RoomType", rowNum);
			String NoOfRooms= reader.getCellData(sheetName, "NoOfRooms", rowNum);
			String CIDate= reader.getCellData(sheetName, "CheckInDate", rowNum);
			String CODate= reader.getCellData(sheetName, "CheckOutDate", rowNum);
			String AdultsperRoom= reader.getCellData(sheetName, "AdultsperRoom", rowNum);
			String ChildperRoom= reader.getCellData(sheetName, "ChildrenperRoom", rowNum);

			Object ob[]= {Location,Hotels,RoomType,NoOfRooms,CIDate,CODate,AdultsperRoom,ChildperRoom};
			
			myData.add(ob);
		}
		
		return myData;
	}

}
