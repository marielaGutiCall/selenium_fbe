package utils;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Base {
    private WebDriver webDriver;
    public WebDriver WebDriverManager(){
        String browser ="chrome";
        if (webDriver == null){
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                    break;
                default:
                    throw new Error("Can not open the browser");
            }
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
        return webDriver;
    }
    @After
    public void AfterScenario()  {
        webDriver.quit();
    }
}
