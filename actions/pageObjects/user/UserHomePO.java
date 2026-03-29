package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.HomePageUI;

public class UserHomePO extends BasePage {

    private WebDriver driver;
    //Ham khoi tao (Constructor function)
    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }


    public UserRegisterPO openRegisterPage() {
        waitForELementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToELement(driver, HomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }

//    public HomePageObject clickToLoginLink() {
//
//    }

    public boolean isMyAccountLinkDisplayed() {
        waitForELementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForELementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToELement(driver, HomePageUI.MY_ACCOUNT_LINK);
    }
}
