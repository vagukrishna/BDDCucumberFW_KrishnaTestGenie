package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/features/UI/myAccount.feature"},glue={"org/example/stepDefinitions/UI","AppHooks"},
                        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                                "timeline:test-output-thread","rerun:target/failedRerun.txt"},
        monochrome = true,//tags = "not @Skip",
        publish = true)


public class TestRunnerTestNG extends AbstractTestNGCucumberTests {


    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
