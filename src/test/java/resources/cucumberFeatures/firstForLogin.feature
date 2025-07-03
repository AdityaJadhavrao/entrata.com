@Entrata @Regression
Feature: Entrata User Journey Automation

  As a user visiting the Entrata website,
  I want to verify the core user journeys such as Sign In, Watch Demo form, and Product navigation
  So that I can ensure key functionalities are working as expected

  @Login @Smoke
  Scenario: User signs in from the Entrata homepage
    Given the user launches the Entrata homepage
    When the user clicks on the Sign In button
    Then the user should be redirected to the Sign In page
    And the Property Manager login button should be visible

  @WatchDemo @Regression
  Scenario: User fills out the Watch Demo form with valid data
    Given the user navigates to the Watch Demo form
    When the user enters all required information

  @ProductTab @Regression
  Scenario: User hovers over the Products tab and clicks a dynamic link
    Given the user hovers over the Products tab
    When the user clicks on the "Message Center" link
    Then the relevant Message Center page should be displayed
