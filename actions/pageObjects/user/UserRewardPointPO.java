package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.RewardPointPageUI;

public class UserRewardPointPO extends UserSidebarPO {
    private WebDriver driver;
    public UserRewardPointPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserOrderPO openOrderPage() {
        waitForELementClickable(driver, RewardPointPageUI.ORDER_LINK);
        clickToELement(driver, RewardPointPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }
}
