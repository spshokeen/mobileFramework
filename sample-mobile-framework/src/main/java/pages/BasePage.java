package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.DriverUtils;
import utils.waits.MobileDriverWaiter;

import java.time.Duration;

public class BasePage {

    protected AppiumDriver driver;
    protected final MobileDriverWaiter waiter;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        waiter = new MobileDriverWaiter(this.driver, 30).pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
    }

}
