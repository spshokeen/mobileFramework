package utils.waits;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public interface Waiter<T> {

    Boolean waitForTitleToBe(final String title);
    Boolean waitForTitleToContain(final String title);
    Boolean waitForUrlToBe(final String url);
    Boolean waitForUrlToContain(final String fraction);
    Boolean waitForUrlToMatch(final String regex);
    T waitForPresenceOfElementLocated(final By locator);
    T waitForVisibilityOfElementLocated(final By locator);
    List<T> waitForVisibilityOfAllElementsLocatedBy(final By locator);
    List<T> waitForVisibilityOfAllElements(final T... elements);
    List<T> waitForVisibilityOfAllElements(final List<T> elements);
    T waitForVisibilityOf(final T element);
    List<T> waitForPresenceOfAllElementsLocatedBy(final By locator);
    Boolean waitForTextToBePresentInElement(final T element, final String text);
    Boolean waitForTextToBePresentInElementLocated(final By locator, final String text);
    Boolean waitForTextToBePresentInElementValue(final T element, final String text);
    Boolean waitForTextToBePresentInElementValue(final By locator, final String text);
    void waitForFrameToBeAvailableAndSwitchToIt(final String frameLocator);
    void waitForFrameToBeAvailableAndSwitchToIt(final By locator);
    void waitForFrameToBeAvailableAndSwitchToIt(final int frameLocator);
    void waitForFrameToBeAvailableAndSwitchToIt(final T frameLocator);
    Boolean waitForInvisibilityOfElementLocated(final By locator);
    Boolean waitForInvisibilityOfElementWithText(final By locator, final String text);
    T waitForElementToBeClickable(final By locator);
    T waitForElementToBeClickable(final T element);
    Boolean waitForStalenessOf(final T element);
    void waitForRefreshed(final ExpectedCondition<T> condition);
    Boolean waitForElementToBeSelected(final T element);
    Boolean waitForElementSelectionStateToBe(final T element, final boolean selected);
    Boolean waitForElementToBeSelected(final By locator);
    Boolean waitForElementSelectionStateToBe(final By locator, final boolean selected);
    Alert waitForAlertToBePresent();
    Boolean waitForNumberOfWindowsToBe(final int expectedNumberOfWindows);
    Boolean waitForConditionNotToBe(final ExpectedCondition<?> condition);
    Boolean waitForAttributeToBe(final By locator, final String attribute, final String value);
    Boolean waitForTextToBe(final By locator, final String value);
    Boolean waitForTextToMatch(final By locator, final String pattern);
    List<T> waitForNumberOfElementsToBeMoreThan(final By locator, final Integer number);
    List<T> waitForNumberOfElementsToBeLessThan(final By locator, final Integer number);
    List<T> waitForNumberOfElementsToBe(final By locator, final Integer number);
    Boolean waitForAttributeToBe(final T element, final String attribute, final String value);
    Boolean waitForAttributeToContain(final T element, final String attribute, final String value);
    Boolean waitForAttributeContains(final By locator, final String attribute, final String value);
    Boolean waitForAttributeToBeNotEmpty(final T element, final String attribute);
    List<T> waitForVisibilityOfNestedElementsLocatedBy(final By parent, final By childLocator);
    List<T> waitForVisibilityOfNestedElementsLocatedBy(final T element, final By childLocator);
    T waitForPresenceOfNestedElementLocatedBy(final By locator, final By childLocator);
    T waitForPresenceOfNestedElementLocatedBy(final T element, final By childLocator);
    List<T> waitForPresenceOfNestedElementsLocatedBy(final By parent, final By childLocator);
    Boolean waitForInvisibilityOfAllElements(final T... elements);
    Boolean waitForInvisibilityOfAllElements(final List<T> elements);
    Boolean waitForAnyConditionToMatch(final ExpectedCondition<?>... conditions);
    Boolean waitForAllConditionToMatch(final ExpectedCondition<?>... conditions);
    Boolean waitForJavaScriptNotToThrowExceptions(final String javaScript);
    Object waitForJavaScriptToReturnValue(final String javaScript);

    /**
     * Not recommended to use thread sleep. Use explicit wait method instead.
     *
     * @param seconds to put the current thread in to sleep
     */
    default void delay(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
