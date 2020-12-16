package Org.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
		
	public static String ReadData(String Sheetname, int rowNo, int cellNo){
	
		File f = new File("B:\\Eclipse\\Workspace\\MAvenProject\\src\\TestData.xlsx");
		FileInputStream instream;
		Workbook w;
		Row r;
		String data = null;
		
		try {
			instream = new FileInputStream(f);
			w = new XSSFWorkbook(instream);
			Sheet h = w.getSheet(Sheetname);
			r =h.getRow(rowNo);
			Cell c = r.getCell(cellNo);	
			
			//System.out.println(c);
		    //data = c.getStringCellValue();
		    data= c.toString();
		    
		    //System.out.println(data);
				
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	    //System.out.println("Done Successfully");
	    
		return data;
	    
	}
	
}
		
		
