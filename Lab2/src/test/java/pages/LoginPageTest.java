package pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@Category(SmokeTest.class)
public class LoginPageTest {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\VSTU\\3 kurs 6 sem\\tests\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stepik.org/catalog?auth=login");

        loginPage = new LoginPage(driver);
       (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("каталог");
            } });
    }

    @Test //проверка ввода неверного логина и пароля
    public void loginAndPassword(){
        loginPage.inputLogin("koval_yana99@mail.ru","12536");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Error: " + loginPage.getError());
        Assert.assertEquals("E-mail адрес и/или пароль не верны.",loginPage.getError());
    }

    @Test //проверка кнопки "напомнить пароль"
    public void remindPassword(){
        loginPage.forgot();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement link = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div/div/div/div/form/h3"));
        Assert.assertEquals("Забыли свой пароль?", link.getText());
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
