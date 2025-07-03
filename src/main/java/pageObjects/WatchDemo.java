package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.Select;


public class WatchDemo extends PageObject{

 Logger logger = LoggerFactory.getLogger(getClass());
 
    @FindBy(xpath="//div[@class='nav_buttons']/a[@href='/demo']")
    private WebElement watchDemoButton;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='Company']")
    private WebElement company;

    @FindBy(xpath = "//input[@id='Phone']")
    private WebElement phone;

    @FindBy(xpath = "//select[@id='Unit_Count__c']")
    private WebElementFacade totalManagedUnits;

    @FindBy(xpath = "//input[@id='Title']")
    private WebElement jobTitile;



    public WatchDemo click_watchDemo_button() {
        waitFor(watchDemoButton).waitUntilClickable();
        clickOn(watchDemoButton);
        logger.info("Clicked on Watch Demo button");
        return this;
    }

    public WatchDemo userDetails(){
        waitFor(firstName).waitUntilVisible();
        firstName.sendKeys(ConfigReader.get("FirstName"));

        waitFor(lastName).waitUntilVisible();
        lastName.sendKeys(ConfigReader.get("LastName"));

        waitFor(email).waitUntilVisible();
        email.sendKeys(ConfigReader.get("Email"));

        waitFor(company).waitUntilVisible();
        company.sendKeys(ConfigReader.get("CompanyName"));
        
        waitFor(phone).waitUntilVisible();
        phone.sendKeys(ConfigReader.get("PhoneNumber"));

        Select units = new Select(totalManagedUnits);
        units.selectByIndex(4);

        waitFor(jobTitile).waitUntilVisible();
        jobTitile.sendKeys(ConfigReader.get("JobTitile"));

        logger.info("Entered the user details");

        return this;
        
    }


}
