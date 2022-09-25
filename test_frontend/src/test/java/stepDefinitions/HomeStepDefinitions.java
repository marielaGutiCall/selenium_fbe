package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pagesObjects.HomePage;
import pagesObjects.SignUpPage;
import utils.TestContextSetup;

public class HomeStepDefinitions {

    private TestContextSetup testContextSetup;
    private HomePage homePage;

    public HomeStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.homePage = this.testContextSetup.pageObjectManager.getHomePage();
    }

    @Then("The system should send the user to the home page titled: {string}")
    public void the_system_should_register_the_user_and_send_him_her_to_his_home_page(String title) {
        Assert.assertEquals("The title of the page is not what was expected",title, homePage.getCurrentProjectTitle());
    }

    @And("clicks the Add New Project button")
    public void clicks_the_add_new_project_button() {
        homePage.clickOnTheAddNewProjectButton();
    }

    @Then("a text field to enter the project name should be displayed")
    public void a_text_field_to_enter_the_project_name_should_be_displayed()  {
        Assert.assertTrue("The text field for entering a new project is not displayed on the page", homePage.isTextFieldForEnteringANewProjectDisplayed());
        Assert.assertTrue("The text field is not empty", homePage.isTextFieldEmptyTheFirstTime());
    }
    @And("button to add the project should be displayed")
    public void button_to_add_the_project() {
        Assert.assertTrue("The Add button is not displayed on the page", homePage.isTheAddButtonDisplayed());
        Assert.assertTrue("The Add button is not enabled", homePage.isTheAddButtonEnabled());
    }

    @And("Enter a {string} name for the project")
    public void enter_a_name_for_the_project(String name)  {
        homePage.enterANewProject(name);
    }

    @And("clicks the Add button")
    public void clicks_the_add_button()  {
        homePage.clickOnTheAddButton();
    }
    @Then("a new project whit the {string} name should be displayed")
    public void a_new_project_should_be_displayed(String name) {
        homePage.waitUpdatedANewProject(name);
        Assert.assertEquals("The title of the page is not what was expected",name, homePage.getCurrentProjectTitle());
    }
}
