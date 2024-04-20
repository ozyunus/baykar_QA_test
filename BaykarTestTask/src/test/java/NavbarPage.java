import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NavbarPage {
    private WebDriver driver;
    private By navbarLocator = By.className("nav-link");
    private By menuItems = By.xpath("following-sibling::div[contains(@class, 'dropdown-menu')]");
    private By dropDown = By.cssSelector(".mega-link");



    public NavbarPage(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getNavBar(){

        return driver.findElements(navbarLocator);
    }
    public List<WebElement> getDropdownLinks(WebElement menuItem ){
        WebElement dropdownMenu = menuItem.findElement(menuItems);
        return dropdownMenu.findElements(dropDown);
    }

    public String checkPopup(WebElement menuItem ){
        BaseTest.action.moveToElement(menuItem).perform();
        return menuItem.getAttribute("aria-haspopup");
    }

}
