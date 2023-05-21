package pageObjects.choTot;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.choTot.HomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}


	public UserLoginPageObject logoutAccount() {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_PROFILE);
		clickToElement(driver, HomePageUI.ACCOUNT_PROFILE);
		waitForAllElementVisible(driver, HomePageUI.LOGOUT_ACCOUNT_LINK);
		waitForElementClickable(driver, HomePageUI.LOGOUT_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_ACCOUNT_LINK);
		return new UserLoginPageObject(driver);
	}

}
