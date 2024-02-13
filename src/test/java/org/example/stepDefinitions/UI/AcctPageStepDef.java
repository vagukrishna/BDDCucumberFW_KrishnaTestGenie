package org.example.stepDefinitions.UI;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import pages.AccountPage;

public class AcctPageStepDef {

    private AccountPage accountPage=new AccountPage(DriverFactory.getDriver());


    @Then("I should see Recurring Payments link")
    public void iShouldSeeRecurringPaymentsLink() {
        accountPage.isRecurringPaymentsExits();
    }
}
