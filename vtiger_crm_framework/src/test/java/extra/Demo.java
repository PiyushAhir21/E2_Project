package extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo {

//	Helper attributes

	@Test(dependsOnMethods= "createAccount")
	public void deleteAccount() {
	Reporter.log("Account deleted Successfully");
	}

	@Test
	public void createAccount(){
	Reporter.log("Account created Successfully");
	}
}
