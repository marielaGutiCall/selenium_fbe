package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class, 'HPsignupDiv')]")
    WebElement signUpPopUp;
    @FindBy(id = "ctl00_MainContent_SignupControl1_TextBoxFullName")
    WebElement fullNameTextField;
    @FindBy(id = "ctl00_MainContent_SignupControl1_TextBoxEmail")
    WebElement emailTextField;
    @FindBy(id = "ctl00_MainContent_SignupControl1_TextBoxPassword")
    WebElement passwordTextField;
    @FindBy(id = "ctl00_MainContent_SignupControl1_DropDownTimezone")
    WebElement timeZoneDropdown;
    @FindBy(id = "ctl00_MainContent_SignupControl1_CheckBoxTerms")
    WebElement termsCheckbox;
    @FindBy(id = "ctl00_MainContent_SignupControl1_ButtonSignup")
    WebElement signUpButton;
    @FindBy(id = "HeaderMessageError")
    WebElement signupErrorMessage;
    @FindBy(xpath = "//label[contains(@class, 'HPLoginTerms')]/a")
    WebElement termsOfServiceLink;

    public SignUpPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void enterFullName(String fullName){
        waitUntilElementIsVisible(fullNameTextField);
        fillIn(fullName, fullNameTextField);
    }
    public void enterEmail(String email){
        waitUntilElementIsVisible(emailTextField);
        fillIn(email, emailTextField);
    }
    public void enterPassword(String password){
        waitUntilElementIsVisible(passwordTextField);
        fillIn(password, passwordTextField);
    }
    public void selectAOptionFromTimeZoneDropdown(String timezone){
        waitUntilElementIsVisible(timeZoneDropdown);
        Select timeZoneDropDown = new Select(timeZoneDropdown);
        timeZoneDropDown.selectByVisibleText(timezone);
    }
    public void marksTermsAndConditionsCheckbox(){
        waitUntilElementIsVisible(termsCheckbox);
        waitUntilElementToBeClickable(termsCheckbox);
        clickOn(termsCheckbox);
    }
    public void clickOnTheSignUpButton(){
        waitUntilElementIsVisible(signUpButton);
        waitUntilElementToBeClickable(signUpButton);
        clickOn(signUpButton);
    }
    public boolean isTheSignUpPopUpWindowDisplayed(){
        return isWebElementDisplayedOnThePage(signUpPopUp);
    }
    public boolean isTheErrorMessageDisplayedOnThePage(){
        return isWebElementDisplayedOnThePage(signupErrorMessage);
    }
    public String getTheErrorMessageTextOfTheSignUpForm(){
        return signupErrorMessage.getText();
    }
    public boolean isTermsAndServiceFieldChecked(){
        waitUntilElementIsVisible(termsCheckbox);
        return termsCheckbox.isSelected();
    }
    public boolean isTheTermsOfServicePageOpenedInANewTab(){
        return termsOfServiceLink.getAttribute("target").equalsIgnoreCase("_blank");
    }
}
