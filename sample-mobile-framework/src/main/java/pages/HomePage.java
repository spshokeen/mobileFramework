package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage extends BasePage{

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy(xpath = "//*[contains(@resource-id, 'HomeNavigationButton')]")
    private WebElement homeNavigationButton;

    @FindBy(xpath = "//*[contains(@resource-id, 'TrendingTokenNavigationButton')]")
    private WebElement trendingTokenNavigationButton;



    public boolean isUserOnHomePage() {
        waiter.waitForVisibilityOf(homeNavigationButton);
        return homeNavigationButton.isDisplayed();
    }

    public void tapTrendingPage() {
        waiter.waitForElementToBeClickable(trendingTokenNavigationButton);
        trendingTokenNavigationButton.click();
    }
}
