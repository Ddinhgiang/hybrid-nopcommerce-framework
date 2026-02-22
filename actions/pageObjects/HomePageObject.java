package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {

    private WebDriver driver;
    //Ham khoi tao (Constructor function)
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToRegisterLink() {
        waitForELementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToELement(driver, HomePageUI.REGISTER_LINK);
    }

    public void clickToLoginLink() {

    }

    public boolean isMyAccountLinkDisplayed() {
        waitForELementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForELementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToELement(driver, HomePageUI.MY_ACCOUNT_LINK);
    }
}
