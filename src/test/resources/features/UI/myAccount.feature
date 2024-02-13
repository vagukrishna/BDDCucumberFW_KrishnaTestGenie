Feature: My Account page

  Background:
    Given I am on the Opencart login page

  Scenario Outline: Verify my account page
    Given Verifying the testcase from excelTest Data <TestID> and <SheetName>
    Given I have entered valid credentials
    When I click on Login button
    Then I should see Recurring Payments link

    Examples:
      | TestID    | SheetName |
      | TestApp01 | LoginData |
      | TestApp02 | LoginData |