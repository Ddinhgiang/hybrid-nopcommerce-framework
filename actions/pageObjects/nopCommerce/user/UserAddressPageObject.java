package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.user.UserAddressPageUI;

public class UserAddressPageObject extends UserSidebarPO {
    private WebDriver driver;

    public UserAddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserRewardPointPO openRewardPointPage() {
        waitForELementClickable(driver, UserAddressPageUI.REWARD_POINT_LINK);
        clickToELement(driver, UserAddressPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForELementClickable(driver, UserAddressPageUI.CUSTOMER_INFO_LINK);
        clickToELement(driver, UserAddressPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }
}
