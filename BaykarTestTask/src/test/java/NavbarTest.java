import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class NavbarTest extends BaseTest {
    String searchText = "Kablolama";
    WebElement search;
    List<WebElement> searchResult;


    @Test(priority = 1)
    public void navbarTraverse() throws InterruptedException {

        for (int i = 0; i < navBar.size(); i++) {
            navBar = navbarPage.getNavBar();
            WebElement menuItem = navBar.get(i);
            String result = navbarPage.checkPopup(menuItem);
            menuItem.click();

            if (result != null) {
                Thread.sleep(1000);

                List<WebElement> dropdownLinks = navbarPage.getDropdownLinks(menuItem);
                for (int j = 0; j < dropdownLinks.size(); j++) {

                    if (j > 0) {
                        Thread.sleep(1000);
                        navBar = navbarPage.getNavBar();
                        menuItem = navBar.get(i);

                        action.moveToElement(menuItem).perform();
                        menuItem.click();
                        Thread.sleep(1000);

                    }
                    dropdownLinks = navbarPage.getDropdownLinks(menuItem);

                    WebElement dropdownLink = dropdownLinks.get(j);
                    String webPageLinkText = dropdownLink.getText();
                    action.moveToElement(dropdownLink).click().perform();
                    String webPageTittle = driver.getTitle();
                    String titleSplit = webPageTittle.split("\\| ")[1];

                    softAssert.assertEquals(titleSplit, webPageLinkText);
                    driver.navigate().back();
                }
            } else {
                driver.navigate().back();
            }
        }
    }

    @Test(priority = 2)
    public void LanguageTest() {
        WebElement language = languagePage.getLanguage();
        String expectedData = language.getText().toLowerCase();
        language.click();
        String actualData = languagePage.getHtmlLanguage();
        softAssert.assertEquals(actualData, expectedData);

        // Re-change language to TR
        language = languagePage.getLanguage();
        language.click();
    }
    @Test(priority = 3)
    public void CareerSearchTest() throws InterruptedException {
        WebElement careerLink = careerPage.getCareerLink();
        careerLink.click();
        WebElement openPositionButton = careerPage.getOpenPositionButton();
        openPositionButton.click();
        Thread.sleep(5000);
        search = careerPage.getSearch();
        search.click();
        search.sendKeys(searchText);
        search.sendKeys(Keys.ENTER);
        search.clear();
        searchResult = careerPage.getSearchResult();
        for (int i = 0; i < searchResult.size(); i++) {
            WebElement link = searchResult.get(i);
            String newlink = link.getText().split("\n")[0];
            if (!newlink.contains(searchText)) {
                softAssert.assertEquals(newlink, searchText);
            }
        }
        searchResult.clear();
    }

    @Test(priority = 4)
    public void CareerSearchTest2() throws InterruptedException {

        searchText = "Piston";
        search.sendKeys(searchText);
        WebElement checkBox = careerPage.getCheckBox();
        checkBox.click();
        search.sendKeys(Keys.ENTER);
        searchResult = careerPage.getSearchResult();
        for (int i = 0; i < searchResult.size(); i++) {
            WebElement link = searchResult.get(i);
            String newlink = link.getText().split("\n")[0];
            if (!newlink.contains(searchText)) {
                softAssert.assertEquals(newlink, searchText);
            }
        }
    }
}