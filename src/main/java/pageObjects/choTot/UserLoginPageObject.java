package pageObjects.choTot;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.choTot.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public void closePopupIfPresent() {
		if(!isElementDisplayed(driver, LoginPageUI.LABEL_LOGIN)) {
			waitForElementClickable(driver, LoginPageUI.PRESENTATION);
			clickToElementByJS(driver, LoginPageUI.PRESENTATION);
		}
	}

	public String checkGrammarTextOfLabelLogin() {
		return getElementText(driver, LoginPageUI.LABEL_LOGIN);
	}

	public String checkGrammarTextOfLabelWelcomBack() {
		return getElementText(driver, LoginPageUI.LABEL_WELCOME_BACK);
	}

	public String checkGrammarTextOfPlaceholderPhone() {
		return getElementAttribute(driver, LoginPageUI.PLACEHOLDER_PHONE, "placeholder");
	}

	public String checkGrammarTextOfPlaceholderPassword() {
		return getElementAttribute(driver, LoginPageUI.PLACEHOLDER_PASSWORD, "placeholder");
	}

	public String checkGrammarTextOfButtonLogin() {
		return getElementText(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public String checkGrammarTextOfLabelForgetPassword() {
		return getElementText(driver, LoginPageUI.FORGET_PASSWORD_LINK);
	}

	public String checkGrammarTextOfLabelLoginThird() {
		return getElementText(driver, LoginPageUI.LOGIN_3THIRD);
	}

	public String checkGrammarTextOfLabelRegister() {
		return getElementText(driver, LoginPageUI.LABEL_DO_NOT_HAVE_ACCOUNT);
	}


	public void inputToPhoneTextbox(String phone) {
		waitForElementVisible(driver, LoginPageUI.PLACEHOLDER_PHONE);
		sendkeyToElement(driver, LoginPageUI.PLACEHOLDER_PHONE, phone);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PLACEHOLDER_PASSWORD);
		sendkeyToElement(driver, LoginPageUI.PLACEHOLDER_PASSWORD, password);
	}

	public void inputToPhoneAndPasswordTextbox(String phone, String password) {
        inputToPhoneTextbox(phone);
		inputToPasswordTextbox(password);

	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElementByJS(driver, LoginPageUI.LOGIN_BUTTON);
		return new UserHomePageObject(driver);
	}

	public boolean verifyLoginSuccess() {
		waitForElementVisible(driver, LoginPageUI.AVATAR);
		return isElementDisplayed(driver, LoginPageUI.AVATAR);
	}

	public String showMessage() {
		waitForElementVisible(driver, LoginPageUI.MESSAGE);
		return getElementText(driver, LoginPageUI.MESSAGE);
	}

	public void openLoginPage() {
		openUrl(driver, GlobalConstants.getGlobalInstance().getUserPageUrl());
	}
}
