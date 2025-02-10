package organizations;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.LoginPage;

public class OrgTest {

	@Test
	public void createOrgTest() throws IOException, InterruptedException {
		FileUtility fUtil = new FileUtility();
		String BROWSER = fUtil.getDataFromProp("bro");
		String URL = fUtil.getDataFromProp("url");
		String USERNAME = fUtil.getDataFromProp("un");
		String PASSWORD = fUtil.getDataFromProp("pwd");

		String orgName = fUtil.getDataFromExcel("org", 1, 0) + (int) (Math.random() * 1000);

//		Opening browser
//		WebDriver driver = new ChromeDriver();
		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			driver = new ChromeDriver();
		}

		WebDriverUtility wdlib = new WebDriverUtility(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);

////		Login
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//
//		WebElement submitBtn = driver.findElement(By.id("submitButton"));
////		submitBtn.click();
//		wdlib.clickOnElement(submitBtn);

		LoginPage lp = new LoginPage(driver);
//		lp.login();

		lp.getUserEdit().sendKeys(USERNAME);
		lp.getPassEdit().sendKeys(PASSWORD);
		lp.getLoginBtn().click();

//		Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("button")).click();

//		Verification
		String actOrgName = driver.findElement(By.className("dvHeaderText")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println("Organization created succesfully !!!");
		}

//		Log out
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

	@Test
	public void createOrgWithIndTest() throws IOException, InterruptedException {
		FileUtility flib2 = new FileUtility();
		String URL = flib2.getDataFromProp("url");
		String USERNAME = flib2.getDataFromProp("un");
		String PASSWORD = flib2.getDataFromProp("pwd");

//		getting data from excel sheet
		String orgName = flib2.getDataFromExcel("org", 2, 0) + (int) (Math.random() * 1000);
		String indus = flib2.getDataFromExcel("org", 1, 2);

//		Opening browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

//		Login
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		WebElement submitBtn = driver.findElement(By.id("submitButton"));
		submitBtn.click();

//		Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//		String orgName = "fb_" + (int) (Math.random() * 1000);
		driver.findElement(By.name("accountname")).sendKeys(orgName);

		WebElement industry = driver.findElement(By.name("industry"));
		Select indSel = new Select(industry);
//		String indus = "Technology";
		indSel.selectByValue(indus);

//		save
		driver.findElement(By.name("button")).click();

//		Verification
		String actOrgName = driver.findElement(By.className("dvHeaderText")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println("Organization created succesfully !!!");
		}

		String actIndustry = driver.findElement(By.id("mouseArea_Industry")).getText();
		if (actIndustry.equals(indus)) {
			System.out.println("industry dropdown added successfully !!!");
		}

//		Log out
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}

	@Test
	public void createOrgWithPhoneTest() throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\git\\E2_project\\vtiger_crm_framework\\src\\test\\resources\\commonData.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

//			getting data from excel sheet

		FileInputStream fis2 = new FileInputStream("C:\\Users\\User\\Desktop\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("org");

		String orgName = sh.getRow(2).getCell(0).getStringCellValue() + (int) (Math.random() * 1000);
		String phone = sh.getRow(1).getCell(1).getStringCellValue();

//			Opening browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

//			Login
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		WebElement submitBtn = driver.findElement(By.id("submitButton"));
		submitBtn.click();

//			Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//			String orgName = "fb_" + (int) (Math.random() * 1000);
		driver.findElement(By.name("accountname")).sendKeys(orgName);

//			String phone = "9876543210";
		driver.findElement(By.id("phone")).sendKeys(phone);

//			save
		driver.findElement(By.name("button")).click();

//			Verification
		String actOrgName = driver.findElement(By.className("dvHeaderText")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println("Organization created succesfully !!!");
		}

		String actPhone = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actPhone.contains(phone)) {
			System.out.println("Phone number entered successfully !!!");
		}

//			Log out
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
}
