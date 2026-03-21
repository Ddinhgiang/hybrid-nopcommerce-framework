package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends SidebarPageObject {
    private WebDriver driver;
    public CustomerInfoPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isGenderMaleSelected() {
        waitForELementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        waitForELementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
    }
    public String getLastNameTextboxValue() {
        waitForELementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
    }


    public String getEmailTextboxValue() {
        waitForELementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getCompanyTextboxValue() {
        waitForELementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");

    }

    public AddressPageObject openAddressPage() {
        waitForELementClickable(driver, CustomerInfoPageUI.ADDRESS_LINK);
        clickToELement(driver, CustomerInfoPageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }


//    public String getDayDropdownSelectedValue() {
//        waitForELementClickable(driver, CustomerInfoPageUI.DAY_DROPDOWN);
//        return getSelectedItemInDropdown(driver, CustomerInfoPageUI.DAY_DROPDOWN);
//    }
//
//    public String getMonthDropdownSelectedValue() {
//        waitForELementClickable(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
//        return getSelectedItemInDropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
//    }
//
//    public String getYearDropdownSelectedValue() {
//        waitForELementClickable(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
//        return getSelectedItemInDropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
//    }
}
