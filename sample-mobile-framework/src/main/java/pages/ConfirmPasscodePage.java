package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ConfirmPasscodePage extends BasePage {

    public ConfirmPasscodePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='1']")
    private WebElement digitOne;

    @FindBy(xpath = "//*[contains(@text, 'Confirm passcode')]")
    private WebElement confirmPasscodeTitle;

    public void enterPasscodeSixTimesOne() {
        waiter.waitForVisibilityOf(confirmPasscodeTitle);
        for (int i = 0; i < 6; i++) {
            digitOne.click();
        }
    }
}
