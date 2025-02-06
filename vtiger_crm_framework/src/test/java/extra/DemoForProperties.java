package extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DemoForProperties {

	public static void main(String[] args) throws IOException {
//		Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\E2_project\\vtiger_crm_framework\\src\\test\\resources\\commonData.properties");

// 		by using load method, load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);

//		by using getProperty(), get the values
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
		System.out.println(BROWSER + " " + URL + " " + USERNAME + " " +PASSWORD);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\git\\E2_project\\vtiger_crm_framework\\src\\test\\resources\\commonData.properties");
		pObj.setProperty("firstname", "john");
		pObj.setProperty("lastname", "cena");
		pObj.setProperty("country", "india");
		
		pObj.store(fos,"");
		System.out.println("data added successfully !!!");
	}

}
