package pagesObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager extends  BasePage{

    public PageObjectManager(WebDriver webDriver){
        super(webDriver);
    }
    public LoginPage getLoginPage(){
        return new LoginPage(webDriver);
    }
    public SignUpPage getSignUpPage(){
        return new SignUpPage(webDriver);
    }
    public HomePage getHomePage(){
        return new HomePage(webDriver);
    }
    public LandingPage getLandingPage(){
        return new LandingPage(webDriver);
    }
}
