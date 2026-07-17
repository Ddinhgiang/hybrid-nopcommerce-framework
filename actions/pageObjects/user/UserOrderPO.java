package pageObjects.user;

import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.UserOrderPageUI;

public class UserOrderPO extends UserSidebarPO {
    private WebDriver driver;
    public UserOrderPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserAddressPageObject openAddressPage() {
        waitForELementClickable(driver, UserOrderPageUI.ADDRESS_LINK);
        clickToELement(driver, UserOrderPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }
}
