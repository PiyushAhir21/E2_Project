package organizations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.FileUtility;

public class CreateOrgWithIndTest extends BaseClass {
	@Test
	public void createOrgWithIndTest(String browser) throws IOException, InterruptedException {
//	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility flib2 = new FileUtility();

//		getting data from excel sheet
		String orgName = flib2.getDataFromExcel("org", 2, 0) + (int) (Math.random() * 1000);
		String indus = flib2.getDataFromExcel("org", 1, 2);

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
	}
}