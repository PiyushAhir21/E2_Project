package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {

	WebDriver driver;
	Actions act;
	
	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}
	
	public void clickOnElement(WebElement element) {
		act.click(element).build().perform();
	}
	
	/*
	 * switchTo
	 * mouse actions
	 * select method
	 * synchronization
	 * webelement methods 
	 */
	
}
