package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private WebDriver driver;

    public AccountPage(WebDriver driver)
    {
        this.driver=driver;
    }
    private By linkRecurringPayments=By.xpath("(//a[contains(text(),'Recurring payments')])[1]");



    public void isRecurringPaymentsExits()
    {
        boolean flag=driver.findElement(linkRecurringPayments).isDisplayed();
        if(flag==true) {
            System.out.println("pass");

        }
        else
            System.out.println("fail");


    }


}
