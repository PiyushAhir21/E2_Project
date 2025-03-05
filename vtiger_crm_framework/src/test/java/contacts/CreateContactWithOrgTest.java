package contacts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.WebDriverUtility;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void createConWithOrgTest() throws IOException {

		WebDriverUtility wdlib = new WebDriverUtility(driver);

		String orgName = fUtil.getDataFromExcel("org", 1, 0) + (int) (Math.random() * 1000);
		String LastName = fUtil.getDataFromExcel("contact", 1, 0);

// 		Navigate to organizations page and create one org
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		driver.findElement(By.xpath("//input[@type='text' and @name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();

		WebElement verify = driver.findElement(By.xpath("//span[contains(text(), 'Updated today')]"));
		if (verify.isDisplayed()) {

			System.out.println("Org : " + orgName + " Created Successfully!!!");
		}

//		navigate to contact module and perform work
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// Switch to child window using Utility class & perform work
		wdlib.switchToTabOnTitle(driver, "module=Accounts");

		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();

		// Click on the organization name link
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// Switch back to parent window using Utility class
		wdlib.switchToTabOnTitle(driver, "Contacts&action");

//		Click on save and verify
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
		String verifyLn = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (verifyLn.equals("123")) {
			System.out.println("Lastname : " + LastName + " given Successfully!!!");
		}
	}
}
