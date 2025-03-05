package contacts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic_utility.BaseClass;

public class CreateContactTest extends BaseClass {

	@Test
	public void createConWithOrgTest() throws IOException {
		String LastName = fUtil.getDataFromExcel("contact", 1, 0);

//		navigate to contact module and perform work
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
//		Click on save and verify
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
		String verifyLn = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (verifyLn.equals("123")) {
			System.out.println("Lastname : " + LastName + " given Successfully!!!");
		}
	}
}
