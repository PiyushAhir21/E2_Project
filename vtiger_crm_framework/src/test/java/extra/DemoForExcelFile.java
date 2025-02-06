package extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DemoForExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
//		get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptData.xlsx");
		
		Workbook wb =  WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		Row row = sh.getRow(1);
		
		Cell cell = row.getCell(3);
		
		int value = (int) cell.getNumericCellValue(); // + (int)(Math.random()*1000);
		
		System.out.println(value);
		
	}

}
