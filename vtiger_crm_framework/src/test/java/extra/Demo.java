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
import org.testng.annotations.Test;

public class Demo {

	@BeforeSuite
	public void bsuite() {
		Reporter.log("DB connection, Report generation", true);
	}

	@AfterSuite
	public void asuite() {
		Reporter.log("DB close, Report backup", true);
	}
	
	@BeforeTest
	public void btest() {
		Reporter.log("Pre condition", true);
	}
	
	@AfterTest
	public void atest() {
		Reporter.log("Post condition", true);
	}
	
	@BeforeClass
	public void bclass() {
		Reporter.log("Opening browser", true);
	}
	
	@AfterClass
	public void aclass() {
		Reporter.log("close browser", true);
	}
	
	@BeforeMethod
	public void bmethod() {
		Reporter.log("Login", true);
	}
	
	@AfterMethod
	public void amethod() {
		Reporter.log("Logout", true);
	}

	@Test
	public void deleteAccount() {
		Reporter.log("Test Script 1", true);
	}
	
	@Test
	public void createAccount() {
		Reporter.log("Test Script 2", true);
	}
	

}
