package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;
     public MainPage(WebDriver driver)
     {
         this.driver = driver;
     }



    private By catalogButton = By.xpath("//*[@id=\"rec38468694\"]/div/div/div[4]/a");
    private By learnButton = By.xpath("//*[@id=\"nav38468658\"]/div/div[4]/div/div[1]/div/div[1]/a");
    private By authorButton = By.xpath("//*[@id=\"nav38468658\"]/div/div[4]/div/div[1]/div/div[2]/a");
    private By heading = By.xpath("//*[@id=\"rec38468694\"]/div/div/div[5]/div");

     public CatalogPage clickCatalog(){
         driver.findElement(catalogButton).click();
         return new CatalogPage(driver);
     }


    public void clickLearn(){
        driver.findElement(learnButton).click();
    }

    public void clickAuthor(){
         driver.findElement(authorButton).click();
    }

    public String headingText(){
         return driver.findElement(heading).getText().toLowerCase();
    }


}
