package pageObjects.jQuery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.jQuery.HomePageUI;


public class HomePO extends BasePage {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String pageNumber) {
        waitForELementClickable(driver, HomePageUI.DYNAMIC_PAGE_NUMBER_LOCATOR, pageNumber);
        clickToELement(driver, HomePageUI.DYNAMIC_PAGE_NUMBER_LOCATOR, pageNumber);
        sleepInSecond(2);
    }

    public boolean isPageActivedByNumber(String pageNumber) {
        waitForELementVisible(driver,HomePageUI.DYNAMIC_PAGE_ACTIVED_BY_NUMBER, pageNumber);
        return isElementDisplayed(driver,HomePageUI.DYNAMIC_PAGE_ACTIVED_BY_NUMBER, pageNumber);

    }

    public void enterToHeaderTextboxByName(String headerName, String value) {
        waitForELementVisible(driver, HomePageUI.DYNAMIC_HEADER_TEXTBOX_BY_NAME,headerName);
        sendKeyToElement(driver, HomePageUI.DYNAMIC_HEADER_TEXTBOX_BY_NAME, value,headerName);
        sendKeyToElement(driver, HomePageUI.DYNAMIC_HEADER_TEXTBOX_BY_NAME, Keys.ENTER,headerName);

    }

    public boolean isPageInforDisplayed(String female, String country, String male, String total) {
        waitForELementVisible(driver, HomePageUI.DYNAMIC_PAGE_INFO, female, country, male, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_PAGE_INFO, female, country, male, total);
    }
}
