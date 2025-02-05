package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility2 {
	public String getDataFromProp(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\E2_project\\vtiger_crm_framework\\src\\test\\resources\\commonData.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		return pObj.getProperty(key);
	}

	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis2 = new FileInputStream("C:\\Users\\User\\Desktop\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		return cell.getStringCellValue() + (int) (Math.random() * 1000);
	}
}
