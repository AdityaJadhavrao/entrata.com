package pageObjects;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends PageObject {
    Logger logger = LoggerFactory.getLogger(getClass());

    @FindBy(xpath = "//div[@class='nav_buttons']/a[text()='Sign in']")
    WebElementFacade signInButton;

    public LoginPage clickOnTheSignInButton()  {
        waitFor(signInButton).waitUntilClickable();
        clickOn(signInButton);
        logger.info("Clicking signIn button");
        return this;
    }

    public boolean verifyPropertyManagerLogin(){
      return find(By.xpath("//div[@class='button-group']/a[@data-wf--button--style='primary']")).isVisible();
    }
}

