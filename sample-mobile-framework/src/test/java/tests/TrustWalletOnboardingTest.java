package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TrustWalletOnboardingTest extends BaseTest {

    @Test(description = "Verify happy flow from onboarding to home screen", groups = {"onboarding"})
    public void testHappyPathOnboardingToHome() {
        getLogger().info("OnboardingPage: Tap 'OK' on device security popup");
        OnboardingPage onboardingPage = new OnboardingPage(driver);
        onboardingPage.tapOkDeviceSecurityPopUpButton();
        getLogger().info("OnboardingPage: Tap 'Create New Wallet'");
        onboardingPage.tapCreateNewWallet();

        getLogger().info("CreatePasscodePage: Enter passcode 1 six times");
        CreatePasscodePage createPasscodePage = new CreatePasscodePage(driver);
        createPasscodePage.enterPasscodeSixTimesOne();

        getLogger().info("ConfirmPasscodePage: Confirm passcode 1 six times");
        ConfirmPasscodePage confirmPasscodePage = new ConfirmPasscodePage(driver);
        confirmPasscodePage.enterPasscodeSixTimesOne();

        getLogger().info("EnableNotificationsPage: Tap 'Skip' to disable notifications");
        EnableNotificationsPage enableNotificationsPage = new EnableNotificationsPage(driver);
        enableNotificationsPage.tapSkipButton();

        getLogger().info("WalletReadyPage: Tap 'Skip' to proceed");
        WalletReadyPage walletReadyPage = new WalletReadyPage(driver);
        walletReadyPage.tapSkipButton();

        getLogger().info("HomePage: Verify user is on the home screen");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUserOnHomePage(), "User did not reach the Home screen");
    }

    @Test(description = "Verify Trending Token Screen", groups = {"onboarding"})
    public void testTrendingTokenScreen() {
        getLogger().info("OnboardingPage: Tap 'OK' on device security popup");
        OnboardingPage onboardingPage = new OnboardingPage(driver);
        onboardingPage.tapOkDeviceSecurityPopUpButton();
        getLogger().info("OnboardingPage: Tap 'Create New Wallet'");
        onboardingPage.tapCreateNewWallet();

        getLogger().info("CreatePasscodePage: Enter passcode 1 six times");
        CreatePasscodePage createPasscodePage = new CreatePasscodePage(driver);
        createPasscodePage.enterPasscodeSixTimesOne();

        getLogger().info("ConfirmPasscodePage: Confirm passcode 1 six times");
        ConfirmPasscodePage confirmPasscodePage = new ConfirmPasscodePage(driver);
        confirmPasscodePage.enterPasscodeSixTimesOne();

        getLogger().info("EnableNotificationsPage: Tap 'Skip' to disable notifications");
        EnableNotificationsPage enableNotificationsPage = new EnableNotificationsPage(driver);
        enableNotificationsPage.tapSkipButton();

        getLogger().info("WalletReadyPage: Tap 'Skip' to proceed");
        WalletReadyPage walletReadyPage = new WalletReadyPage(driver);
        walletReadyPage.tapSkipButton();

        getLogger().info("HomePage: Tap 'Trending' tab");
        HomePage homePage = new HomePage(driver);
        homePage.tapTrendingPage();

        getLogger().info("TrendingPage: Verify trending token screen is displayed");
        TrendingPage trendingPage = new TrendingPage(driver);
        trendingPage.verifyTrendingTokenScreen();
    }
}
