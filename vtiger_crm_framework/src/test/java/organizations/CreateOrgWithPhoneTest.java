package organizations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.LoginPage;

public class CreateOrgWithPhoneTest extends BaseClass {

	@Test
	public void createOrgWithPhoneTest() throws IOException, InterruptedException {
		FileUtility flib2 = new FileUtility();

//		getting data from excel sheet
		String orgName = flib2.getDataFromExcel("org", 2, 0) + (int) (Math.random() * 1000);
		String phone = flib2.getDataFromExcel("org", 1, 1);

//			Login
		LoginPage lp = new LoginPage(driver);
		lp.login();

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
//		if (actOrgName.contains(orgName)) {
//			System.out.println("Organization created succesfully !!!");
//		}else {
//			System.out.println("Organization is not creatd !!!");
//		}
		Boolean status = actOrgName.contains(orgName + " ");
		Assert.assertTrue(status);

		String actPhone = driver.findElement(By.id("dtlview_Phone")).getText();
//		if (actPhone.contains(phone)) {
//			System.out.println("Phone number entered successfully !!!");
//		}else {
//			System.out.println("Phone number is not given");
//		}
		Boolean status2 = actPhone.equals(phone + " ");
//		Assert.assertTrue(status2);

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(status2);

//		Log out
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

//		soft.assertAll();
	}
}