package pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;

    @Given("^Open login page$")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\VSTU\\3 kurs 6 sem\\tests\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stepik.org/catalog?auth=login");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("каталог");
            } });
    }

    @When("User enters login (.+) and password (.+)$")
    public void loginAndPassword(String login, String password){
        loginPage.inputLogin(login,password);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Then("^Error message$")
    public void messageError(){
        System.out.println("Error: " + loginPage.getError());
        Assert.assertEquals("E-mail адрес и/или пароль не верны.",loginPage.getError());
    }

    @When("^User forgot password$")
    public void remindPassword(){
        loginPage.forgot();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Then("^Password recovery page$")
    public void recoveryPage(){
        Assert.assertEquals("Забыли свой пароль?", loginPage.link.getText());
    }

    @Then("^Close login page$")
    public void tearDown(){
        driver.quit();
    }


}
