import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CareerPage {

    private WebDriver driver;

    private By searchResult = By.cssSelector("div.row  ul#myUL a");
    private By checkBox =By.id("47");

    private By careerLink = By.linkText("KARİYER");
    private By openPositionButton = By.className("fix-btn");

    private By searchElement = By.id("myInput");

    public CareerPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getCareerLink(){
        return driver.findElement(careerLink);
    }
    public WebElement getOpenPositionButton(){
        return driver.findElement(openPositionButton);
    }

    public WebElement getSearch(){
        return driver.findElement(searchElement);
    }

    public List<WebElement> getSearchResult(){
        return driver.findElements(searchResult);
    }

    public WebElement getCheckBox(){
        return driver.findElement(checkBox);
    }

}
