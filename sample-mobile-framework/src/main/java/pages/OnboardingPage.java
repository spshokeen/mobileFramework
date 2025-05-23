package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class OnboardingPage extends BasePage {


    public OnboardingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy(xpath = "//*[@resource-id='CreateNewWalletButton']")
    private WebElement createNewWalletButton;

    @FindBy(xpath = "//*[@resource-id='ImportWalletButton']")
    private WebElement importWalletButton;

    @FindBy(xpath = "//android.widget.TextView[@text='OK']")
    private WebElement deviceSecurityPopUp;

    public void tapCreateNewWallet() {
        waiter.waitForVisibilityOf(createNewWalletButton);
        createNewWalletButton.click();
    }

    public void tapImportWallet() {
        waiter.waitForVisibilityOf(importWalletButton);
        importWalletButton.click();
    }

    public void tapOkDeviceSecurityPopUpButton() {
        waiter.waitForVisibilityOf(deviceSecurityPopUp);
        deviceSecurityPopUp.click();
    }

    public boolean isDisplayed() {
        return createNewWalletButton.isDisplayed();
    }


}
