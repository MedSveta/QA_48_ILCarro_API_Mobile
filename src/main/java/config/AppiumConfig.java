package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {
    public static AppiumDriver<AndroidElement> driver;
    public static int height = 0, width = 0;

    @BeforeMethod
    public void setup(){
//        "platformName": "Android",
//        "deviceName": "Pixel",
//        "platformVersion": "8.0",
//         "appPackage": "com.telran.ilcarro",
//         "appActivity": ".SplashActivity"

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Pixel");
        desiredCapabilities.setCapability("platformVersion", "8.0");
        desiredCapabilities.setCapability("appPackage", "com.telran.ilcarro");
        desiredCapabilities.setCapability("appActivity", ".SplashActivity");

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

        String url = "http://localhost:4723/wd/hub";
        try {
            driver = new AppiumDriver<>(new URL(url), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        height = driver.manage().window().getSize().getHeight();
        width = driver.manage().window().getSize().getWidth();
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();
    }
}
