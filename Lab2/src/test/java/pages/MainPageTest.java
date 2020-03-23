package pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


@Category(SmokeTest.class)
public class MainPageTest {

    WebDriver driver;
    MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\VSTU\\3 kurs 6 sem\\tests\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://welcome.stepik.org/ru");
        mainPage = new MainPage(driver);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("stepik");
            } });
    }

    @Test //проверка кнопки "посмотреть католог"
    public void TestClickCatalog(){
       CatalogPage catalogPage = mainPage.clickCatalog();
       (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("каталог");
            } });
        String heading = catalogPage.getHead();
        System.out.println("Page title is: " + catalogPage.getHead());
        Assert.assertEquals("каталог", heading);
    }


    @Test //проверка надписи на странице
    public void TestHeadTrue(){
        String head = mainPage.headingText();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("stepik");
            } });
        System.out.println("Page title is: " + mainPage.headingText());
        Assert.assertEquals("онлайн-курсы от ведущих вузов и компаний страны", head);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
