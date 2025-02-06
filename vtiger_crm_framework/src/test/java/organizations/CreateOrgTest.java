package organizations;

import java.io.IOException;
import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import object_repository.LoginPage;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileUtility fUtil = new FileUtility();
		String BROWSER = fUtil.getDataFromProp("bro");
		String URL = fUtil.getDataFromProp("url");
		String USERNAME = fUtil.getDataFromProp("un");
		String PASSWORD = fUtil.getDataFromProp("pwd");

		String orgName = fUtil.getDataFromExcel("org", 1, 0);

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
		driver.close();
	}
}