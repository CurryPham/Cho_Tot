package pageObjects.choTot;

import org.openqa.selenium.WebDriver;
import pageObjects.choTot.UserLoginPageObject;

public class PageGeneratorManager {

//	public  static PageGeneratorManager getPageGeneratorManager() {
//		return new PageGeneratorManager();
//	}


	public static pageObjects.choTot.UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public UserHomePageObject getUserRegisterPage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}




}
