package generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

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

	public void waitForPageToLoad(int i) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialTitle)) {
				break;
			}
		}
	}

	/*
	 * switchTo mouse actions select method synchronization webelement methods
	 */

}
