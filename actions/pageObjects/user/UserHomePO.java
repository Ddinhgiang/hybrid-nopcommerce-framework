package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.user.UserHomePageUI;

public class UserHomePO extends BasePage {

    private WebDriver driver;
    //Ham khoi tao (Constructor function)
    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }


    public UserRegisterPO openRegisterPage() {
        waitForELementClickable(driver, UserHomePageUI.REGISTER_LINK);
        clickToELement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }

//    public HomePageObject clickToLoginLink() {
//
//    }

    public boolean isMyAccountLinkDisplayed() {
        waitForELementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForELementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToELement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }
}
