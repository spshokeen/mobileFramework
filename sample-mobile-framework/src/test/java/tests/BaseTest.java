package tests;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import listeners.TestListener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.DriverUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Listeners(TestListener.class)
public class BaseTest {

    protected AppiumDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverUtils.initializeDriver();
        driver = DriverUtils.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        DriverUtils.quitDriver();
    }

    public  ExtentTest getLogger() {
        return TestListener.test.get();
    }



}
