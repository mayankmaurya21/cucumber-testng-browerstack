package appium_android;

import cucumber.api.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(plugin = {"pretty"},
        features = "src/test/resources/appium_android/androidFeature.feature",
        glue = "appium_android")

public class RunCucumberAndroidTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
