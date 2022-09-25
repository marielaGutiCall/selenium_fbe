package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pagesObjects.HomePage;
import pagesObjects.SignUpPage;
import utils.TestContextSetup;

public class SignUpStepDefinitions {
    private TestContextSetup testContextSetup;
    private SignUpPage signUpPage;

    public SignUpStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.signUpPage = this.testContextSetup.pageObjectManager.getSignUpPage();
    }

    @And("enters the valid data: {string} in the Full Name text field")
    public void enters_the_valid_data_in_the_full_name_text_field(String fullName) {
       signUpPage.enterFullName(fullName);
    }

    @And("enters the valid data: {string} in the Email text field")
    public void enters_the_valid_data_in_the_email_text_field(String email) {
       signUpPage.enterEmail(email);
    }

    @And("enters the valid data: {string} in the Password text field")
    public void enters_a_valid_data_in_the_password_text_field(String password) {
        signUpPage.enterPassword(password);
    }

    @And("selects the option: {string} from Timezone field")
    public void selects_the_option_from_timezone_field(String timezone) {
        signUpPage.selectAOptionFromTimeZoneDropdown(timezone);
    }

    @And("^marks the Terms of Service checkbox$")
    public void marks_the_terms_of_service_checkbox() {
        signUpPage.marksTermsAndConditionsCheckbox();
    }

    @And("^clicks on the SignUp button in the popup window$")
    public void clicks_on_the_signup_button_in_the_popup_window() {
        signUpPage.clickOnTheSignUpButton();
    }
    @Then("the system should display the error message: {string}")
    public void the_system_should_display_the_error_message(String errorMessage) {
        Assert.assertTrue("The error message is not displayed on the page", signUpPage.isTheErrorMessageDisplayedOnThePage());
        Assert.assertEquals("The error message is not what was expected", errorMessage, signUpPage.getTheErrorMessageTextOfTheSignUpForm());
    }
    @And("enters the invalid data: {string} in the Email text field")
    public void enters_the_invalid_data_in_the_email_text_field(String email) {
        signUpPage.enterEmail(email);
    }
    @And("enters the invalid data: {string} in the Password text field")
    public void enters_the_invalid_data_in_the_password_text_field(String password) {
        signUpPage.enterPassword(password);
    }
    @And("enters the invalid data: {string} in the Full Name text field")
    public void enters_the_invalid_data_in_the_full_name_text_field(String fullName) {
        signUpPage.enterFullName(fullName);
    }
    @Then("the Terms of Service checkbox should not be checked")
    public void the_terms_of_service_checkbox_should_not_be_checked() {
        Assert.assertFalse("The Terms & Service checkbox is selected", signUpPage.isTermsAndServiceFieldChecked());
    }
}
