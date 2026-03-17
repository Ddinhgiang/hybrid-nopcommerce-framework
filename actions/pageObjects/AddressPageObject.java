package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;
import pageUIs.CustomerInfoPageUI;

public class AddressPageObject extends BasePage {
    private WebDriver driver;
    public AddressPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RewardPointPageObject openRewardPointPage() {
        waitForELementClickable(driver, AddressPageUI.REWARD_POINT_LINK);
        clickToELement(driver, AddressPageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewardPage(driver);
    }

    public CustomerInfoPageObject openCustomerInfoPage() {
        waitForELementClickable(driver, AddressPageUI.CUSTOMER_INFO_LINK);
        clickToELement(driver, AddressPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getCustomerPage(driver);
    }
}
