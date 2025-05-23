package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class EnableNotificationsPage extends BasePage{

    public EnableNotificationsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }


    @FindBy(xpath = "//*[contains(@text,\"do it later\")]")
    private WebElement skipButton;

    @FindBy(xpath = "//*[contains(@text, 'Enable Notifications')]")
    private WebElement enableNotificationsTitle;

    public void tapSkipButton() {
        waiter.waitForElementToBeClickable(skipButton);
        skipButton.click();
    }
}
