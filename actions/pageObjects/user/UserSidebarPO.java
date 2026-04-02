package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.UserSidebarPageUI;

public class UserSidebarPO extends BasePage {
    private WebDriver driver;

    public UserSidebarPO(WebDriver driver) {
        this.driver = driver;
    }
    public UserAddressPageObject openAddressPage() {
        waitForELementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        clickToELement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }
    public UserRewardPointPO openRewardPointPage() {
        waitForELementClickable(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        clickToELement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewardPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        waitForELementClickable(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        clickToELement(driver, UserSidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }
    public UserOrderPO openOrderPage() {
        waitForELementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToELement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }

    public UserSidebarPO openSidebarLinkByPageName(String pageName) {
        waitForELementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToELement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        switch (pageName) {
            case "Addresses":
                return PageGenerator.getUserAddressPage(driver);
            case "Reward points":
                return PageGenerator.getUserRewardPage(driver);
            case "Customer info":
                return PageGenerator.getUserCustomerPage(driver);
            case "Orders":
                return PageGenerator.getUserOrderPage(driver);
            default:
                throw new RuntimeException("Page Name iss not valid!!!");
        }
    }
    public void openSidebarLinkByPageNames(String pageName) {
        waitForELementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToELement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);

    }
}
