package pageEvents;

import pageObjects.HomePageElements;
import utils.Constants;
import utils.ElementFetch;

public class HomePageEvents {
	ElementFetch ele = new ElementFetch();
	
	public void clickSignInButon() {
		ele.getWebElement(Constants.xpath, HomePageElements.signInButton).click();
	}
}
