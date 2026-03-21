package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.SidebarPageUI;

public class SidebarPageObject extends BasePage {
    private WebDriver driver;

    public SidebarPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public AddressPageObject openAddressPage() {
        waitForELementClickable(driver, SidebarPageUI.ADDRESS_LINK);
        clickToELement(driver, SidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }
    public RewardPointPageObject openRewardPointPage() {
        waitForELementClickable(driver, SidebarPageUI.REWARD_POINT_LINK);
        clickToELement(driver, SidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewardPage(driver);
    }

    public CustomerInfoPageObject openCustomerInfoPage() {
        waitForELementClickable(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        clickToELement(driver, SidebarPageUI.CUSTOMER_INFO_LINK);
        return PageGenerator.getCustomerPage(driver);
    }
    public OrderPageObject openOrderPage() {
        waitForELementClickable(driver, SidebarPageUI.ORDER_LINK);
        clickToELement(driver, SidebarPageUI.ORDER_LINK);
        return PageGenerator.getOrderPage(driver);
    }


}
