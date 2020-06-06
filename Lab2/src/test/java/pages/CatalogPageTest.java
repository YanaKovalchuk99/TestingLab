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
public class CatalogPageTest {
    WebDriver driver;
    CatalogPage catalogPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\VSTU\\3 kurs 6 sem\\tests\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stepik.org/catalog?verb");
        catalogPage = new CatalogPage(driver);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("каталог");
            } });

    }

    @Test  //проверка поиска в каталоге
    public void searchOnCatalog(){
        catalogPage.search("математика");

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("/html/body/div/div[1]/div[2]/main/section/div/div[1]/div"
                                              +"/ul/li[1]/div/div/div[2]/a")).getText().toLowerCase().startsWith("базовый");
            } });
        WebElement link = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/main/section"
                                                      +"/div/div[1]/div/ul/li[1]/div/div/div[2]/a"));
        Assert.assertEquals("Базовый курс подготовки к ОГЭ по математике", link.getText());

    }

    @Test //проверка кнопки "регистрация"
    public void toComeIn(){

        catalogPage.newUser();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[4]"+
                         "/div/div/div/div[2]/div/div/header/div/div/a[2]")).getText().toLowerCase().startsWith("регистрация");
            } });

        WebElement link = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]"
                                                      +"/div[4]/div/div/div/div[2]/div/div/header/div/div/a[2]"));
        Assert.assertEquals("Регистрация", link.getText());

    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
