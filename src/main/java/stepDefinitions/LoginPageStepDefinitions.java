package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import net.thucydides.core.annotations.Steps;
import pageObjects.HandlingDynamicElements;
import pageObjects.LoginPage;
import pageObjects.WatchDemo;

public class LoginPageStepDefinitions {

    @Steps
    LoginPage loginPage;

    @Steps
    WatchDemo watchDemo;

    @Steps
    HandlingDynamicElements dynamicElements;

    // TC01
    @Given("the user launches the Entrata homepage")
    public void user_launches_entrata_homepage() {
        loginPage.open();
    }

    @When("the user clicks on the Sign In button")
    public void user_clicks_sign_in_button() {
        loginPage.clickOnTheSignInButton();
    }

    @Then("the user should be redirected to the Sign In page")
    public void user_is_redirected_to_sign_in_page() {
        String expectedURL = "https://www.entrata.com/sign-in";
        String actualURL = loginPage.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);
    }

    @Then("the Property Manager login button should be visible")
    public void property_manager_button_is_visible() {
        Assert.assertTrue(loginPage.verifyPropertyManagerLogin());
    }

    // TC02
    @Given("the user navigates to the Watch Demo form")
    public void user_navigates_to_watch_demo() {
        watchDemo.open();
    }

    @When("the user enters all required information")
    public void user_enters_demo_details() {
        watchDemo.click_watchDemo_button();
        watchDemo.userDetails();
    }

    // TC03
    @Given("the user hovers over the Products tab")
    public void user_hovers_on_product_tab() {
        dynamicElements.open();
        dynamicElements.productTab();
    }

    @When("the user clicks on the {string} link")
    public void user_clicks_on_dynamic_link(String linkName) {
        dynamicElements.handlingLinks(linkName);
    }

    @Then("the relevant Message Center page should be displayed")
    public void message_center_page_displayed() {
        Assert.assertTrue("Message centre text was not displayed", dynamicElements.isMessageCentreDisplayed());
        
    }
}
