package utils.waits;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.ios.options.XCUITestOptions;
import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MobileDriverWaiter implements Waiter<WebElement> {

        private final AppiumDriver driver;
        private final AppiumFluentWait<AppiumDriver> waiter;
        @Getter
        private long timeout = 5;

        /**
         * Initializes with default timeout 5 seconds
         *
         * @param driver The appium driver instance.
         */
    public MobileDriverWaiter(AppiumDriver driver) {
            this.driver = driver;
            this.waiter = new AppiumFluentWait<>(driver);
            this.waiter.withTimeout(Duration.ofSeconds(timeout));
        }

    public MobileDriverWaiter(AppiumDriver driver, int seconds) {
            this.driver = driver;
            this.waiter = new AppiumFluentWait<>(driver);
            this.timeout = seconds;
            this.waiter.withTimeout(Duration.ofSeconds(this.timeout));
        }

        public MobileDriverWaiter withTimeout(Duration timeout) {
            this.waiter.withTimeout(timeout);
            this.timeout = timeout.getSeconds();
            return this;
        }

        public MobileDriverWaiter ignoring(Class<? extends Throwable> exceptions) {
            return ignoringAll(List.of(exceptions));
        }

        public MobileDriverWaiter ignoringAll(List<Class<? extends Throwable>> exceptions) {
            this.waiter.ignoreAll(exceptions);
            return this;
        }

        public MobileDriverWaiter pollingEvery(Duration interval) {
            this.waiter.pollingEvery(interval);
            return this;
        }

        public MobileDriverWaiter withMessage(String message) {
            this.waiter.withMessage(() -> message);
            return this;
        }

        @Override
        public Boolean waitForTitleToBe(String title) {
            return waiter.until(ExpectedConditions.titleIs(title));
        }

        public Boolean waitForTitleToBe(String title, int timeout) {
            return waiter.until(ExpectedConditions.titleIs(title));
        }

        @Override
        public Boolean waitForTitleToContain(String title) {
            return waiter.until(ExpectedConditions.titleContains(title));
        }

        @Override
        public Boolean waitForUrlToBe(String url) {
            return waiter.until(ExpectedConditions.urlToBe(url));
        }

        @Override
        public Boolean waitForUrlToContain(String fraction) {
            return waiter.until(ExpectedConditions.urlContains(fraction));
        }

        @Override
        public Boolean waitForUrlToMatch(String regex) {
            return waiter.until(ExpectedConditions.urlMatches(regex));
        }

        @Override
        public WebElement waitForPresenceOfElementLocated(By locator) {
            return waiter.until(ExpectedConditions.presenceOfElementLocated(locator));
        }

        @Override
        public WebElement waitForVisibilityOfElementLocated(By locator) {
            return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        @Override
        public List<WebElement> waitForVisibilityOfAllElementsLocatedBy(By locator) {
            List<WebElement> mobileElements = new ArrayList<>();
            List<WebElement> webElements = waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            webElements.forEach(x -> mobileElements.add((WebElement) x));
            return mobileElements;
        }

        @Override
        public List<WebElement> waitForVisibilityOfAllElements(WebElement... elements) {
            List<WebElement> mobileElements = new ArrayList<>();
            List<WebElement> webElements = waiter.until(ExpectedConditions.visibilityOfAllElements(elements));
            webElements.forEach(x -> mobileElements.add((WebElement) x));
            return mobileElements;
        }

        @Override
        public List<WebElement> waitForVisibilityOfAllElements(List<WebElement> elements) {
            List<WebElement> webElements = new ArrayList<>(elements);
            return new ArrayList<>(waiter.until(ExpectedConditions.visibilityOfAllElements(webElements)));
        }

        @Override
        public WebElement waitForVisibilityOf(WebElement element) {
            return waiter.until(ExpectedConditions.visibilityOf(element));
        }

        @Override
        public List<WebElement> waitForPresenceOfAllElementsLocatedBy(By locator) {
            return  waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        }

        @Override
        public Boolean waitForTextToBePresentInElement(WebElement element, String text) {
            return waiter.until(ExpectedConditions.textToBePresentInElement(element, text));
        }

        @Override
        public Boolean waitForTextToBePresentInElementLocated(By locator, String text) {
            return waiter.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        }

        @Override
        public Boolean waitForTextToBePresentInElementValue(WebElement element, String text) {
            return waiter.until(ExpectedConditions.textToBePresentInElementValue(element, text));
        }

        @Override
        public Boolean waitForTextToBePresentInElementValue(By locator, String text) {
            return waiter.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
        }

        @Override
        public void waitForFrameToBeAvailableAndSwitchToIt(String frameLocator) {
            waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        }

        @Override
        public void waitForFrameToBeAvailableAndSwitchToIt(By locator) {
            waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
        }

        @Override
        public void waitForFrameToBeAvailableAndSwitchToIt(int frameLocator) {
            waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        }

        @Override
        public void waitForFrameToBeAvailableAndSwitchToIt(WebElement frameLocator) {
            waiter.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
        }

        @Override
        public Boolean waitForInvisibilityOfElementLocated(By locator) {
            return waiter.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }

        @Override
        public Boolean waitForInvisibilityOfElementWithText(By locator, String text) {
            return waiter.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
        }

        @Override
        public WebElement waitForElementToBeClickable(By locator) {
            return waiter.until(ExpectedConditions.elementToBeClickable(locator));
        }

        @Override
        public WebElement waitForElementToBeClickable(WebElement element) {
            return (WebElement) waiter.until(ExpectedConditions.elementToBeClickable(element));
        }

        @Override
        public Boolean waitForStalenessOf(WebElement element) {
            return waiter.until(ExpectedConditions.stalenessOf(element));
        }

        @Override
        public void waitForRefreshed(ExpectedCondition<WebElement> condition) {
            waiter.until(ExpectedConditions.refreshed(condition));
        }

        @Override
        public Boolean waitForElementToBeSelected(WebElement element) {
            return waiter.until(ExpectedConditions.elementToBeSelected(element));
        }

        @Override
        public Boolean waitForElementSelectionStateToBe(WebElement element, boolean selected) {
            return waiter.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
        }

        @Override
        public Boolean waitForElementToBeSelected(By locator) {
            return waiter.until(ExpectedConditions.elementToBeSelected(locator));
        }

        @Override
        public Boolean waitForElementSelectionStateToBe(By locator, boolean selected) {
            return waiter.until(ExpectedConditions.elementSelectionStateToBe(locator, selected));
        }

        @Override
        public Alert waitForAlertToBePresent() {
            return waiter.until(ExpectedConditions.alertIsPresent());
        }

        @Override
        public Boolean waitForNumberOfWindowsToBe(int expectedNumberOfWindows) {
            return waiter.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
        }

        @Override
        public Boolean waitForConditionNotToBe(ExpectedCondition<?> condition) {
            return waiter.until(ExpectedConditions.not(condition));
        }

        @Override
        public Boolean waitForAttributeToBe(By locator, String attribute, String value) {
            return waiter.until(ExpectedConditions.attributeToBe(locator, attribute, value));
        }

        @Override
        public Boolean waitForTextToBe(By locator, String value) {
            return waiter.until(ExpectedConditions.textToBe(locator, value));
        }

        @Override
        public Boolean waitForTextToMatch(By locator, String pattern) {
            Pattern p = Pattern.compile(pattern);
            return waiter.until(ExpectedConditions.textMatches(locator, p));
        }

        @Override
        public List<WebElement> waitForNumberOfElementsToBeMoreThan(By locator, Integer number) {
            List<WebElement> webElements = waiter.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
            return new ArrayList<>(webElements);
        }

        @Override
        public List<WebElement> waitForNumberOfElementsToBeLessThan(By locator, Integer number) {
            List<WebElement> mobileElements = new ArrayList<>();
            List<WebElement> webElements = waiter.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, number));
            webElements.forEach(x -> mobileElements.add((WebElement) x));
            return mobileElements;
        }

        @Override
        public List<WebElement> waitForNumberOfElementsToBe(By locator, Integer number) {
            List<WebElement> mobileElements = new ArrayList<>();
            List<WebElement> webElements = waiter.until(ExpectedConditions.numberOfElementsToBe(locator, number));
            webElements.forEach(x -> mobileElements.add((WebElement) x));
            return mobileElements;
        }

        @Override
        public Boolean waitForAttributeToBe(WebElement element, String attribute, String value) {
            return waiter.until(ExpectedConditions.attributeToBe(element, attribute, value));
        }

        @Override
        public Boolean waitForAttributeToContain(WebElement element, String attribute, String value) {
            return waiter.until(ExpectedConditions.attributeContains(element, attribute, value));
        }

        @Override
        public Boolean waitForAttributeContains(By locator, String attribute, String value) {
            return waiter.until(ExpectedConditions.attributeContains(locator, attribute, value));
        }

        @Override
        public Boolean waitForAttributeToBeNotEmpty(WebElement element, String attribute) {
            return waiter.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
        }

        @Override
        public List<WebElement> waitForVisibilityOfNestedElementsLocatedBy(By parent, By childLocator) {
            List<WebElement> mobileElements = new ArrayList<>();
            List<WebElement> webElements = waiter.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parent, childLocator));
            webElements.forEach(x -> mobileElements.add((WebElement) x));
            return mobileElements;
        }

        @Override
        public List<WebElement> waitForVisibilityOfNestedElementsLocatedBy(WebElement element, By childLocator) {
            List<WebElement> mobileElements = new ArrayList<>();
            List<WebElement> webElements = waiter.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(element, childLocator));
            webElements.forEach(x -> mobileElements.add((WebElement) x));
            return mobileElements;
        }

        @Override
        public WebElement waitForPresenceOfNestedElementLocatedBy(By locator, By childLocator) {
            return (WebElement) waiter.until(ExpectedConditions.presenceOfNestedElementLocatedBy(locator, childLocator));
        }

        @Override
        public WebElement waitForPresenceOfNestedElementLocatedBy(WebElement element, By childLocator) {
            return (WebElement) waiter.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, childLocator));
        }

        @Override
        public List<WebElement> waitForPresenceOfNestedElementsLocatedBy(By parent, By childLocator) {
            List<WebElement> mobileElements = new ArrayList<>();
            List<WebElement> webElements = waiter.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(parent, childLocator));
            webElements.forEach(x -> mobileElements.add((WebElement) x));
            return mobileElements;
        }

        @Override
        public Boolean waitForInvisibilityOfAllElements(WebElement... elements) {
            return waiter.until(ExpectedConditions.invisibilityOfAllElements(elements));
        }

        @Override
        public Boolean waitForInvisibilityOfAllElements(List<WebElement> elements) {
            List<WebElement> webElements = new ArrayList<>(elements);
            return waiter.until(ExpectedConditions.invisibilityOfAllElements(webElements));
        }

        @Override
        public Boolean waitForAnyConditionToMatch(ExpectedCondition<?>... conditions) {
            return waiter.until(ExpectedConditions.or(conditions));
        }

        @Override
        public Boolean waitForAllConditionToMatch(ExpectedCondition<?>... conditions) {
            return waiter.until(ExpectedConditions.and(conditions));
        }

        @Override
        public Boolean waitForJavaScriptNotToThrowExceptions(String javaScript) {
            return waiter.until(ExpectedConditions.javaScriptThrowsNoExceptions(javaScript));
        }

        @Override
        public Object waitForJavaScriptToReturnValue(String javaScript) {
            return waiter.until(ExpectedConditions.jsReturnsValue(javaScript));
        }

        public boolean waitForAppStateToBe(ApplicationState appState) {
            waiter.withMessage("App is still not in " + appState.name() + " state after waiting for " + timeout + " second(s)");
            boolean result = waiter.until((ExpectedCondition<Boolean>) input -> {
                String appId = driver instanceof AndroidDriver ?
                        driver.getCapabilities().getCapability(UiAutomator2Options.APP_PACKAGE_OPTION).toString() :
                        driver.getCapabilities().getCapability(XCUITestOptions.BUNDLE_ID_OPTION).toString();
                return ((InteractsWithApps) driver).queryAppState(appId) == appState;
            });
            waiter.withMessage(() -> null);
            return result;
        }
}
