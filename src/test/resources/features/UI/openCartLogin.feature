Feature: OpenCart Login

 Background:
  Given I am on the Opencart login page

 Scenario: User logs in successfully with valid credentials
  Given I have entered a valid credentials
  When I click on Login button
  Then I should be logged in successfully

  @Skip_scenario
  Scenario: Forgot Password link is working
   Given I have clicked on Forgot password link
   Then I should see Email text field








