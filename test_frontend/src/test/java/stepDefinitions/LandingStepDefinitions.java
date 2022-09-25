package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pagesObjects.LandingPage;
import pagesObjects.LoginPage;
import pagesObjects.SignUpPage;
import utils.TestContextSetup;

public class LandingStepDefinitions {
    private TestContextSetup testContextSetup;
    private LandingPage landingPage;
    private SignUpPage signUpPage;
    private LoginPage loginPage;

    public LandingStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.landingPage = this.testContextSetup.pageObjectManager.getLandingPage();
        this.signUpPage = this.testContextSetup.pageObjectManager.getSignUpPage();
        this.loginPage = this.testContextSetup.pageObjectManager.getLoginPage();
    }

    @Given("^the user is on the Todo\\.ly landing page$")
    public void the_user_is_on_the_todo_ly_landing_page() {
        landingPage.navigateToTheUrlOfTheTodoLy();
    }
    @When("^the user clicks on the Sign Up Free button$")
    public void the_user_clicks_on_the_sign_up_free_button() {
        landingPage.clickOnTheSignUpButton();
        Assert.assertTrue("The SignUp popup window is not displayed or has not been found on the page", signUpPage.isTheSignUpPopUpWindowDisplayed());
    }
    @When("the user clicks on the Log In Free button")
    public void the_user_clicks_on_the_log_in_free_button() {
        landingPage.clickOnTheLoginButton();
        Assert.assertTrue("The LogIn popup window is not displayed or has not been found on the page", loginPage.isTheLogInPopUpWindowDisplayed());
    }
}
