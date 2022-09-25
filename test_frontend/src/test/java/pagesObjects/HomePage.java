package pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    @FindBy(id = "CurrentProjectTitle")
    WebElement currentProjectTitle;
    @FindBy(xpath = "//div/div[contains(@class, 'AddProjectLiDiv')]")
    WebElement addNewProjectButton;
    @FindBy(id = "NewProjNameInput")
    WebElement newProjectTextField;
    @FindBy(id = "NewProjNameButton")
    WebElement addButton;

    public HomePage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getCurrentProjectTitle(){
       return currentProjectTitle.getText();
    }

    public void clickOnTheAddNewProjectButton(){
        waitUntilElementIsVisible(addNewProjectButton);
        waitUntilElementToBeClickable(addNewProjectButton);
        clickOn(addNewProjectButton);
    }
    public boolean isTextFieldForEnteringANewProjectDisplayed(){
        return isWebElementDisplayedOnThePage(newProjectTextField);
    }
    public boolean isTextFieldEmptyTheFirstTime(){
        return newProjectTextField.getAttribute("value").isEmpty();
    }
    public boolean isTheAddButtonDisplayed(){
        return isWebElementDisplayedOnThePage(addButton);
    }
    public boolean isTheAddButtonEnabled(){
        return addButton.isEnabled();
    }
    public void enterANewProject(String name){
        waitUntilElementIsVisible(newProjectTextField);
        fillIn(name, newProjectTextField);
    }
    public void clickOnTheAddButton(){
        clickOn(addButton);
    }
    public void waitUpdatedANewProject(String newTitle){
        waitUntilTheTextChanges(currentProjectTitle, newTitle);
    }
}
