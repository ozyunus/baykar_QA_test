import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    static WebDriver driver;
    static Actions action;
    static SoftAssert softAssert;
    NavbarPage navbarPage;
    CareerPage careerPage;

    LanguagePage languagePage;
    List<WebElement> navBar;
    WebElement language;
    WebElement career;

    @BeforeClass
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        navbarPage =new NavbarPage(driver);
        languagePage =new LanguagePage(driver);
        careerPage =new CareerPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.baykartech.com/tr/");
        driver.manage().window().maximize();
        action = new Actions(driver);
        softAssert = new SoftAssert();
        navBar = navbarPage.getNavBar();

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
        softAssert.assertAll();
    }

}
