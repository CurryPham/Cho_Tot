package choTot.stepDefinitions;

import commons.GlobalConstants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.choTot.PageGeneratorManager;
import pageObjects.choTot.UserLoginPageObject;
import pageObjects.choTot.UserHomePageObject;

public class loginUISteps {
    WebDriver driver;
    UserLoginPageObject loginPage;
    UserHomePageObject homePage;
    private static String projectPath = GlobalConstants.getGlobalInstance().getProjectPath();

    public loginUISteps() {
        this.driver = Hooks.openAndQuitBrowser();
        loginPage = PageGeneratorManager.getUserLoginPage(driver);

    }

    @Given("^I want open login page$")
    public void openLoginPage() {
        loginPage.openLoginPage();
    }
    @Given("^I want close popup presentation if present$")
    public void closePopupPresentationIfPresent() {
        loginPage.closePopupIfPresent();
    }

    @Then("^I want check grammar / text  of label login have text with \"([^\"]*)\"$")
    public void checkGrammarTextOfLabelWelcomeBackHaveTextWith(String labelLogin){
        Assert.assertEquals("Label Login Have Wrong Text", loginPage.checkGrammarTextOfLabelLogin(), labelLogin);
    }

    @Then("^I want check grammar / text  of label welcome back have text with \"([^\"]*)\"$")
    public void checkGrammarTextOfLabeLoginlHaveTextWith(String labelWelcomeBack){
        Assert.assertEquals("Label Welcome Back Have Wrong Text", loginPage.checkGrammarTextOfLabelWelcomBack(), labelWelcomeBack);
    }

    @Then("^I want check grammar / text  of placeholder phone have text with \"([^\"]*)\"$")
    public void checkGrammarTextOfPlaceholderPhoneHaveTextWith(String placeholderPhone){
        Assert.assertEquals("Placeholder Phone Have Wrong Text", loginPage.checkGrammarTextOfPlaceholderPhone(), placeholderPhone);
    }

    @Then("^I want check grammar / text  of placeholder password have text with \"([^\"]*)\"$")
    public void checkGrammarTextOfPlaceholderPasswordHaveTextWith(String placeholderPassword){
        Assert.assertEquals("Placeholder Password Have Wrong Text", loginPage.checkGrammarTextOfPlaceholderPassword(), placeholderPassword);
    }

    @Then("^I want check grammar / text  of button login have text with with \"([^\"]*)\"$")
    public void checkGrammarTextOfButtonLoginHaveTextWithWith(String loginButton){
        Assert.assertEquals("Button Login Have Wrong Text", loginPage.checkGrammarTextOfButtonLogin(), loginButton);
    }

    @Then("^I want check grammar / text  of label forget password have text with with \"([^\"]*)\"$")
    public void checkGrammarTextOfLabelForgetPasswordHaveTextWithWith(String labelForgetPassword){
        Assert.assertEquals("Label Forget Password Have Wrong Text", loginPage.checkGrammarTextOfLabelForgetPassword(), labelForgetPassword);
    }

    @Then("^I want check grammar / text  of label login (\\d+)third have text with with \"([^\"]*)\"$")
    public void checkGrammarTextOfLabelLoginThirdHaveTextWithWith(int arg1, String labelLoginThird){
        Assert.assertEquals("Label Third Have Wrong Text", loginPage.checkGrammarTextOfLabelLoginThird(), labelLoginThird);
    }

    @Then("^I want check grammar / text  of label register have text with with \"([^\"]*)\"$")
    public void checkGrammarTextOfLabelRegisterHaveTextWithWith(String labelRegister){
        Assert.assertEquals("Label Register Have Wrong Text", loginPage.checkGrammarTextOfLabelRegister(), labelRegister);
    }

    @When("^I input to Phone and Password textbox with value \"([^\"]*)\" and value \"([^\"]*)\"$")
    public void inputToPhoneAndPasswordTextboxWithValueAndValue(String phone, String password){
        loginPage.inputToPhoneAndPasswordTextbox(phone, password);
    }

    @When("^I click to Login button$")
    public void clickToLoginButton() {
        homePage = loginPage.clickToLoginButton();
    }

    @Then("^I want verify Login Success$")
    public void verifyLoginSuccess() {
        Assert.assertTrue(loginPage.verifyLoginSuccess());
    }

    @Then("^I want show Message: \"([^\"]*)\"$")
    public void showMessage(String message) {
        Assert.assertEquals("Wrong information", loginPage.showMessage(), message);
    }

    @When("^I input to Phone textbox with value \"([^\"]*)\"$")
    public void inputToPhoneTextboxWithValue(String phone) throws Throwable {
        loginPage.inputToPhoneTextbox(phone);
    }

    @When("^I input to Password textbox with value \"([^\"]*)\"$")
    public void inputToPasswordTextboxWithValue(String password) {
        loginPage.inputToPasswordTextbox(password);
    }

    @Then("^I want logout Account$")
    public void logoutAccount() {
        loginPage = homePage.logoutAccount();
    }

}
