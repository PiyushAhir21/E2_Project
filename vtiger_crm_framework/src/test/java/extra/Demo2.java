package extra;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo2 {
	
	@Test(dataProvider = "add")
	public void createAccount(String firstName, String LastName) {
		Reporter.log(firstName + " " + LastName,true);
	}

	@DataProvider
	public Object[][] add() {
		Object[][] arr = new Object[3][2];
		
		
		
		arr[0][0] = "john";
		arr[0][1] = "cena";
		
		arr[1][0] = "roman";
		arr[1][1] = "reigns";

		arr[2][0] = "Khali";
		arr[2][1] = "The great";
		
		return arr;
	}

}
