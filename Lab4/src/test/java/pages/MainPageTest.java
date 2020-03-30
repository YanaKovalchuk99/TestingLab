package pages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    WebDriver driver;
    MainPage mainPage;
    String head;

    @Given("^Open main page$")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\VSTU\\3 kurs 6 sem\\tests\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://welcome.stepik.org/ru");
        mainPage = PageFactory.initElements(driver, MainPage.class);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("stepik");
            } });
    }

    @When("^Page text received$")
    public void TestHeadTrue(){
        head = mainPage.headingText();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("stepik");
            } });

    }

    @Then("^Page text is no different from (.+)$")
    public void trueMessage(String expected){
        System.out.println("Page title is: " + mainPage.headingText());
        Assert.assertEquals(expected, head);
    }

    @When("^User clicks directory button$")
    public void TestClickCatalog(){
        mainPage.clickCatalog();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("каталог");
            } });
    }

    @Then("^Go to catalog page$")
    public void openCatalog(){
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("Каталог – Stepik", driver.getTitle());
    }


    @Then("^Close main page$")
    public void tearDown(){
        driver.quit();
    }

}
