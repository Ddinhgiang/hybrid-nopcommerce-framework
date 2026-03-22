package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.SidebarPageUI;

public class UserSidebarPO extends BasePage {
    private WebDriver driver;

    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }
    public UserAddressPageObject openAddressPage() {
        waitForELementClickable(driver, SidebarPageUI.ADDRESS_LINK);
        clickToELement(driver, SidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }
    public UserRewardPointPO openRewardPointPage() {
        waitForELementClickable(driver, SidebarPageUI.REWARD_POINT_LINK);
        clickToELement(driver, SidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForELementClickable(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        clickToELement(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }
    public UserOrderPO openOrderPage() {
        waitForELementClickable(driver, SidebarPageUI.ORDER_LINK);
        clickToELement(driver, SidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }


}
