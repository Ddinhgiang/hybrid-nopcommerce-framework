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

    public void clickToActionByCountryName(String countryName, String actionName) {
        waitForELementClickable(driver, HomePageUI.DYNAMIC_ACTION_BY_COUNTRY_NAME, countryName, actionName);
    }

    public void clickLoadDataButton() {
        waitForELementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToELement(driver, HomePageUI.LOAD_DATA_BUTTON);

    }

    public void enterToTextBoxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSendKey) {
        waitForELementVisible(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName);
        int columnIndex = getListElementNumber(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForELementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, valueToSendKey, rowIndex, String.valueOf(columnIndex));
        //30.30
    }

    public void selectToDropdownByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSendKey) {
        waitForELementVisible(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName);
        int columnIndex = getListElementNumber(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForELementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        selectItemInDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, valueToSendKey, rowIndex, String.valueOf(columnIndex));
    }

    public void checkToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
        waitForELementVisible(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName);
        int columnIndex = getListElementNumber(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        waitForELementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
        checkToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));

    }
}
