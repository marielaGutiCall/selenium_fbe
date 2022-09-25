package pagesObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait wait;
    private int timeOutInSeconds = 10;


    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    protected void navigateTo(String url){
        webDriver.get(url);
    }
    protected void waitUntilElementIsVisible(WebElement webElement){
        waitUntilElementIsVisible(webElement, timeOutInSeconds);
    }
    protected void waitUntilElementIsVisible(WebElement webElement, int timeOutInSeconds){
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds));
        try{
           wait.until(ExpectedConditions.visibilityOf(webElement));
        }catch (TimeoutException e){
           throw new Error("The "+webElement+" web element is not visible on the page");
        }
    }
    protected void waitUntilElementToBeClickable(WebElement webElement){
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeOutInSeconds));
        try{
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        }catch (TimeoutException e){
            throw new Error("The "+webElement+" web element cannot be clicked");
        }
    }
    protected boolean isWebElementDisplayedOnThePage(WebElement webElement){
        boolean isDisplayed;
        try {
           isDisplayed = webElement.isDisplayed();
        }catch (NoSuchElementException e){
           isDisplayed = false;
        }
        return isDisplayed;
    }
    protected void clickOn(WebElement webElement){
        webElement.click();
    }
    protected void fillIn(String text, WebElement webElement){
        webElement.sendKeys(text);
    }
    protected void switchThePage(){
        Actions actions = new Actions(webDriver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
    }
    protected void waitUntilTheTextChanges(WebElement webElement, String text){
        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }
}
