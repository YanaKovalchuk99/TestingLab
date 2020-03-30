package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div[1]/div/div/div/form/div[1]/input[1]")
    WebElement login;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div[1]/div/div/div/form/div[1]/input[2]")
    WebElement password;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div[1]/div/div/div/form/button")
    WebElement comeIn;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div[1]/div/div/div/form/div[2]/a")
    WebElement forgotPassword;
    @FindBy(xpath = "//*[@id=\"ember468\"]")
    WebElement registration;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div[1]/div/div/div/form/ul/li")
    WebElement error;
    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[4]/div/div/div/div[2]/div/div/div/div/div/div/form/h3")
    WebElement link;


    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public LoginPage username(String username){
        login.sendKeys(username);
        return this;
    }

    public LoginPage passwordIn(String pass){
        password.sendKeys(pass);
        return this;
    }

    public void inputLogin(String username, String pass){
        this.username(username);
        this.passwordIn(pass);
        comeIn.click();
    }

    public String getError(){
        return error.getText();
    }

    public void forgot(){
        forgotPassword.click();
    }
}
