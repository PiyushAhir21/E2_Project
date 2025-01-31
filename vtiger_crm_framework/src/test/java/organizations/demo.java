package organizations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class demo {

	public static void main(String[] args) throws IOException {
//		Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\Basic_Selenium\\vtiger_crm_framework\\src\\test\\resources\\commonData.properties");

// 		by using load method, load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);

//		by using getProperty(), get the values
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		System.out.println();
		System.out.println(BROWSER + "" + URL + "" + USERNAME + "" +PASSWORD);
	}

}
