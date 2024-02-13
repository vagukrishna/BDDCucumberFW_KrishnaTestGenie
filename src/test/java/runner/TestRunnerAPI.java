package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"src/test/resources/features/API/validateAddPlaceAPI.feature"},glue={"org/example/stepDefinitions/API"},
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread","rerun:target/failedRerun.txt"},
        monochrome = true,
        publish = true)

public class TestRunnerAPI extends AbstractTestNGCucumberTests {


    @DataProvider(parallel = false)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
