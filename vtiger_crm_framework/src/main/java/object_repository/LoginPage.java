package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(name = "user_name")
	
//	and operator
//	@FindAll({@FindBy(name = "abc"),@FindBy(id = "xyz")})
	
// 	Or operator
	@FindAll({@FindBy(name = "user_name"),@FindBy(xpath = "//input[@type = 'tex']")})
	private WebElement userEdit;

	public WebElement getUserEdit() {
		return userEdit;
	}

	@FindBy(name = "user_password")
	private WebElement passEdit;

	public WebElement getPassEdit() {
		return passEdit;
	}

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void login() {
		getUserEdit().sendKeys("admin");
		getPassEdit().sendKeys("password");
		getLoginBtn().click();
	}

}
