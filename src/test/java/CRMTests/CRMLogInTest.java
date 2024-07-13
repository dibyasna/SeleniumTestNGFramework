package CRMTests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class CRMLogInTest extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	LoginPageEvents loginPage = new LoginPageEvents();
	HomePageEvents homePage = new HomePageEvents();
	@Test
	public void CRMLogin() {
		homePage.clickSignInButon();
		loginPage.verifyLoginPageIsLoaded();
		loginPage.enterCred("dibya@gamil.com", "123");
	}
}
