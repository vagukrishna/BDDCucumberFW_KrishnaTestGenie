package AppHooks;


import Utilities.ConfigReader;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.util.Map;
import java.util.Properties;


public class Hooks{

        private DriverFactory driverFactory;
        private WebDriver driver;
        private ConfigReader configReader;
        private Properties prop;


        @Before(order=0,value = "@Skip_scenario")
        public void skip_scenario(Scenario scenario)
        {
            System.out.println("Skipped Scenario is "+ scenario.getName());
            Assume.assumeTrue(false);
        }

        @Before(order=1)
        public void getProperty()
        {
            configReader=new ConfigReader();
            prop=configReader.init_prop();

        }

         @Before(order = 2)
        public void launchBrowser()
        {
            String browserName=prop.getProperty("browser");
            driverFactory=new DriverFactory();
            driver=driverFactory.init_driver(browserName);
        }


        @After(order = 0)
        public void quitBrowser()
        {
            driver.quit();
        }
        @After(order = 1)
        public void tearDown(Scenario scenario)
        {
            if (scenario.isFailed())
            {
                //take screenshot
                String screenshotName=scenario.getName().replaceAll(" ","_");
                byte[] sourcePath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(sourcePath,"image/png",screenshotName);
            }

        }


    }


