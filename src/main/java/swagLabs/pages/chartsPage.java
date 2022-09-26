package swagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class chartsPage {

    //Webdriver Instance
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public chartsPage(WebDriver driver){

        this.driver = driver;
        //New instance of the Webdriver Wait. Waits for 30 seconds
        this.wait = new WebDriverWait(driver, 30);
        //Initialize page objects
        PageFactory.initElements(driver, this);

    }

    public void checkOut(){

        //Wait for element to be visible
        this.wait.until(ExpectedConditions.visibilityOf(this.checkoutBtn));
        //Enter username and password
        this.checkoutBtn.click();

    }
}
