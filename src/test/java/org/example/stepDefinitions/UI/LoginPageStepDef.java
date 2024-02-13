package org.example.stepDefinitions.UI;

import Utilities.ConfigReader;
import Utilities.Utils;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AccountPage;
import pages.OpenCartLoginPage;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class LoginPageStepDef {

    private WebDriver webDriver=DriverFactory.getDriver();
    private OpenCartLoginPage loginPage=new OpenCartLoginPage(webDriver);
    private AccountPage accountPage;
    private ConfigReader configReader = new ConfigReader();
    private Properties properties=configReader.init_prop();
    private Utils utils=new Utils(webDriver);
    private List<Map<String, String>> testData;



    @Given("Verifying the testcase from excelTest Data {} and {}")
    public void verifyingTheTestcaseFromExcelTestDataAnd(String testID, String sheetName) {

        testData=utils.getExcelTestData(testID,sheetName);

    }

       @Given("I am on the Opencart login page")
    public void iam_on_the_loginpage() {

           utils.launchApp();

    }

       @When("I click on Login button")
    public void clickLoginButton() {

        accountPage=loginPage.clickLoginButton();

    }

    @Then("I should be logged in successfully")
    public void verify_login() {
        boolean result = loginPage.verifyLogin();
       Assert.assertEquals(result, true);
    }


    @Given("I have clicked on Forgot password link")
    public void iHaveClickedOnForgotPasswordLink() {

           loginPage.clickForgotPasswordLink();
    }

    @Then("I should see Email text field")
    public void iShouldSeeEmailTextField() {


    }

    @Given("I have entered valid credentials")
    public void iHaveEnteredValidCredentials() {

        loginPage.doLogin(testData.get(0).get("UserName"),testData.get(0).get("Password"));
        //loginPage.doLogin("teja4uindia@gmail.com","test@123");
    }





}
