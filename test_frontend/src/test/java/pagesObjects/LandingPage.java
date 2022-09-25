package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage extends BasePage{
    @FindBy(xpath = "//div[contains(@class, 'HPHeaderSignup')]")
    WebElement signUpButton;
    @FindBy(xpath = "//div[contains(@class, 'HPHeaderLogin')]")
    WebElement logInButton;

    private final String URL = "https://todo.ly/";


    public LandingPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void navigateToTheUrlOfTheTodoLy(){
        navigateTo(URL);
    }
    public void clickOnTheSignUpButton(){
       waitUntilElementIsVisible(signUpButton);
       waitUntilElementToBeClickable(signUpButton);
       clickOn(signUpButton);
    }
    public void clickOnTheLoginButton(){
        waitUntilElementIsVisible(logInButton);
        waitUntilElementToBeClickable(logInButton);
        clickOn(logInButton);
    }
}
