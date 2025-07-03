package pageObjects;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;

public class HandlingDynamicElements extends PageObject {
    Logger logger = LoggerFactory.getLogger(getClass());

    @FindBy (xpath = "//div[@id='w-dropdown-toggle-0']/div[text()='Products']")
    private WebElement product;

    @FindBy(xpath = "//div[@class='dropdown_tab-pane w-tab-pane w--tab-active']//a")
    private List<WebElement> dynamic_links;

    @FindBy(xpath = "//h1[text()='Message Center']")
    private WebElement messagecentre;

    public HandlingDynamicElements productTab()
    {
        Actions act = new Actions(getDriver());
        waitFor(product).waitUntilVisible();
        act.moveToElement(product).perform();;
        logger.info("Hovered on Product Tab");
        return this;
    }

    public void handlingLinks(String linkName){

        for(int i=0; i<dynamic_links.size();i++){
            String name = dynamic_links.get(i).getText();
            if(linkName.equals(name)){
                waitFor(dynamic_links.get(i)).waitUntilClickable();
                dynamic_links.get(i).click();
                logger.info("Clicked on Message Centre");
            }
        }
    }

    public boolean isMessageCentreDisplayed(){
        waitFor(messagecentre).waitUntilVisible();
        String actualText = messagecentre.getText().trim();
        return actualText.contains("Message Center");
    }
}
