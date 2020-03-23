package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage {

    WebDriver driver;
    public CatalogPage(WebDriver driver)
    {
        this.driver = driver;
    }


    private By inputSearch = By.xpath("//*[@id=\"ember39\"]");
    private By searchButton = By.xpath("//*[@id=\"ember35\"]/form/button");
    private By closeButton = By.xpath("//*[@id=\"ember35\"]/form/button[1]");
    private By registration = By.xpath("//*[@id=\"ember34\"]");
    private By newKurs = By.xpath("//*[@id=\"ember47\"]/span");
    private By head = By.xpath("/html/body/div/div[1]/div[2]/div[3]/nav/div[1]/ul/li[1]/a");

    public void createKurs(){
        driver.findElement(newKurs).click();
    }

    public void newUser(){
       driver.findElement(registration).click();
    }

    public void search(String text){
        driver.findElement(inputSearch).sendKeys(text);
        driver.findElement(searchButton).submit();
        driver.findElement(closeButton).click();

    }

    public String getHead(){
        return driver.findElement(head).getText().toLowerCase();
    }


}
