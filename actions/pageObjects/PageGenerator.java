package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.user.UserAddressPageObject;
import pageObjects.user.UserCustomerInfoPO;
import pageObjects.user.UserOrderPO;
import pageObjects.user.UserRewardPointPO;
import pageObjects.user.UserHomePO;
import pageObjects.user.UserLoginPO;
import pageObjects.user.UserRegisterPO;

public class PageGenerator{
    public static UserHomePO getUserHomePage(WebDriver driver) {
        return new UserHomePO(driver);
    }
    public static UserLoginPO getUserLoginPage(WebDriver driver) {
        return new UserLoginPO(driver);
    }
    public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPO(driver);
    }
    public static UserCustomerInfoPO getUserCustomerPage(WebDriver driver) {
        return new UserCustomerInfoPO(driver);
    }
    public static UserOrderPO getUserOrderPage(WebDriver driver) {
        return new UserOrderPO(driver);
    }
    public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
        return new UserAddressPageObject(driver);
    }
    public static UserRewardPointPO getUserRewardPage(WebDriver driver) {
        return new UserRewardPointPO(driver);
    }
}
