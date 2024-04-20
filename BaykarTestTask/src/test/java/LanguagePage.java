import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LanguagePage {
    private WebDriver driver;

    private By language = By.className("lang");
    private By htmlElement = By.cssSelector("html");

    public LanguagePage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getLanguage(){
        return driver.findElement(language);
    }

    public String getHtmlLanguage(){
        return driver.findElement(htmlElement).getAttribute("lang").toLowerCase();
    }


}
