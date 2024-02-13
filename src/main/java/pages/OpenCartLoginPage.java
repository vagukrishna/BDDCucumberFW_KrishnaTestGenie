package pages;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class OpenCartLoginPage {

    //WebElements Xpaths
    private By emailInputLocator= By.name("email");
    private By passwordInputLocator= By.name("password");
    private By loginButtonLocator= By.xpath("//input[@type='submit']");
    private By logoutButtonLocator= By.linkText("Logout");
    private By linkForgotPassword=By.xpath("(//a[contains(text(),'Forgotten Password')])[1]");

    private WebDriver driver;
    private Utils utils;

    //Constructor
    public OpenCartLoginPage(WebDriver driver)
    {
        this.driver=driver;
        utils=new Utils(driver);
    }

    public void doLogin(String email, String password){

        utils.typeTextIntoElement(emailInputLocator,email);
        utils.typeTextIntoElement(passwordInputLocator,password);


    }

    public void clickForgotPasswordLink()
    {

        utils.clickElement(linkForgotPassword);
    }



    public AccountPage clickLoginButton()
    {
        utils.clickElement(loginButtonLocator);
                try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
                return new AccountPage(driver);
    }

    public boolean verifyLogin()
    {
        WebElement btnLogout=driver.findElement(logoutButtonLocator);
        if(btnLogout.isDisplayed()) {
            System.out.println("pass");
            return true;
        }
        else
        System.out.println("fail");
            return false;
    }


}
