package pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPageTest {
    WebDriver driver;
    CatalogPage catalogPage;



    @Given("^Open catalog page$")
    public void openCatalogPage(){
        System.setProperty("webdriver.chrome.driver", "D:\\VSTU\\3 kurs 6 sem\\tests\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stepik.org/catalog?verb");
        catalogPage = PageFactory.initElements(driver, CatalogPage.class);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("каталог");
            } });
    }

    @When("^User search (.+) in the directory$")
    public void searchOnCatalog(String word){
        catalogPage.search(word);

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("/html/body/div/div[1]/div[2]/main/section/div/div[1]/div/ul/li[1]/div/div/div[2]/a")).getText().toLowerCase().startsWith("базовый");
            } });

       System.out.println("Link name is: " + catalogPage.linkSearch.getText());

    }

    @Then("^Search check$")
    public void SearchTest()
    {
        Assert.assertEquals("Базовый курс подготовки к ОГЭ по математике", catalogPage.linkSearch.getText());
    }

    @When("^User clicks registration button$")
    public void toComeIn(){
        catalogPage.newUser();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/header/div/div/a[2]")).getText().toLowerCase().startsWith("регистрация");
            } });

        System.out.println("Page title is: " + catalogPage.link.getText());

    }

    @Then("^Registration check$")
    public void TestRegistration(){
        Assert.assertEquals("Регистрация", catalogPage.link.getText());
    }


    @Then("^Close catalog page$")
    public void tearDown(){
        driver.quit();
    }
}
