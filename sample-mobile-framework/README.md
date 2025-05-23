
📱** Trust Wallet Automation Framework**

This project automates the onboarding flow of the Trust Wallet app using Appium, Java, TestNG, and Gradle with rich reporting via ExtentReports.

📦 Project Tech Stack

- Language: Java
- Automation Tool: Appium (UIAutomator2)
- Build Tool: Gradle
- Test Framework: TestNG
- Reporting: ExtentReports
- Design Pattern: Page Object Model (POM)

🚀 Project Structure

src/
  ├── main/
  │   └── java/
  │       └── pages/                   # All page classes (e.g. OnboardingPage, HomePage)
  ├── test/
  │   └── java/
  │       └── tests/                   # All test classes (e.g. TrustWalletOnboardingTest)
  │       └── listeners/              # RetryListener etc.
resources/
  └── apps/trustWallet.apk            # App under test
testng.xml                            # TestNG suite file

🔧 Appium Driver Initialization

public static void initializeDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("app", System.getProperty("user.dir") + "/resources/apps/trustWallet.apk");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "Pixel3A");
    capabilities.setCapability("automationName", "UiAutomator2");

    try {
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    } catch (MalformedURLException e) {
        throw new RuntimeException("Appium server URL is invalid", e);
    }
}





🧪** TestNG Groups + Retry**

@Test(groups = {"onboarding"})
public void testCreateWallet() { ... }

**testng.xml:**

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Trust wallet Test Suite" parallel="classes" thread-count="2">
    <listeners>
        <listener class-name="listeners.RetryListener"/>
    </listeners>
    <test name="Trust Wallet Onboarding Test">
        <groups>
            <run>
                <include name="onboarding"/>
            </run>
        </groups>
        <classes>
            <class name="tests.TrustWalletOnboardingTest"/>
        </classes>
    </test>
</suite>

📸** Screenshots in Extent Reports**

public static String captureScreenshot(WebDriver driver, String name) {
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    String path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
    FileUtils.copyFile(source, new File(path));
    return path;
}

test.fail("Step failed",
    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

📊** Logging in ExtentReports**

ExtentTest test = ExtentManager.createTest("Verify Trending Page");
test.info("Launching app");
test.pass("Successfully navigated");
test.fail("Something went wrong");

🏁** Running the Tests**

./gradlew clean test

Or run via IntelliJ by right-clicking testng.xml.

🧰** Troubleshooting**

❌ Screenshot error: "unable to capture screen: view has secure flag"

Trust Wallet uses Android’s FLAG_SECURE, preventing screenshots of certain screens. You’ll need to skip screenshot steps on such views or conditionally handle them in code.

❌ SessionNotCreatedException

Check:
- Appium server is running
- APK path is correct
- Device/emulator is connected
- Port 4723 is open and matches Appium's port

📩 Contact

For contributions, raise a PR or contact the framework maintainer.

