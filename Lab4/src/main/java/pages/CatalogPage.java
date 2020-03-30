package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage {

    @FindBy(xpath = "//*[@id=\"ember39\"]")
    WebElement inputSearch;
    @FindBy(xpath = "//*[@id=\"ember35\"]/form/button")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"ember35\"]/form/button[1]")
    WebElement closeButton;
    @FindBy(xpath = "//*[@id=\"ember34\"]")
    WebElement registration;
    @FindBy(xpath = "//*[@id=\"ember47\"]/span")
    WebElement newKurs;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[3]/nav/div[1]/ul/li[1]/a")
    WebElement head;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/main/section/div/div[1]/div/ul/li[1]/div/div/div[2]/a")
    WebElement linkSearch;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/header/div/div/a[2]")
    WebElement link;

    WebDriver driver;
    public CatalogPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void createKurs(){
        newKurs.click();
    }

    public void newUser(){
        registration.click();
    }

    public void search(String text){
        inputSearch.sendKeys(text);
        searchButton.submit();
        closeButton.click();

    }

    public String getHead(){
        return head.getText().toLowerCase();
    }





}