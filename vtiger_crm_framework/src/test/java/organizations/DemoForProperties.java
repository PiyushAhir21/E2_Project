package organizations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DemoForProperties {

	public static void main(String[] args) throws IOException {
//		Get the java representation object of the physical file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\Basic_Selenium\\vtiger_crm_framework\\src\\test\\resources\\commonData.properties");

// 		by using load method, load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);

//		by using getProperty(), get the values
		String BRO = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String UN = pObj.getProperty("un");
		String PWD = pObj.getProperty("pwd");
		System.out.println(BRO + "" + URL + "" + UN + "" +PWD);
	}

}
