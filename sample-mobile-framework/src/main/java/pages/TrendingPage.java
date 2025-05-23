package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TrendingPage extends BasePage{

    public TrendingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy(xpath = "//*[@text='Trending tokens']")
    private WebElement trendingTokenPageTitle;

    @FindBy(xpath = "//*[contains(@resource-id, 'asset_name')]")
    private List<WebElement> trendingTokenNameList;

    @FindBy(xpath = "//*[contains(@resource-id, 'asset_price_change')]")
    private List<WebElement> trendingTokenPriceList;

    public void verifyTrendingTokenScreen(){
        waiter.waitForVisibilityOf(trendingTokenPageTitle);
        Assert.assertTrue(!trendingTokenNameList.isEmpty(),"Trending Token Name List is empty");
        Assert.assertTrue(!trendingTokenPriceList.isEmpty(),"Trending Token Price List is empty");
    }


}
