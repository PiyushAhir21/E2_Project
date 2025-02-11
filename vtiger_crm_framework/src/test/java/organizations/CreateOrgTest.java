package organizations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic_utility.BaseClass;

public class CreateOrgTest extends BaseClass{


	@Test
	public void createOrgTest() throws IOException, InterruptedException {
//		Create Organization
		String orgName = fUtil.getDataFromExcel("org", 1, 0) + (int) (Math.random() * 1000);

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("button")).click();

		String actOrgName = driver.findElement(By.className("dvHeaderText")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println("Organization created succesfully !!!");
		}
	}
}