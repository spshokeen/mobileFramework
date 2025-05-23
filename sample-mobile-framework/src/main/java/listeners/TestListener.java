package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    public static ExtentReports extent = initExtentReports();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private static ExtentReports initExtentReports() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Test-Report-" + timeStamp + ".html";

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/" + reportName);
        htmlReporter.config().setDocumentTitle("Trust Wallet Automation Report");
        htmlReporter.config().setReportName("Functional Testing");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", System.getProperty("user.name"));

        return extent;
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED", ExtentColor.GREEN));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
        test.get().fail(result.getThrowable());

        String screenshotPath = captureScreenshot(result.getName());
        if (!screenshotPath.isEmpty()) {
            String relativePath = screenshotPath.substring(screenshotPath.indexOf("test-output"));
            try {
                test.get().addScreenCaptureFromPath(relativePath);
            } catch (Exception e) {
                test.get().log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.ORANGE));
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public static String captureScreenshot(String screenshotName) {
        try {
            AppiumDriver driver = DriverUtils.getDriver();
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String dirPath = System.getProperty("user.dir") + "/test-output/screenshots/";
            File screenshotDir = new File(dirPath);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs(); // create folders if not exist
            }

            String screenshotPath = dirPath + screenshotName + "_" + timestamp + ".png";
            FileUtils.copyFile(source, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
            return "";
        }
    }
}
