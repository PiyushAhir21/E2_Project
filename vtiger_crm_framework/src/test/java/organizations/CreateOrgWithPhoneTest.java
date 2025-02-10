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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrgWithPhoneTest {

	
	@Test
	public void createOrgWithPhoneTest() throws IOException, InterruptedException {
//	public static void main(String[] args) throws IOException, InterruptedException {

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
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}