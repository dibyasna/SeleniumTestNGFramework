package pageEvents;

import org.testng.Assert;

import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
	ElementFetch ele = new ElementFetch();
	
	public void verifyLoginPageIsLoaded() {
		Assert.assertTrue(ele.getWebElement("xpath", LoginPageElements.logInText).isDisplayed(), "Element no found");
	}
	
	public void enterCred(String email, String password) {
		ele.getWebElement("xpath", LoginPageElements.email).sendKeys(email);
		ele.getWebElement("xpath", LoginPageElements.password).sendKeys(password);
		
	}
}
