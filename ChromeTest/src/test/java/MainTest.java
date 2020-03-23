import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class MainTest {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\VSTU\\3 kurs 6 sem\\tests\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com");
    }

    @Test
    public void testChrome(){
        try{
            WebElement input = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
            input.sendKeys("aeroflot");
            input.submit();


            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("aeroflot");
                } });

            WebElement link = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a"));


            assertEquals("www.aeroflot.ru", link.getText());
        }
        catch (Error e){

            verificationErrors.append(e.toString());
        }

    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
