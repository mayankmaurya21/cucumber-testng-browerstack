package appium_android;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class StepDefsAndroid {

    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME"); //OR String USERNAME = "<browserstack-username>"
    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");//OR String AUTOMATE_KEY = "<browserstack-accesskey>"
    DesiredCapabilities caps;
    public AndroidDriver<AndroidElement> driver;

    @Given("Open Application on device one")
    public void open_Application_on_device_one() throws MalformedURLException  {
    
    caps = new DesiredCapabilities();
    caps.setCapability("device", "Samsung Galaxy Note 20");
    caps.setCapability("os_version", "10.0");
    caps.setCapability("build", "cucumber-java-testng-browserstack");
    caps.setCapability("name", "android_test_two");
    caps.setCapability("app","bs://<app-hashid>");
    driver = new AndroidDriver<AndroidElement>(new URL("http://"+USERNAME+":"+AUTOMATE_KEY+"@hub-cloud.browserstack.com/wd/hub"), caps);
}

@Given("Open Application on device two")
public void open_Application_on_device_two() throws MalformedURLException  {
 
    caps = new DesiredCapabilities();
    caps.setCapability("device", "Google Pixel 3");
    caps.setCapability("os_version", "9.0");
    caps.setCapability("build", "cucumber-java-testng-browserstack");
    caps.setCapability("name", "android_test_one");
    caps.setCapability("app","bs://<app-hashid>");
    driver = new AndroidDriver<AndroidElement>(new URL("http://"+USERNAME+":"+AUTOMATE_KEY+"@hub-cloud.browserstack.com/wd/hub"), caps);
}
    @When("Search for BrowserStack")
    public void search_for_BrowserStack() throws InterruptedException {
        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);

        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        assert(allProductsName.size() > 0);
    }

    @Then("Return result and close application")
    public void return_Result_And_Close_Application(){
        driver.quit();
    }

}
