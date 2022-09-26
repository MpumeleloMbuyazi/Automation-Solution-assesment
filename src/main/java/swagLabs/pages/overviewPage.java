package swagLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class overviewPage {

    //Webdriver Instance
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "div.page_wrapper div:nth-child(1) div.checkout_summary_container div:nth-child(1) div.summary_info > div.summary_total_label:nth-child(7)")
    private WebElement totalPrice;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(xpath = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")
    private WebElement orderConfirmation;

    public overviewPage(WebDriver driver){

        this.driver = driver;
        //New instance of the Webdriver Wait. Waits for 30 seconds
        this.wait = new WebDriverWait(driver, 30);
        //Initialize page objects
        PageFactory.initElements(driver, this);

    }

    public String priceVerification(){

        //Wait for element to be visible
        this.wait.until(ExpectedConditions.visibilityOf(this.totalPrice));
        //Enter username and password

        String price = this.totalPrice.getText();
        System.out.println(this.totalPrice.getText());
        this.finishBtn.click();

        return price;

    }
    public String checkoutConfirmation (){

        this.wait.until(ExpectedConditions.visibilityOf(this.orderConfirmation));
        String confirmationMsg = this.orderConfirmation.getText();
        System.out.println(this.orderConfirmation.getText());

        return confirmationMsg;

    }
}
