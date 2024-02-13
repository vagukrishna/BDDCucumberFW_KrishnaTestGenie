package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Synchronized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();

    public WebDriver init_driver(String browser)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();

        return getDriver();


    }

    public static synchronized WebDriver getDriver()
    {

        return tlDriver.get();

    }



}
