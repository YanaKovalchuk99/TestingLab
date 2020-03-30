package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(xpath = "//*[@id=\"rec38468694\"]/div/div/div[4]/a")
    WebElement catalogButton;
    @FindBy(xpath = "//*[@id=\"nav38468658\"]/div/div[4]/div/div[1]/div/div[1]/a")
    WebElement learnButton;
    @FindBy(xpath = "//*[@id=\"nav38468658\"]/div/div[4]/div/div[1]/div/div[2]/a")
    WebElement authorButton;
    @FindBy(xpath = "//*[@id=\"rec38468694\"]/div/div/div[5]/div")
    WebElement heading;


    private WebDriver driver;

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickCatalog(){
        catalogButton.click();

    }


    public void clickLearn(){
        learnButton.click();
    }

    public void clickAuthor(){
        authorButton.click();
    }

    public String headingText(){
        return heading.getText().toLowerCase();
    }


}
