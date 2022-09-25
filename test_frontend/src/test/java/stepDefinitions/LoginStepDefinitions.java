package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pagesObjects.LoginPage;
import pagesObjects.SignUpPage;
import utils.TestContextSetup;

public class LoginStepDefinitions {

    private TestContextSetup testContextSetup;
    private LoginPage loginPage;

    public LoginStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.loginPage = this.testContextSetup.pageObjectManager.getLoginPage();
    }

    @And("enters a valid credential for the email: {string}")
    public void enters_a_valid_credential_for_the_email(String email) {
        loginPage.enterEmail(email);
    }

    @And("enters a valid credential for the password: {string}")
    public void enters_a_valid_credential_for_the_password(String password)  {
        loginPage.enterPassword(password);
    }

    @And("clicks on the Login button in the popup window")
    public void clicks_on_the_login_button_in_the_popup_window() {
        loginPage.clickLoginButtonFromTheModal();
    }

    @Then("the system should display the error message about invalid credentials: {string}")
    public void the_system_should_display_the_error_message(String errorMessage)  {
        Assert.assertTrue("The error message is not displayed on the page", loginPage.isTheErrorMessageDisplayedOnThePage());
        Assert.assertEquals("The error message is not what was expected", errorMessage, loginPage.getTheErrorMessageTextOfTheLogInForm());
    }
}
