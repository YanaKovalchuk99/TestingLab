package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }


    private By login = By.xpath("/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div[1]/div/div/div/form/div[1]/input[1]");
    private By password = By.xpath("/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div[1]/div/div/div/form/div[1]/input[2]");
    private By comeIn = By.xpath("/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div[1]/div/div/div/form/button");
    private By forgotPassword = By.xpath("/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div[1]/div/div/div/form/div[2]/a");
    private By registration = By.xpath("//*[@id=\\\"ember468\\\"]");
    private By error = By.xpath("/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div[1]/div/div/div/form/ul/li");

    public LoginPage username(String username){
        driver.findElement(login).sendKeys(username);
        return this;
    }

    public LoginPage passwordIn(String pass){
        driver.findElement(password).sendKeys(pass);
        return this;
    }

    public void inputLogin(String username, String pass){
        this.username(username);
        this.passwordIn(pass);
        driver.findElement(comeIn).click();
    }

    public String getError(){
        return driver.findElement(error).getText();
    }

    public void forgot(){
        driver.findElement(forgotPassword).click();
    }


}
