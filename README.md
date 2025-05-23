
📱 Trust Wallet Automation Framework

This project automates the onboarding flow of the Trust Wallet app using Appium, Java, TestNG, and Gradle with rich reporting via ExtentReports.

📦 Project Tech Stack

- Language: Java
- Automation Tool: Appium (UIAutomator2)
- Build Tool: Gradle
- Test Framework: TestNG
- Reporting: ExtentReports
- Design Pattern: Page Object Model (POM)

🚀 **Project Structure**

<img width="859" alt="Screenshot 2025-05-23 at 10 32 15 PM" src="https://github.com/user-attachments/assets/0c649c1b-8d35-4f8d-913b-be1ed4e158b0" />



   

🔧 **Appium Driver Initialization**

public static void initializeDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("app", System.getProperty("user.dir") + "/resources/apps/trustWallet.apk");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "Pixel3A");
    capabilities.setCapability("automationName", "UiAutomator2");

    try {
        driver = new AppiumDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
    } catch (MalformedURLException e) {
        throw new RuntimeException("Appium server URL is invalid", e);
    }
}


🧪 **TestNG Groups + Retry**

@Test(groups = {"onboarding"})
public void testCreateWallet() { ... }

**testng.xml:**
<img width="674" alt="Screenshot 2025-05-23 at 10 33 25 PM" src="https://github.com/user-attachments/assets/c03135af-1b89-40d9-a40b-510bd4fb3a5e" />



📸 **Screenshots in Extent Reports**

public static String captureScreenshot(WebDriver driver, String name) {
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    String path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
    FileUtils.copyFile(source, new File(path));
    return path;
}


📊 **Logging in ExtentReports**

ExtentTest test = ExtentManager.createTest("Verify Trending Page");
test.info("Launching app");
test.pass("Successfully navigated");
test.fail("Something went wrong");

🏁 **Running the Tests**

**./gradlew clean test**

**Or run via IntelliJ by right-clicking testng.xml.**

🧰 Troubleshooting

❌ Screenshot error: "unable to capture screen: view has secure flag"

Trust Wallet uses Android’s FLAG_SECURE, preventing screenshots of certain screens. You’ll need to skip screenshot steps on such views or conditionally handle them in code.

❌ SessionNotCreatedException

Check:
- Appium server is running
- APK path is correct
- Device/emulator is connected
- Port 4725 is open and matches Appium's port

📩 Contact

For contributions, raise a PR or contact the framework maintainer.

Report screenshot 
<img width="1490" alt="Screenshot 2025-05-23 at 10 24 23 PM" src="https://github.com/user-attachments/assets/e63d36ea-c43d-452a-b50a-1ff6d74939e4" />


