package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.UserRewardPointPageUI;

public class UserRewardPointPO extends UserSidebarPO {
    private WebDriver driver;
    public UserRewardPointPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserOrderPO openOrderPage() {
        waitForELementClickable(driver, UserRewardPointPageUI.ORDER_LINK);
        clickToELement(driver, UserRewardPointPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }
}
