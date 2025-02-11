package organizations;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic_utility.FileUtility;

public class CreateOrgWithIndTest {
	@Test
	public void createOrgWithIndTest(String browser) throws IOException, InterruptedException {
//	public static void main(String[] args) throws IOException, InterruptedException {
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
}