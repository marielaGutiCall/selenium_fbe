package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(id = "HPloginDiv")
    WebElement logInPopUp;
    @FindBy(id = "ctl00_MainContent_LoginControl1_TextBoxEmail")
    WebElement emailTextField;
    @FindBy(id = "ctl00_MainContent_LoginControl1_TextBoxPassword")
    WebElement passwordTextField;
    @FindBy(id = "ctl00_MainContent_LoginControl1_ButtonLogin")
    WebElement logInButton;
    @FindBy(id = "ErrorMessageText")
    WebElement logInErrorMessage;


    public LoginPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
    public boolean isTheLogInPopUpWindowDisplayed(){
        return isWebElementDisplayedOnThePage(logInPopUp);
    }
    public void enterEmail(String email){
        waitUntilElementIsVisible(emailTextField);
        fillIn(email, emailTextField);
    }
    public void enterPassword(String password){
        waitUntilElementIsVisible(passwordTextField);
        fillIn(password, passwordTextField);
    }
    public void clickLoginButtonFromTheModal(){
        waitUntilElementIsVisible(logInButton);
        waitUntilElementToBeClickable(logInButton);
        clickOn(logInButton);
    }

    public boolean isTheErrorMessageDisplayedOnThePage(){
        return isWebElementDisplayedOnThePage(logInErrorMessage);
    }
    public String getTheErrorMessageTextOfTheLogInForm(){
        return logInErrorMessage.getText();
    }
}
