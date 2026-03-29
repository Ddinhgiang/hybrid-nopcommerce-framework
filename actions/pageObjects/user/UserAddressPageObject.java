package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.AddressPageUI;

public class UserAddressPageObject extends UserSidebarPO {
    private WebDriver driver;

    public UserAddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserRewardPointPO openRewardPointPage() {
        waitForELementClickable(driver, AddressPageUI.REWARD_POINT_LINK);
        clickToELement(driver, AddressPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForELementClickable(driver, AddressPageUI.CUSTOMER_INFO_LINK);
        clickToELement(driver, AddressPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }
}
